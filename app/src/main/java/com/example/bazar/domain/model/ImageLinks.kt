package com.example.bazar.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageLinks (
    val smallThumbnail: String,
    val thumbnail: String
) : Parcelable