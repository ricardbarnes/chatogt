package cat.vonblum.chatogt.usermanagement.domain.generator

interface HashGenerator {

    fun hash(value: String): String

}