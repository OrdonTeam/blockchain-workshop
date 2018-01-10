package com.elpassion.blockchain.workshop.solidity

import org.junit.Assert
import org.junit.Test
import org.web3j.abi.EventEncoder
import org.web3j.abi.EventValues
import org.web3j.abi.FunctionReturnDecoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.Event
import org.web3j.abi.datatypes.Type
import org.web3j.crypto.Credentials
import org.web3j.crypto.Keys
import org.web3j.crypto.Sign
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.core.methods.request.EthFilter
import org.web3j.protocol.core.methods.response.EthLog
import org.web3j.protocol.core.methods.response.Log
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import java.math.BigInteger
import java.util.*
import java.util.concurrent.TimeUnit

class SignedOffChainPactContractWithEventsTest {

    private val url = "http://127.0.0.1:8545"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)
    private val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
    private val one = Credentials.create(Keys.createEcKeyPair())
    private val other = Credentials.create(Keys.createEcKeyPair())
    private val pactId = Credentials.create(Keys.createEcKeyPair()).address
    private val nonce = BigInteger.valueOf(Math.abs(Random().nextLong()))

    @Test
    fun shouldReceiveEvents() {
        val (contractAddress, blockNumber) = deployContract()
        val contract = SignedOffChainPactContractWithEvents.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        val subscriber = contract.pactConfirmedEventObservable(DefaultBlockParameter.valueOf(blockNumber), DefaultBlockParameter.valueOf(BigInteger.valueOf(2_000_000L))).test()
        uploadPact(contract)
        subscriber.awaitValueCount(1, 30, TimeUnit.SECONDS)
    }

    @Test
    fun shouldRetrieveEvents() {
        val (contractAddress, blockNumber) = deployContract()
        val contract = SignedOffChainPactContractWithEvents.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        uploadPact(contract)
        val event = contract.getPactConfirmedEvent(web3j, blockNumber).first()
        Assert.assertEquals(one.address, event.one)
        Assert.assertEquals(other.address, event.other)
        Assert.assertEquals(pactId, event.pactId)
    }

    private fun deployContract(): Pair<String, BigInteger> {
        val contract = SignedOffChainPactContractWithEvents.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        return contract.contractAddress to contract.transactionReceipt.get().blockNumber
    }

    private fun uploadPact(contract: SignedOffChainPactContractWithEvents) {
        val hash = contract.pactHash256(one.address, other.address, pactId, nonce).send()
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        contract.uploadPact(one.address, other.address, pactId,
                nonce, byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s,
                nonce, byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s).send()
    }

}

private fun SignedOffChainPactContractWithEvents.getPactConfirmedEvent(web3j: JsonRpc2_0Web3j, blockNumber: BigInteger): List<SignedOffChainPactContractWithEvents.PactConfirmedEventResponse> {
    val nonIndexedParameters = listOf(object : TypeReference<Address>() {}, object : TypeReference<Address>() {}, object : TypeReference<Address>() {})
    val event = Event("PactConfirmed", emptyList(), nonIndexedParameters)
    val filter = EthFilter(DefaultBlockParameter.valueOf(blockNumber), DefaultBlockParameter.valueOf(BigInteger.valueOf(2_000_000L)), contractAddress)
    filter.addSingleTopic(EventEncoder.encode(event))
    return web3j.ethGetLogs(filter).send().logs.map { log -> (log as EthLog.LogObject).get() }
            .map { log ->
                eventFromLog(log)
            }
}

private fun eventFromLog(log: Log): SignedOffChainPactContractWithEvents.PactConfirmedEventResponse {
    return SignedOffChainPactContractWithEvents.PactConfirmedEventResponse().apply {
        val eventValues = extractEventParameters(log)
        one = eventValues.nonIndexedValues[0].value as String
        other = eventValues.nonIndexedValues[1].value as String
        pactId = eventValues.nonIndexedValues[2].value as String
    }
}

private fun extractEventParameters(log: Log): EventValues {
    val nonIndexedParameters = listOf(object : TypeReference<Address>() {}, object : TypeReference<Address>() {}, object : TypeReference<Address>() {})
    return EventValues(emptyList(), FunctionReturnDecoder.decode(log.data, nonIndexedParameters as List<TypeReference<Type<*>>>))
}
