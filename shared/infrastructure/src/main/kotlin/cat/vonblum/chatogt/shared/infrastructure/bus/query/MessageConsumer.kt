package cat.vonblum.chatogt.shared.infrastructure.bus.query

import cat.vonblum.chatogt.shared.infrastructure.bus.MessageEnvelope

interface MessageConsumer {

    fun onMessage(envelope: MessageEnvelope)

}