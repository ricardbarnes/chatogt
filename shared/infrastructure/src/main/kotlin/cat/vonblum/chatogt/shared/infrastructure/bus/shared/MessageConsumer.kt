package cat.vonblum.chatogt.shared.infrastructure.bus.shared

interface MessageConsumer {

    fun consume(envelope: MessageEnvelope)

}