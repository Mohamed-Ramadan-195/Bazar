package com.example.bazar.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RetailPrice(
    val amountInMicros: Long,
    val currencyCode: String
) : Parcelable