package cat.vonblum.chatogt.chats.api.entrypoint

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.chatogt.chats.api")
class SpringApiEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(SpringApiEntrypoint::class.java, *args);
}