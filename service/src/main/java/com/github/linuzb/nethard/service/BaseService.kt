package com.github.linuzb.nethard.service

import android.app.Service
import com.github.linuzb.nethard.service.util.cancelAndJoinBlocking
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseService : Service(), CoroutineScope by CoroutineScope(Dispatchers.Default) {
    override fun onDestroy() {
        super.onDestroy()

        cancelAndJoinBlocking()
    }
}