package cat.vonblum.chatogt.shared.domain.valueobject

import cat.vonblum.chatogt.shared.domain.valueobject.FakerObject.faker

object StringFaker {

    fun name(): String = faker.name.name()

    fun password(): String = faker.drivingLicense.license()

}