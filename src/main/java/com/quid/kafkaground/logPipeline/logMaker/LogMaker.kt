package com.quid.kafkaground.logPipeline.logMaker

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.security.SecureRandom
import java.time.LocalDateTime

@Component
@EnableScheduling
class LogMaker(
    private val logProducer: LogProducer
) {

    @Scheduled(fixedDelay = 500)
    fun makeLog() {
        SecureRandom().nextInt(4).let {
            logProducer.produce("${LocalDateTime.now()} ${logTemplate[it]}")
        }
    }

    companion object {
        private val logTemplate = listOf(
            "[INFO] sample info log message",
            "[WARN] sample warning log message",
            "[ERROR] sample error log message",
            "[DEBUG] sample debug log message"
        )
    }
}
