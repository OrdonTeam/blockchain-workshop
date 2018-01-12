package com.elpassion.blockchain.workshop

import com.elpassion.blockchain.workshop.solidity.SimplePactContract
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Credentials
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract

@RestController
class PactsController {

    private val url = "https://rinkeby.infura.io/0ZevQ4HkUCzCVBOsYZcQ"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)

    @GetMapping("/pact")
    fun pact(@Param("one") one: String, @Param("other") other: String, @Param("pactId") pactId: String): Boolean {
        val credentials = Credentials.create("e672df0c9efe140752716a9290f4fd2f7343af38b5ff12cab72953253fa7c594")
        val contract = SimplePactContract.load("0x88c0a2d6d0c8d19c63d8fb458e1cc6a8ca26e312", web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        return contract.isConfirmed(one, other, pactId).send()
    }
}