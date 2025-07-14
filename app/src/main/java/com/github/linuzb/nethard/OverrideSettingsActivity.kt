package com.github.linuzb.nethard

import android.content.pm.PackageManager
import com.github.linuzb.nethard.common.compat.getDrawableCompat
import com.github.linuzb.nethard.common.constants.Metadata
import com.github.linuzb.nethard.core.Clash
import com.github.linuzb.nethard.design.OverrideSettingsDesign
import com.github.linuzb.nethard.design.model.AppInfo
import com.github.linuzb.nethard.design.util.toAppInfo
import com.github.linuzb.nethard.service.store.ServiceStore
import com.github.linuzb.nethard.util.withClash
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.withContext

class OverrideSettingsActivity : BaseActivity<OverrideSettingsDesign>() {
    override suspend fun main() {
        val configuration = withClash { queryOverride(Clash.OverrideSlot.Persist) }
        val service = ServiceStore(this)

        defer {
            withClash {
                patchOverride(Clash.OverrideSlot.Persist, configuration)
            }
        }

        val design = OverrideSettingsDesign(
            this,
            configuration
        )

        setContentDesign(design)

        while (isActive) {
            select<Unit> {
                events.onReceive {

                }
                design.requests.onReceive {
                    when (it) {
                        OverrideSettingsDesign.Request.ResetOverride -> {
                            if (design.requestResetConfirm()) {
                                defer {
                                    withClash {
                                        clearOverride(Clash.OverrideSlot.Persist)
                                    }
                                }

                                finish()
                            }
                        }
                    }
                }
            }
        }
    }
}