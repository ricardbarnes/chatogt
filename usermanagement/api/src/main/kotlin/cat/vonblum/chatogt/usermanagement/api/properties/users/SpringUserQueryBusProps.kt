package cat.vonblum.chatogt.usermanagement.api.properties.users

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "users.query-bus")
data class SpringUserQueryBusProps(
    val kafka: KafkaProperties,
    val rabbit: RabbitProperties,
    val activemq: ActiveMqProperties
) {

    data class KafkaProperties(val topic: String)
    data class RabbitProperties(val exchange: String)
    data class ActiveMqProperties(val destination: String)

}