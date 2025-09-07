package cat.vonblum.chatogt.shared.infrastructure.bus.command.shared

interface MessageProducer {

    fun send(envelope: MessageEnvelope)

}