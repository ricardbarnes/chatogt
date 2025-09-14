package cat.vonblum.chatogt.shared.infrastructure.config.shared.spring

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.common.serialization.UUIDDeserializer
import org.apache.kafka.common.serialization.UUIDSerializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import java.util.*

@Configuration
class SpringKafkaConfig {

    @Bean
    fun kafkaProducerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, Any> {
        return mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to UUIDSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )
    }

    @Bean
    fun kafkaProducer(
        @Qualifier("kafkaProducerProperties") properties: Map<String, Any>
    ): KafkaProducer<UUID, String> {
        return KafkaProducer(properties)
    }

    @Bean
    fun kafkaConsumerProperties(
        @Value("\${spring.kafka.bootstrap-servers}") bootstrapServers: String,
    ): Map<String, Any> {
        return mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to UUIDDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
        )
    }

    @Bean
    fun kafkaConsumer(
        @Qualifier("kafkaConsumerProperties") properties: Map<String, Any>
    ): KafkaConsumer<UUID, String> {
        return KafkaConsumer(properties)
    }

    @Bean
    fun producerFactory(
        @Qualifier("kafkaProducerProperties") properties: Map<String, Any>
    ): ProducerFactory<String, Any> {
        return DefaultKafkaProducerFactory(properties)
    }

    @Bean
    fun kafkaTemplate(
        producerFactory: ProducerFactory<String, Any>
    ): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory)
    }

}
