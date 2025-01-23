package com.example.bazar.domain.model

import android.os.Parcelable
import com.example.bazar.data.remote.dto.ListPriceX
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offer (
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
) : Parcelable