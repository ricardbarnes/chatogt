package cat.vonblum.chatogt.chat.api.entrypoint.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cat.vonblum.chatogt.chat.api")
class SpringApiEntrypoint

fun main(args: Array<String>) {
    SpringApplication.run(SpringApiEntrypoint::class.java, *args);
}