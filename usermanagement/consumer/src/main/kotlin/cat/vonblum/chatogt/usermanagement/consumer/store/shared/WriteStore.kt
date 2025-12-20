package cat.vonblum.chatogt.usermanagement.consumer.store.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event

interface WriteStore {

    fun store(event: Event)

}