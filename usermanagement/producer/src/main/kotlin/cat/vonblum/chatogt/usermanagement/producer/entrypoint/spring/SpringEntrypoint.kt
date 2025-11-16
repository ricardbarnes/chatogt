package cat.vonblum.chatogt.usermanagement.producer.entrypoint.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(
    basePackages = [
        "cat.vonblum.chatogt.usermanagement.producer.config.shared.spring",
    ]
)
@SpringBootApplication
class SpringEntrypoint

fun main(args: Array<String>) {
    runApplication<SpringEntrypoint>(*args)
}
