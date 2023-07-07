package com.coinpulse.domain.use_case.get_coins

import android.content.Context
import com.coinpulse.R
import com.coinpulse.common.Resource
import com.coinpulse.data.remote.dto.toCoin
import com.coinpulse.domain.model.Coin
import com.coinpulse.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase
@Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(context: Context): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
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
