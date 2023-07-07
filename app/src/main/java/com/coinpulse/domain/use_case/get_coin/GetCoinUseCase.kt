package com.coinpulse.domain.use_case.get_coin

import android.content.Context
import com.coinpulse.R
import com.coinpulse.common.Resource
import com.coinpulse.data.remote.dto.toCoinDetails
import com.coinpulse.domain.model.CoinDetails
import com.coinpulse.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase
@Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(context: Context, coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: context.getString(R.string.unexpected_error_occurred)
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(context.getString(R.string.no_connection_error)))
        }
    }
}
