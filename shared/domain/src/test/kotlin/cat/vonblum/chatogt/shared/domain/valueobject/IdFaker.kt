package cat.vonblum.chatogt.shared.domain.valueobject

object IdFaker {

    fun random(): Id = Id(ValueFaker.uuid())

}