package com.github.linuzb.nethard.design.util

import com.github.linuzb.nethard.design.view.ObservableScrollView

val ObservableScrollView.isTop: Boolean
    get() = scrollX == 0 && scrollY == 0
