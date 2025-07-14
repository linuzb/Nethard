package com.github.linuzb.nethard.design.util

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.github.linuzb.nethard.common.compat.foreground
import com.github.linuzb.nethard.design.model.AppInfo

fun PackageInfo.toAppInfo(pm: PackageManager): AppInfo {
    return AppInfo(
        packageName = packageName,
        icon = applicationInfo!!.loadIcon(pm).foreground(),
        label = applicationInfo!!.loadLabel(pm).toString(),
        installTime = firstInstallTime,
        updateDate = lastUpdateTime,
    )
}
