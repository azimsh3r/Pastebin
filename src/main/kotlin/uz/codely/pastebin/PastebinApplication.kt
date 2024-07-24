package uz.codely.pastebin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PastebinApplication

fun main(args: Array<String>) {
    runApplication<PastebinApplication>(*args)
}
