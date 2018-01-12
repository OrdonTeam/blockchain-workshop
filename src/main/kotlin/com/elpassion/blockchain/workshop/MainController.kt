package com.elpassion.blockchain.workshop

import com.elpassion.blockchain.workshop.solidity.SimplePactContract
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Credentials
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import java.util.*

@RestController
class MainController {

    private val url = "https://rinkeby.infura.io/0ZevQ4HkUCzCVBOsYZcQ"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)

    @GetMapping("/hello")
    fun helloWorld() = "Hello world"

    @PostMapping(value = "/add_pact", consumes = arrayOf("application/json"))
    fun addPact(@RequestBody request: Request) {
        val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
        val contract = SimplePactContract.load("0x88c0a2d6d0c8d19c63d8fb458e1cc6a8ca26e312", web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        val decoder = Base64.getDecoder()
        with(request) {
            contract.addFullySignedPact(oneAddr, otherAddr, pactId, byteArrayOf(oneVrs.v), decoder.decode(oneVrs.r), decoder.decode(oneVrs.s),
                    byteArrayOf(otherVrs.v), decoder.decode(otherVrs.r), decoder.decode(otherVrs.s))
        }.send()
        println(request)
    }
}

data class Request(val oneAddr: String, val otherAddr: String, val oneVrs: VRSComplet, val otherVrs: VRSComplet, val pactId: String)
data class VRSComplet(val v: Byte, val r: String, val s: String)
