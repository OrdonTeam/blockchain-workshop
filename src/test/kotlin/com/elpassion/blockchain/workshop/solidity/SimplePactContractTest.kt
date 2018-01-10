package com.elpassion.blockchain.workshop.solidity

import org.junit.Test
import org.web3j.crypto.Credentials
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract

class SimplePactContractTest {

    private val url = "http://127.0.0.1:8545"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)
    private val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
    private val serverAddress = credentials.address

    @Test
    fun shouldConfirmAddedPact() {
        val contract = SimplePactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        contract.addPendingPact(serverAddress, serverAddress, "pactId").send()
        contract.confirmPact(serverAddress, serverAddress, "pactId").send()
        assert(contract.isConfirmedPact(serverAddress, serverAddress, "pactId").send())
    }
}