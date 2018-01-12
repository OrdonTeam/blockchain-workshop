package com.elpassion.blockchain.workshop.solidity

import org.junit.Assert
import org.junit.Test
import org.web3j.crypto.Credentials
import org.web3j.crypto.Keys
import org.web3j.crypto.Sign
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract

class SimplePactContractTest {

    private val url = "http://localhost:8545"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)
    private val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
    private val one = credentials.address
    private val other = credentials.address

    @Test
    fun shouldNotConfirmPactByDefault() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        Assert.assertFalse(contract.isConfirmed(one, other, "pact-id").send())
    }

    @Test
    fun `should add fully pre signed pact`() {
        //Contract is created earlier
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        val newOne = Credentials.create(Keys.createEcKeyPair())
        val newOther = Credentials.create(Keys.createEcKeyPair())
        val hash = contract.pactHash256(newOne.address, newOther.address, "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, newOne.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, newOther.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                newOne.address, newOther.address, "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
        Assert.assertTrue(contract.isConfirmed(newOne.address, newOther.address, "pact-id").send())
    }

    @Test(expected = RuntimeException::class)
    fun `should check one's signature before adding fully pre signed pact`() {
        //Contract is created earlier
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        val newOne = Credentials.create(Keys.createEcKeyPair())
        val newOther = Credentials.create(Keys.createEcKeyPair())
        val hash = contract.pactHash256("0x0", newOther.address, "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, newOne.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, newOther.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                "0x0", newOther.address, "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
    }

    @Test(expected = RuntimeException::class)
    fun `should check other's signature before adding fully pre signed pact`() {
        //Contract is created earlier
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        val newOne = Credentials.create(Keys.createEcKeyPair())
        val newOther = Credentials.create(Keys.createEcKeyPair())
        val hash = contract.pactHash256(newOne.address, "0x0", "pact-id").send()
        //A: We sign pact here
        val oneSignature = Sign.signMessage(hash, newOne.ecKeyPair)
        //B: We sign pact here
        val otherSignature = Sign.signMessage(hash, newOther.ecKeyPair)
        //On server we add pact
        contract.addFullySignedPact(
                newOne.address, "0x0", "pact-id",
                byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s,
                byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s
        ).send()
    }


}