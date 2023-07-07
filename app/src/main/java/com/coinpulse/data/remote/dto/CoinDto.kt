package com.coinpulse.data.remote.dto

import com.coinpulse.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String = "", // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean = false, // true
    @SerializedName("is_new")
    val isNew: Boolean = false, // false
    val name: String = "", // Bitcoin
    val rank: Int = 0, // 1
    val symbol: String = "", // BTC
    val type: String = "" // coin
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
