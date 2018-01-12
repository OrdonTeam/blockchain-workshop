package com.elpassion.blockchain.workshop

import com.elpassion.blockchain.workshop.solidity.SimplePactContract
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Credentials
import org.web3j.crypto.Sign
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract

@RestController
class SignController {

    private val url = "https://rinkeby.infura.io/0ZevQ4HkUCzCVBOsYZcQ"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)

    @GetMapping("/sign")
    fun sign(@Param("one") one: String, @Param("other") other: String, @Param("pactId") pactId: String, @Param("key") key: String): Sign.SignatureData? {
        val credentials = Credentials.create(key)
        val contract = SimplePactContract.load("0x88c0a2d6d0c8d19c63d8fb458e1cc6a8ca26e312", web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        val hash = contract.pactHash256(one, other, pactId).send()
        return Sign.signMessage(hash, credentials.ecKeyPair)
    }
}