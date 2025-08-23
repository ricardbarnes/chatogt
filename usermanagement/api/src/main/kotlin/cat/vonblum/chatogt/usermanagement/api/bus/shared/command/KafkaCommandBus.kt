package cat.vonblum.chatogt.usermanagement.api.bus.shared.command

import cat.vonblum.chatogt.shared.domain.command.Command
import cat.vonblum.chatogt.shared.domain.command.CommandBus
import org.springframework.stereotype.Component

@Component
class KafkaCommandBus : CommandBus {

    override fun dispatch(command: Command) {
        TODO("Not yet implemented")
    }

}