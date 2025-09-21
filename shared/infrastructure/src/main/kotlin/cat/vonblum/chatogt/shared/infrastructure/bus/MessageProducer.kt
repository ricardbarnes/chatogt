package cat.vonblum.chatogt.shared.infrastructure.bus

interface MessageProducer {

    fun send(envelope: MessageEnvelope)

}