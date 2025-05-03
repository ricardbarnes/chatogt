package cat.vonblum.chatogt.chats.consumer.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.chatogt.chats.consumer")
class SpringConsumerEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(SpringConsumerEntrypoint::class.java, *args);
}