package com.elpassion.blockchain.workshop.solidity

import org.junit.After
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.web3j.crypto.Credentials
import org.web3j.crypto.Keys
import org.web3j.crypto.Sign
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import java.math.BigInteger
import java.util.concurrent.TimeUnit

class SimplePactContractTest {

    private val url = "http://localhost:8545"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)
    private val serverCredentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
    private val one = Credentials.create(Keys.createEcKeyPair())
    private val other = Credentials.create(Keys.createEcKeyPair())
    private val contract = SimplePactContract.deploy(web3j, serverCredentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()

    @Test
    fun shouldNotConfirmPactByDefault() {
        Assert.assertFalse(contract.isConfirmed(one.address, other.address, "pact-id").send())
    }

    @Test
    fun aaa() {
        val hash = contract.pactHash256(one.address, other.address, "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                one.address, other.address, "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
        Assert.assertTrue(contract.isConfirmed(one.address, other.address, "pact-id").send())
    }

    @Test(expected = RuntimeException::class)
    fun `should check one's signature before adding fully pre signed pact`() {
        val hash = contract.pactHash256("0x0", other.address, "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                "0x0", other.address, "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
    }

    @Test(expected = RuntimeException::class)
    fun `should check other's signature before adding fully pre signed pact`() {
        val hash = contract.pactHash256(one.address, "0x0", "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                one.address, "0x0", "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
    }

    @Test
    fun `should receive events`() {
        val subscriber = contract.pactConfirmedEventObservable(
                DefaultBlockParameter.valueOf(contract.transactionReceipt.get().blockNumber),
                DefaultBlockParameter.valueOf(BigInteger.valueOf(10_000_000L))).test()
        emitPactConfirmedEvent()
        subscriber.awaitValueCount(1, 1, TimeUnit.MINUTES)
    }

    @Test
    fun `should retrieve events from before subscribe`() {
        emitPactConfirmedEvent()
        val subscriber = contract.pactConfirmedEventObservable(
                DefaultBlockParameter.valueOf(contract.transactionReceipt.get().blockNumber),
                DefaultBlockParameter.valueOf(BigInteger.valueOf(10_000_000L))).test()
        subscriber.awaitValueCount(1, 1, TimeUnit.MINUTES)
    }

    private fun emitPactConfirmedEvent() {
        val hash = contract.pactHash256(one.address, other.address, "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                one.address, other.address, "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
    }
}