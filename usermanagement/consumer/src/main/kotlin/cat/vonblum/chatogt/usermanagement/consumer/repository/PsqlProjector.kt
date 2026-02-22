package cat.vonblum.chatogt.usermanagement.consumer.repository

import cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql.PsqlUserViewMapper
import cat.vonblum.chatogt.usermanagement.consumer.repository.users.psql.PsqlUserViewRepository
import cat.vonblum.chatogt.usermanagement.domain.event.Event

class PsqlProjector(
    private val repository: PsqlUserViewRepository,
    private val mapper: PsqlUserViewMapper
) : Projector {

    override fun apply(event: Event) {
        TODO("Not yet implemented")
    }

}