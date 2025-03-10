package com.quid.kafkaground.logPipeline.dummy

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LogProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun produce(log: String) {
        kafkaTemplate.send("log", log)
    }
}
