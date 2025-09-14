package cat.vonblum.chatogt.usermanagement.api.properties.users

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "users.command-bus")
data class SpringUserCommandBusProps(
    val kafka: KafkaProperties,
    val rabbit: RabbitProperties,
    val activemq: ActiveMqProperties
) {

    data class KafkaProperties(val topic: String)
    data class RabbitProperties(val exchange: String)
    data class ActiveMqProperties(val destination: String)

}
