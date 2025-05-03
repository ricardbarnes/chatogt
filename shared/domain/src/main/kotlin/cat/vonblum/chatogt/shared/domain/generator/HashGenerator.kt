package cat.vonblum.chatogt.shared.domain.generator

interface HashGenerator {

    fun hash(value: String): String

}