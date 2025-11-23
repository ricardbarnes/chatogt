package cat.vonblum.chatogt.chat.consumer.store

import cat.vonblum.chatogt.usermanagement.domain.event.Event

interface WriteStore {

    fun save(event: Event)

}