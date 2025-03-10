package com.quid.kafkaground.logPipeline.repository

import java.time.LocalDateTime

data class LogPersistEntity(
    val msg: String,
    val timestamp: LocalDateTime,
    val level: String
)
