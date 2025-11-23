package cat.vonblum.chatogt.usermanagement.domain.generator

import java.util.UUID

interface IdGenerator {

    fun next(): UUID

}