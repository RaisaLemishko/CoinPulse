package com.coinpulse.data.remote.dto

import com.coinpulse.domain.model.CoinDetails
import com.google.gson.annotations.SerializedName

data class CoinDetailsDto(
    val description: String = "", // Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.
    @SerializedName("development_status")
    val developmentStatus: String = "", // Working product
    @SerializedName("first_data_at")
    val firstDataAt: String = "", // 2010-07-17T00:00:00Z
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean = false, // true
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String = "", // SHA256
    val id: String = "", // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean = false, // true
    @SerializedName("is_new")
    val isNew: Boolean = false, // false
    @SerializedName("last_data_at")
    val lastDataAt: String = "", // 2023-07-07T07:44:00Z
    val links: Links = Links(),
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended> = listOf(),
    val logo: String = "", // https://static.coinpaprika.com/coin/btc-bitcoin/logo.png
    val message: String = "",
    val name: String = "", // Bitcoin
    @SerializedName("open_source")
    val openSource: Boolean = false, // true
    @SerializedName("org_structure")
    val orgStructure: String = "", // Decentralized
    @SerializedName("proof_type")
    val proofType: String = "", // Proof of Work
    val rank: Int = 0, // 1
    @SerializedName("started_at")
    val startedAt: String = "", // 2009-01-03T00:00:00Z
    val symbol: String = "", // BTC
    val tags: List<Tag> = listOf(),
    val team: List<TeamMember> = listOf(),
    val type: String = "", // coin
    val whitepaper: Whitepaper = Whitepaper()
)

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}
