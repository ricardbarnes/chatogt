package cat.vonblum.chatogt.shared.domain.valueobject

import io.github.serpro69.kfaker.Faker
import java.util.UUID

object ValueFaker {

    private val faker = Faker()

    fun uuid(): UUID = UUID.randomUUID()

    fun name(): String = faker.name.name()

}