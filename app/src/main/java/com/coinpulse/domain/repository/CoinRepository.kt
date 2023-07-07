package com.coinpulse.domain.repository

import com.coinpulse.data.remote.dto.CoinDetailsDto
import com.coinpulse.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}
