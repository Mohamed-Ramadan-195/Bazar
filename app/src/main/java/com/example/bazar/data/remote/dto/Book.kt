package com.example.bazar.data.remote.dto

import android.os.Parcelable
import com.example.bazar.domain.model.Item
import kotlinx.parcelize.Parcelize

data class Book(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)

@Parcelize
data class ListPrice (
    val amount: Double,
    val currencyCode: String
): Parcelable

@Parcelize
data class RetailPriceX(
    val amount: Double,
    val currencyCode: String
) : Parcelable

@Parcelize
data class ListPriceX(
    val amountInMicros: Long,
    val currencyCode: String
) : Parcelable

@Parcelize
data class IndustryIdentifier(
    val identifier: String,
    val type: String
) : Parcelable