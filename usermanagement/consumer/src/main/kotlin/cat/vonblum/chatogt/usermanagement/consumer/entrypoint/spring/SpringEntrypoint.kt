package cat.vonblum.chatogt.usermanagement.consumer.entrypoint.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "cat.vonblum.chatogt.usermanagement.consumer",
        "cat.vonblum.chatogt.usermanagement.shared"
    ]
)
class SpringEntrypoint

fun main(args: Array<String>) {
    runApplication<SpringEntrypoint>(*args)
}
