package com.quid.kafkaground.logPipeline.repository

import java.time.LocalDateTime

object LogMapper {
    fun toPersistEntity(log: String): LogPersistEntity {
        val (timestamp, level, message) = log.split(" ", limit = 3)

        val levelText = level.substring(1, level.length - 1)
        val dateTime = LocalDateTime.parse(timestamp)

        return LogPersistEntity(
            message,
            dateTime,
            levelText
        )
    }
}
