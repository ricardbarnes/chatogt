package cat.vonblum.chatogt.usermanagement.api.entrypoint.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "cat.vonblum.chatogt.usermanagement.api"
    ]
)
class SpringEntrypoint

fun main(args: Array<String>) {
    runApplication<SpringEntrypoint>(*args)
}
