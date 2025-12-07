package cat.vonblum.chatogt.usermanagement.consumer.handler.users.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener

class KafkaUserEventHandler(
    private val mapper: KafkaUserEventMapper,
) {

    @KafkaListener(
        topics = ["\${handler.events.users.kafka.topic}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun handle(record: ConsumerRecord<String, ByteArray>) {
        println(record)
    }

}