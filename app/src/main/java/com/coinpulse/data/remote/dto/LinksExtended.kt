package com.coinpulse.data.remote.dto

data class LinksExtended(
    val stats: Stats = Stats(),
    val type: String = "", // blog
    val url: String = "" // https://bitcoin.org/en/blog
)
