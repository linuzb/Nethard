package com.github.linuzb.nethard.design.model

data class File(
    val id: String,
    val name: String,
    val size: Long,
    val lastModified: Long,
    val isDirectory: Boolean
)