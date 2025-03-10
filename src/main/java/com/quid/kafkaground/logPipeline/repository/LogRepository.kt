package com.quid.kafkaground.logPipeline.repository

import org.springframework.stereotype.Repository

@Repository
class LogRepository(
    private val logBufferRepository: LogBufferRepository
) {

    fun saveAll(logs: List<String>) {
        logs.map { LogMapper.mapToEntity(it) }
            .let { logBufferRepository.saveAll(it) }
    }
}
