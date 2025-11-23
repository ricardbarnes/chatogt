package cat.vonblum.chatogt.usermanagement.domain.valueobject

import java.util.UUID

object IdFaker {

    fun random(): UUID = UUID.randomUUID()

}