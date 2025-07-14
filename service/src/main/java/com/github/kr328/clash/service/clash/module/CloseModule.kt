package com.github.linuzb.nethard.service.clash.module

import android.app.Service
import com.github.linuzb.nethard.common.constants.Intents
import com.github.linuzb.nethard.common.log.Log

class CloseModule(service: Service) : Module<CloseModule.RequestClose>(service) {
    object RequestClose

    override suspend fun run() {
        val broadcasts = receiveBroadcast {
            addAction(Intents.ACTION_CLASH_REQUEST_STOP)
        }

        broadcasts.receive()

        Log.d("User request close")

        return enqueueEvent(RequestClose)
    }
}