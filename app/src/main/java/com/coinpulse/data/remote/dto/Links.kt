package com.coinpulse.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Links(
    val explorer: List<String> = listOf(),
    val facebook: List<String> = listOf(),
    val reddit: List<String> = listOf(),
    @SerializedName("source_code")
    val sourceCode: List<String> = listOf(),
    val website: List<String> = listOf(),
    val youtube: List<String> = listOf()
)
