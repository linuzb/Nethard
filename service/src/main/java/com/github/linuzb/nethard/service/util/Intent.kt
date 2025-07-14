package com.github.linuzb.nethard.service.util

import android.content.Intent

val Intent.packageName: String?
    get() {
        return data?.takeIf { it.scheme == "package" }?.schemeSpecificPart
    }