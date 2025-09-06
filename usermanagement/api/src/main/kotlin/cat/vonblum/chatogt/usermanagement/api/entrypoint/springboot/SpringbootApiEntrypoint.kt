package cat.vonblum.chatogt.usermanagement.api.entrypoint.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "cat.vonblum.chatogt.usermanagement.api.config.shared.springboot",
        "cat.vonblum.chatogt.usermanagement.api.config.users.springboot",
    ]
)
class SpringEntrypoint

fun main(args: Array<String>) {
    runApplication<SpringEntrypoint>(*args)
}
