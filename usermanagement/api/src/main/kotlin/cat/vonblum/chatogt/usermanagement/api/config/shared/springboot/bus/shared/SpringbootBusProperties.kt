package cat.vonblum.chatogt.usermanagement.api.config.shared.springboot.bus.shared

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "shared.bus")
data class SpringbootBusProperties(
    val command: Map<String, SpringbootAggregateBusProperties>,
    val queries: Map<String, SpringbootAggregateBusProperties>,
    val responses: Map<String, SpringbootAggregateBusProperties>
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
