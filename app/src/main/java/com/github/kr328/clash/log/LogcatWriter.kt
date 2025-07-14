package com.github.linuzb.nethard.log

import android.content.Context
import com.github.linuzb.nethard.core.model.LogMessage
import com.github.linuzb.nethard.design.model.LogFile
import com.github.linuzb.nethard.util.logsDir
import java.io.BufferedWriter
import java.io.FileWriter

class LogcatWriter(context: Context) : AutoCloseable {
    private val file = LogFile.generate()
    private val writer = BufferedWriter(FileWriter(context.logsDir.resolve(file.fileName)))

    override fun close() {
        writer.close()
    }

    fun appendMessage(message: LogMessage) {
        writer.appendLine(FORMAT.format(message.time.time, message.level.name, message.message))
    }

    companion object {
        private const val FORMAT = "%d:%s:%s"
    }
}