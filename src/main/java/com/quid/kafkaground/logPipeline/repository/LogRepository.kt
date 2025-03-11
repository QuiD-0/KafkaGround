package com.quid.kafkaground.logPipeline.repository

interface LogRepository {
    fun saveAll(logs: List<String>)
}
