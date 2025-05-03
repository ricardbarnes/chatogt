package cat.vonblum.chatogt.chats.producer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.chatogt.chats.producer")
class SpringProducerEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(SpringProducerEntrypoint::class.java, *args)
}