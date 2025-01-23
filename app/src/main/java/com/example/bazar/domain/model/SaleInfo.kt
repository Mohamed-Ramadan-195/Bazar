package com.example.bazar.domain.model

import android.os.Parcelable
import com.example.bazar.data.remote.dto.ListPrice
import com.example.bazar.data.remote.dto.RetailPriceX
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaleInfo (
    val buyLink: String,
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice,
    val offers: List<Offer>,
    val retailPrice: RetailPriceX,
    val saleability: String
) : Parcelable