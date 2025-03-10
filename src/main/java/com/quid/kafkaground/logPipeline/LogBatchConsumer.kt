package com.quid.kafkaground.logPipeline

import com.quid.kafkaground.logPipeline.repository.LogRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class LogBatchConsumer(
    private val repository: LogRepository
) {

    @KafkaListener(topics = ["log"], groupId = "log-batch-consumer")
    fun consume(logs: List<String>) {
        repository.saveAll(logs)
    }
}
