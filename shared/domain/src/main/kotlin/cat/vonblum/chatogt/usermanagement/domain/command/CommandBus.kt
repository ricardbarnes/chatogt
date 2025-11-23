package cat.vonblum.chatogt.usermanagement.domain.command

interface CommandBus {

    fun dispatch(command: Command)

}