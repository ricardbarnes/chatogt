package cat.vonblum.chatogt.shared.domain.aggregate

import cat.vonblum.chatogt.shared.domain.event.Event
import kotlin.reflect.KClass
import kotlin.reflect.jvm.isAccessible

object AggregateEventRehydrator {
    fun <T : AggregateRoot> rehydrate(type: KClass<T>, events: List<Event>): T {
        val constructor = type.constructors.firstOrNull { it.parameters.isEmpty() }
            ?: throw IllegalArgumentException("No zero-arg constructor found for ${type.simpleName}")
        val aggregate = constructor.call()
        val applyMethod = type.members.first { it.name == "applyEvents" }
        applyMethod.isAccessible = true
        applyMethod.call(aggregate, events)
        return aggregate
    }
}

