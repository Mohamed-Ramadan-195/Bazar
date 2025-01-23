package com.example.bazar.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccessInfo (
    val accessViewStatus: String,
    @SerializedName("country") val country: String,
    val embeddable: Boolean,
    val epub: Epub,
    @SerializedName("pdf") val pdf: Pdf,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String
) : Parcelable
