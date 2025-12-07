package cat.vonblum.chatogt.usermanagement.domain.event

class UnsupportedEvent private constructor(message: String) :
    RuntimeException(message) {

    companion object {

        fun becauseOf(event: Event): UnsupportedEvent {
            val className = event::class.qualifiedName ?: event::class.simpleName ?: "Unknown"
            return UnsupportedEvent("Unsupported event type $className")
        }

    }

}