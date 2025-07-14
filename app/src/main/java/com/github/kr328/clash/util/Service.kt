package com.github.linuzb.nethard.util

import android.content.Context
import android.content.ServiceConnection

fun Context.unbindServiceSilent(connection: ServiceConnection) {
    try {
        unbindService(connection)
    } catch (e: Exception) {
        // ignore
    }
}