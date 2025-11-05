package cat.vonblum.chatogt.chat.consumer.store.mongo

import cat.vonblum.chatogt.shared.domain.event.Event

interface WriteStore {

    fun save(event: Event)

}