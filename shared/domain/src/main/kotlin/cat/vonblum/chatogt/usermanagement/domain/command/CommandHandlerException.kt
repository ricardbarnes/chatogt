package cat.vonblum.chatogt.usermanagement.domain.command

import cat.vonblum.chatogt.usermanagement.domain.error.Error

abstract class CommandHandlerException(message: String) : Error(message)