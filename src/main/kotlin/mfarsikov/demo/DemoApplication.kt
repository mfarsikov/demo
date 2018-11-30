package mfarsikov.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.io.File

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class Controller {

    private val restTemplate = RestTemplate()

    val file = File("/data/names.txt").also {
        if (!it.exists()) {
            it.createNewFile()
        }
    }

    @GetMapping("/greeting")
    fun save(@RequestParam(required = false, defaultValue = "world") name: String = "world") = "Hello $name!"

    @PostMapping("/messages")
    fun addMessage(@RequestBody message: String) {
        file.appendText("$message, ")
    }

    @GetMapping("/messages")
    fun getMessages() = file.readText()

    @GetMapping("/ping")
    fun health() = "pong"

    @GetMapping("/ping-ping")
    fun pingPing() = "pong-" + restTemplate.getForEntity("http://greeter:8080/ping", String::class.java).body

}
