package cat.vonblum.chatogt.shared.domain.query

import cat.vonblum.chatogt.shared.domain.annotation.UsedBy

@Suppress("unused")
@UsedBy("query bus implementations")
interface QueryBus {

    fun ask(query: Query): Response?

}