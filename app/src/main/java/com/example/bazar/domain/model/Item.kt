package com.example.bazar.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item (
    val accessInfo: AccessInfo,
    val etag: String,
    @SerializedName("id") val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val selfLink: String,
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
) : Parcelable
