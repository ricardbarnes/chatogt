package cat.vonblum.chatogt.usermanagement.producer.handler.command.users.kafka

import cat.vonblum.chatogt.usermanagement.infrastructure.handler.command.CommandDispatcher
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener

class KafkaUserCommandHandler(
    private val mapper: KafkaUserCommandMapper,
    private val dispatcher: CommandDispatcher
) {

    @KafkaListener(
        topics = ["\$handler.commands.users.kafka.topic"],
        groupId = "\$handler.shared.kafka.consumer-group-id",
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        // TODO
    }

}