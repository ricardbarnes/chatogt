package cat.vonblum.chatogt.chat.consumer.store

import cat.vonblum.chatogt.shared.domain.event.Event

interface WriteStore {

    fun save(event: Event)

}