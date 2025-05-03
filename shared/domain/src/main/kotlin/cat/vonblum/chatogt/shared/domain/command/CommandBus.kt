package cat.vonblum.chatogt.shared.domain.command

interface CommandBus {

    fun dispatch(command: Command)

}