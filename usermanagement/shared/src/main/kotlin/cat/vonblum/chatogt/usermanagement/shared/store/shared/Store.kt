package cat.vonblum.chatogt.usermanagement.shared.store.shared

import cat.vonblum.chatogt.usermanagement.domain.event.Event

interface Store {

    fun append(event: Event)

}