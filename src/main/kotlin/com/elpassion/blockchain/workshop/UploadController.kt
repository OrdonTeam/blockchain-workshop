package com.elpassion.blockchain.workshop

import com.elpassion.blockchain.workshop.solidity.SimplePactContract
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Credentials
import org.web3j.protocol.core.JsonRpc2_0Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Contract
import java.util.*

@RestController
class UploadController {

    private val url = "https://rinkeby.infura.io/0ZevQ4HkUCzCVBOsYZcQ"
    private val web3jService = HttpService(url)
    private val web3j = JsonRpc2_0Web3j(web3jService)

    @GetMapping("/upload")
    fun upload(@Param("one") one: String, @Param("other") other: String, @Param("pactId") pactId: String,
               @Param("oneV") oneV: Int, @Param("oneR") oneR: String, @Param("oneS") oneS: String,
               @Param("otherV") otherV: Int, @Param("otherR") otherR: String, @Param("otherS") otherS: String): String? {
        val credentials = Credentials.create("c65918c493e7f7dc268ac64d2e978ddf540d5995fda3e68680a5743dd1d8a106")
        val contract = SimplePactContract.load("0x88c0a2d6d0c8d19c63d8fb458e1cc6a8ca26e312", web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT)
        return contract.addFullySignedPact(one, other, pactId,
                byteArrayOf(oneV.toByte()), oneR.decode(), oneS.decode(),
                byteArrayOf(otherV.toByte()), otherR.decode(), otherS.decode()
        ).send().transactionHash
    }
}

private fun String.decode(): ByteArray {
    return Base64.getDecoder().decode(this)
}
