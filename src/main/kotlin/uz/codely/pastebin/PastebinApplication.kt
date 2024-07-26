package uz.codely.pastebin

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PastebinApplication {
    @Bean
    fun modelMapper () : ModelMapper {
        return ModelMapper()
    }
}

fun main(args: Array<String>) {
    runApplication<PastebinApplication>(*args)
}
