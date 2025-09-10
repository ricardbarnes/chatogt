package cat.vonblum.chatogt.shared.infrastructure.bus.command

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope

interface MessageProducer {

    fun send(envelope: MessageEnvelope)

}