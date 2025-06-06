package cat.vonblum.chatogt.usermanagement.api.entrypoint

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringEntrypoint

fun main(args: Array<String>) {
    runApplication<SpringEntrypoint>(*args)
}
