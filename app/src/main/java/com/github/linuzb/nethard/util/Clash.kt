package com.github.linuzb.nethard.util

import android.content.Context
import android.content.Intent
import android.net.VpnService
import com.github.linuzb.nethard.common.compat.startForegroundServiceCompat
import com.github.linuzb.nethard.common.constants.Intents
import com.github.linuzb.nethard.common.util.intent
import com.github.linuzb.nethard.design.store.UiStore
import com.github.linuzb.nethard.service.ClashService
import com.github.linuzb.nethard.service.TunService
import com.github.linuzb.nethard.service.util.sendBroadcastSelf

fun Context.startClashService(): Intent? {
    val startTun = UiStore(this).enableVpn

    if (startTun) {
        val vpnRequest = VpnService.prepare(this)
        if (vpnRequest != null)
            return vpnRequest

        startForegroundServiceCompat(TunService::class.intent)
    } else {
        startForegroundServiceCompat(ClashService::class.intent)
    }

    return null
}

fun Context.stopClashService() {
    sendBroadcastSelf(Intent(Intents.ACTION_CLASH_REQUEST_STOP))
}