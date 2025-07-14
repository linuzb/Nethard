package com.github.linuzb.nethard.core.bridge

import android.net.Uri
import androidx.annotation.Keep
import com.github.linuzb.nethard.common.Global
import java.io.FileNotFoundException

@Keep
object Content {
    @JvmStatic
    fun open(url: String): Int {
        val uri = Uri.parse(url)

        if (uri.scheme != "content") {
            throw UnsupportedOperationException("Unsupported scheme ${uri.scheme}")
        }

        return Global.application.contentResolver.openFileDescriptor(uri, "r")?.detachFd()
            ?: throw FileNotFoundException("$uri not found")
    }
}
