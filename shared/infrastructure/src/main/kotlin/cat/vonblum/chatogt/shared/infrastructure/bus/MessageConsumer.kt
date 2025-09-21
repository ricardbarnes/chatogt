package cat.vonblum.chatogt.shared.infrastructure.bus

interface MessageConsumer {

    fun consume(envelope: MessageEnvelope)

}