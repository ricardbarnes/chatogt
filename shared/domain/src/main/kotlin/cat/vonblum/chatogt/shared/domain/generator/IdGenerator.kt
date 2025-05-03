package cat.vonblum.chatogt.shared.domain.generator

import java.util.UUID

interface IdGenerator {

    fun next(): UUID

}