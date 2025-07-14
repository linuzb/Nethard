package com.github.linuzb.nethard.service.util

import com.github.linuzb.nethard.service.data.ImportedDao
import com.github.linuzb.nethard.service.data.PendingDao
import java.util.*

suspend fun generateProfileUUID(): UUID {
    var result = UUID.randomUUID()

    while (ImportedDao().exists(result) || PendingDao().exists(result)) {
        result = UUID.randomUUID()
    }

    return result
}
