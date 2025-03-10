package com.quid.kafkaground.logPipeline.repository

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LogMapper {
    fun mapToEntity(log: String): LogPersistEntity {
        val (timestamp, level, message) = log.split(" ")

        val levelText = level.substring(1, level.length - 1)
        val dateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))

        return LogPersistEntity(
            message,
            dateTime,
            levelText
        )
    }
}
