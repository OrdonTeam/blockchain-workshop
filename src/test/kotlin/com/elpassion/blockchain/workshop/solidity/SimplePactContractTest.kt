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
    fun shouldConfirmAddedPact() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.addPendingPact(one, other, "pact-id").send()
        contract.confirmPact(one, other, "pact-id").send()
        assert(contract.isConfirmed(one, other, "pact-id").send())
    }

    @Test
    fun shouldNotConfirmPactByDefault() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        Assert.assertFalse(contract.isConfirmed(one, other, "pact-id").send())
    }

    @Test
    fun `pact should not be confirmed after adding pending`() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.addPendingPact(one, other, "pact-id").send()
        Assert.assertFalse(contract.isConfirmed(one, other, "pact-id").send())
    }

    @Test(expected = RuntimeException::class)
    fun `should not confirm not pending pact`() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.confirmPact(one, other, "pact-id").send()
    }

    @Test(expected = RuntimeException::class)
    fun `should not allow other to add pact on our behalf`() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.addPendingPact("0x0", other, "pactId").send()
    }

    @Test(expected = RuntimeException::class)
    fun `should not allow to confirm pact on our behalf`() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.addPendingPact(one, "0x0", "pact-id").send()
        contract.confirmPact(one, "0x0", "pact-id").send()
    }

    @Test
    fun `should add pre signed pact`() {
        //Contract is created earlier
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        //A: We sign pact here
        val newOne = Credentials.create(Keys.createEcKeyPair())
        val hash = contract.pactHash256(newOne.address, other, "pact-id").send()
        val signature = Sign.signMessage(hash, newOne.ecKeyPair)
        //B: Here we received signature and we are adding pact to contract
        contract.addSignedPact(newOne.address, other, "pact-id", byteArrayOf(signature.v), signature.r, signature.s).send()
        Assert.assertTrue(contract.isConfirmed(newOne.address, other, "pact-id").send())
    }

    @Test(expected = RuntimeException::class)
    fun `should check signature before adding signed pact`() {
        //Contract is created earlier
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        //A: We sign pact here
        val newOne = Credentials.create(Keys.createEcKeyPair())
        val hash = contract.pactHash256("0x0", other, "pact-id").send()
        val signature = Sign.signMessage(hash, newOne.ecKeyPair)
        //B: Here we received signature and we are adding pact to contract
        contract.addSignedPact("0x0", other, "pact-id", byteArrayOf(signature.v), signature.r, signature.s).send()
    }
}