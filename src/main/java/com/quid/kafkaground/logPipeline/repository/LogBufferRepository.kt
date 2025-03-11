package com.quid.kafkaground.logPipeline.repository

import jakarta.annotation.PreDestroy
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

@Repository
class LogBufferRepository(
    private val jdbc: LogJdbcRepository
): LogRepository {
    private val threshold = 50
    private val buffer: MutableMap<String, ConcurrentLinkedQueue<LogPersistEntity>> = ConcurrentHashMap(
        mapOf(
            "INFO" to ConcurrentLinkedQueue(),
            "WARN" to ConcurrentLinkedQueue(),
            "ERROR" to ConcurrentLinkedQueue(),
            "DEBUG" to ConcurrentLinkedQueue()
        )
    )

    override fun saveAll(logs: List<String>) {
        logs.map { LogMapper.toPersistEntity(it) }
            .forEach { addLog(it.level, it) }
    }

    private fun addLog(level: String, message: LogPersistEntity) {
        buffer[level]?.apply {
            add(message)
            if (size >= threshold) {
                flush(level)
            }
        }
    }

    private fun flush(level: String) {
        buffer[level]?.let { queue ->
            val logs = mutableListOf<LogPersistEntity>()
            while (queue.isNotEmpty()) {
                queue.poll()?.let { logs.add(it) }
            }
            if (logs.isNotEmpty()) {
                saveLogs(logs)
            }
        }
    }

    private fun flushAll() {
        buffer.keys.forEach { flush(it) }
    }

    private fun saveLogs(logs: List<LogPersistEntity>) {
        jdbc.bulkInsert(logs)
    }

    @Scheduled(fixedRate = 60_000L)
    fun scheduledFlush() {
        flushAll()
    }

    @PreDestroy
    fun flushOnDestroy() {
        flushAll()
    }
}
