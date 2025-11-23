package cat.vonblum.chatogt.usermanagement.domain.query

import cat.vonblum.chatogt.usermanagement.domain.annotation.UsedBy

@Suppress("unused")
@UsedBy("query bus implementations")
interface QueryBus {

    fun ask(query: Query): Response?

}