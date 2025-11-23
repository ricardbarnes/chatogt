package cat.vonblum.chatogt.usermanagement.infrastructure.generator.password4j

import cat.vonblum.chatogt.usermanagement.domain.generator.HashGenerator
import com.password4j.Password

class Argon2HashGenerator : HashGenerator {

    override fun hash(value: String): String {
        return Password.hash(value)
            .addRandomSalt()
            .withArgon2()
            .result
    }

}