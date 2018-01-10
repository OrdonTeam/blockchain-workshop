package com.elpassion.blockchain.workshop.solidity

import org.junit.Assert.assertTrue
import org.junit.Test
import org.web3j.crypto.Credentials
import org.web3j.crypto.Keys
import org.web3j.crypto.Sign
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import java.math.BigInteger
import java.util.*

class SignedPactContractTest {

    private val url = "http://127.0.0.1:8545"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)
    private val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
    private val one = Credentials.create(Keys.createEcKeyPair())
    private val other = Credentials.create(Keys.createEcKeyPair())
    private val pactId = Credentials.create(Keys.createEcKeyPair()).address
    private val nonce = BigInteger.valueOf(Math.abs(Random().nextLong()))

    @Test
    fun shouldConfirmAddedPact() {
        val contract = SignedPactContract.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT).send()
        assertTrue(!contract.confirmedPacts(one.address, other.address, pactId).send())
        val hash = contract.pactHash256(one.address, other.address, pactId, nonce).send()
        val oneSignature = Sign.signMessage(hash, one.ecKeyPair)
        contract.addSignedPendingPact(one.address, other.address, pactId, nonce, byteArrayOf(oneSignature.v), oneSignature.r, oneSignature.s).send()
        assertTrue(!contract.confirmedPacts(one.address, other.address, pactId).send())
        val otherSignature = Sign.signMessage(hash, other.ecKeyPair)
        contract.confirmSignedPact(one.address, other.address, pactId, nonce, byteArrayOf(otherSignature.v), otherSignature.r, otherSignature.s).send()
        assertTrue(contract.confirmedPacts(one.address, other.address, pactId).send())
    }
}