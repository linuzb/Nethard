package com.github.linuzb.nethard.service.remote

import com.github.linuzb.nethard.core.model.FetchStatus
import com.github.kr328.kaidl.BinderInterface

@BinderInterface
fun interface IFetchObserver {
    fun updateStatus(status: FetchStatus)
}