package cat.vonblum.chatogt.shared.domain.valueobject

import java.util.UUID

object IdFaker {

    fun random(): UUID = UUID.randomUUID()

}