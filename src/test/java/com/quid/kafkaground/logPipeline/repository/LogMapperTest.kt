package com.quid.kafkaground.logPipeline.repository

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class LogMapperTest {

    @Test
    fun logMessageToLogPersistEntity() {
        val logMessage = "${LocalDateTime.now()} [INFO] message test"
        val logPersistEntity = LogMapper.toPersistEntity(logMessage)
        assertEquals("message test", logPersistEntity.msg)
        assertEquals("INFO", logPersistEntity.level)
    }
}
