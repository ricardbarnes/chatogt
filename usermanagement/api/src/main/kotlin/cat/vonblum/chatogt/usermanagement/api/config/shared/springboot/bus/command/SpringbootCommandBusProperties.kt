package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.bus.command

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "shared.bus.command")
data class SpringbootCommandBusProperties(
    val users: SpringbootAggregateBusProperties
) {
    data class SpringbootAggregateBusProperties(
        val kafka: SpringbootKafkaProperties,
        val rabbit: SpringbootRabbitProperties,
        val activemq: SpringbootActiveMqProperties
    ) {
        data class SpringbootKafkaProperties(val topic: String)
        data class SpringbootRabbitProperties(val exchange: String)
        data class SpringbootActiveMqProperties(val destination: String)
    }
}