package com.github.linuzb.nethard.common.constants

import android.content.ComponentName
import com.github.linuzb.nethard.common.util.packageName

object Components {
    private const val componentsPackageName = "com.github.linuzb.nethard"

    val MAIN_ACTIVITY = ComponentName(packageName, "$componentsPackageName.MainActivity")
    val PROPERTIES_ACTIVITY = ComponentName(packageName, "$componentsPackageName.PropertiesActivity")
}