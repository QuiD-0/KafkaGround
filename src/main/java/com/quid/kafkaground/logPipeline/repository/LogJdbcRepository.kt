package com.quid.kafkaground.logPipeline.repository

import org.springframework.stereotype.Repository

@Repository
class LogJdbcRepository {
    fun bulkInsert(logs: List<LogPersistEntity>) {
        TODO("Not yet implemented")
    }
}
