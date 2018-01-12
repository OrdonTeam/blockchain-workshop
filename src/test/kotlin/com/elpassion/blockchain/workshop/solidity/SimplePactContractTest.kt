package com.elpassion.blockchain.workshop.solidity

import org.junit.Assert
import org.junit.Test
import org.web3j.crypto.Credentials
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
}