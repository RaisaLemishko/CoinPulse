package com.coinpulse.domain.use_case.get_coin_details

import com.coinpulse.R
import com.coinpulse.common.Resource
import com.coinpulse.common.UiText
import com.coinpulse.data.remote.dto.toCoinDetails
import com.coinpulse.domain.model.CoinDetails
import com.coinpulse.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase
@Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage?.let { UiText.DynamicsString(it) }
                        ?: UiText.StringResource(R.string.unexpected_error_occurred)
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(UiText.StringResource(R.string.no_connection_error)))
        }
    }
}
