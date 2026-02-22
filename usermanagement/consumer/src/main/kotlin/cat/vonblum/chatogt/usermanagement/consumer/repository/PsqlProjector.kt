package cat.vonblum.chatogt.usermanagement.consumer.repository

import cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql.PsqlUserViewRepository
import cat.vonblum.chatogt.usermanagement.domain.event.Event
import cat.vonblum.chatogt.usermanagement.users.event.UserCreatedEvent
import cat.vonblum.chatogt.usermanagement.users.model.UserStatus
import cat.vonblum.chatogt.usermanagement.users.view.UserView

class PsqlProjector(private val repository: PsqlUserViewRepository) : Projector {

    override fun apply(event: Event) {
        if (event is UserCreatedEvent) {
            apply(event)
        }

        throw IllegalArgumentException("event type is not UserCreatedEvent")
    }

    private fun apply(event: UserCreatedEvent) {
        val view = UserView(
            event.id,
            event.email,
            UserStatus.ACTIVE.name,
            event.type,
            event.notificationTypes.toList()
        )
        repository.save(view)
    }

}