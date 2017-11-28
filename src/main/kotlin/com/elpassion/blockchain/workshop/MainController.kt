package com.elpassion.blockchain.workshop

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/hello")
    fun helloWorld() = "Hello world"
}