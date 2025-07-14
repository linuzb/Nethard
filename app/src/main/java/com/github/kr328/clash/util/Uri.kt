package com.github.linuzb.nethard.util

import android.net.Uri

val Uri.fileName: String?
    get() = schemeSpecificPart.split("/").lastOrNull()