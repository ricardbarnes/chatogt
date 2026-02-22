package cat.vonblum.chatogt.usermanagement.consumer.repository

import cat.vonblum.chatogt.usermanagement.domain.event.Event

interface Projection {

    fun apply(event: Event)

}