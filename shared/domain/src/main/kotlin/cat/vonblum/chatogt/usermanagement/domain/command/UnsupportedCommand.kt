package cat.vonblum.chatogt.usermanagement.domain.command

class UnsupportedCommand private constructor(message: String) :
    RuntimeException(message) {

    companion object {

        fun becauseOf(command: Command): UnsupportedCommand {
            val className = command::class.qualifiedName ?: command::class.simpleName ?: "Unknown"
            return UnsupportedCommand("Unsupported command type $className")
        }

    }

}