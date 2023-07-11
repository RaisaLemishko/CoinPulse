package com.coinpulse.presentation.coin_list

import com.coinpulse.common.UiText
import com.coinpulse.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: UiText = UiText.DynamicsString("")
)
