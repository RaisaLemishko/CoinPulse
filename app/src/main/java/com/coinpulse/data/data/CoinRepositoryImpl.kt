package com.coinpulse.data.data

import com.coinpulse.data.remote.CoinPaprikaApi
import com.coinpulse.data.remote.dto.CoinDetailsDto
import com.coinpulse.data.remote.dto.CoinDto
import com.coinpulse.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl
@Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return coinPaprikaApi.getCoinById(coinId)
    }
}
