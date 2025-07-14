package com.github.linuzb.nethard.log

import android.content.Context
import com.github.linuzb.nethard.core.model.LogMessage
import com.github.linuzb.nethard.design.model.LogFile
import com.github.linuzb.nethard.util.logsDir
import java.io.BufferedReader
import java.io.FileReader
import java.util.*

class LogcatReader(context: Context, file: LogFile) : AutoCloseable {
    private val reader = BufferedReader(FileReader(context.logsDir.resolve(file.fileName)))

    override fun close() {
        reader.close()
    }

    fun readAll(): List<LogMessage> {
        var lastTime = Date(0)
        return reader.lineSequence()
            .map { it.trim() }
            .filter { !it.startsWith("#") }
            .map { it.split(":", limit = 3) }
            .map {
                val time = it[0].toLongOrNull()?.let { Date(it) } ?: lastTime
                val logMessage = if (it[0].toLongOrNull() != null) {
                    LogMessage(
                        time = time,
                        level = LogMessage.Level.valueOf(it[1]),
                        message = it[2]
                    )
                } else {
                    LogMessage(
                        time = time,
                        level = LogMessage.Level.Warning, // or any default level
                        message = it.joinToString(":")
                    )
                }
                lastTime = time
                logMessage
            }
            .toList()
    }
}