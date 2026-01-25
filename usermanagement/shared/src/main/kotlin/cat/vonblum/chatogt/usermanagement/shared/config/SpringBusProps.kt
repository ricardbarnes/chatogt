package cat.vonblum.chatogt.usermanagement.shared.config

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@ConfigurationProperties(prefix = "bus")
@Validated
data class SpringBusProps(

    @get:NotEmpty(message = "Command buses cannot be empty")
    @get:Valid
    val commands: Map<@NotEmpty(message = "Aggregate name for commands cannot be empty") String, @Valid BusProperties>,

    @get:NotEmpty(message = "Query buses cannot be empty")
    @get:Valid
    val queries: Map<@NotEmpty(message = "Aggregate name for queries cannot be empty") String, @Valid BusProperties>,

    @get:NotEmpty(message = "Response buses cannot be empty")
    @get:Valid
    val responses: Map<@NotEmpty(message = "Aggregate name for responses cannot be empty") String, @Valid BusProperties>,

    @get:NotEmpty(message = "Event buses cannot be empty")
    @get:Valid
    val events: Map<@NotEmpty(message = "Aggregate name for events cannot be empty") String, @Valid BusProperties>

) {

    data class BusProperties(

        @get:NotNull(message = "Kafka bus properties must be provided")
        @get:Valid
        val kafka: KafkaProperties,

        @get:NotNull(message = "Rabbit bus properties must be provided")
        @get:Valid
        val rabbit: RabbitProperties,

        @get:NotNull(message = "PubSub bus properties must be provided")
        @get:Valid
        val pubsub: PubsubProperties

    ) {
        data class KafkaProperties(

            @get:NotEmpty(message = "Kafka topic must not be empty")
            val topic: String

        )

        data class RabbitProperties(

            @get:NotEmpty(message = "Rabbit exchange must not be empty")
            val exchange: String

        )

        data class PubsubProperties(

            @get:NotEmpty(message = "ActiveMQ subscription must not be empty")
            val subscription: String

        )
    }

}