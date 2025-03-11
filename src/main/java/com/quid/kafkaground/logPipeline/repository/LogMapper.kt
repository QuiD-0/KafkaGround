package com.quid.kafkaground.logPipeline.repository

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LogMapper {
    fun toPersistEntity(log: String): LogPersistEntity {
        val (timestamp, level, message) = log.split(" ", limit = 3)

        val levelText = level.substring(1, level.length - 1)
        val dateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"))

        return LogPersistEntity(
            message,
            dateTime,
            levelText
        )
    }
}
