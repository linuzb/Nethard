package com.github.linuzb.nethard.service.remote

import com.github.linuzb.nethard.core.model.LogMessage
import com.github.kr328.kaidl.BinderInterface

@BinderInterface
interface ILogObserver {
    fun newItem(log: LogMessage)
}