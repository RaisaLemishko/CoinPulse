package com.coinpulse.presentation.coin_details

import com.coinpulse.common.UiText
import com.coinpulse.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: UiText = UiText.DynamicsString("")
)
