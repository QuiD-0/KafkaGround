package com.quid.kafkaground.logPipeline.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class LogJdbcRepository(
    private val jdbcTemplate: JdbcTemplate
) {

    fun bulkInsert(level: String, logs: List<LogPersistEntity>) {
        val sql = "INSERT INTO ${level}_log (msg, timestamp, level) VALUES (:msg, :timestamp, :level)"

        val batchArgs = logs.map {
            MapSqlParameterSource()
                .addValue("msg", it.msg)
                .addValue("timestamp", it.timestamp)
                .addValue("level", it.level)
        }.toTypedArray()

        NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(sql, batchArgs)
    }
}
