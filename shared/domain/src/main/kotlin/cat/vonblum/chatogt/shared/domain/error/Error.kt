package cat.vonblum.chatogt.shared.domain.error

import kotlin.Exception

abstract class Error(override val message: String) : Exception() {

    fun message(): String {
        return message
    }

}