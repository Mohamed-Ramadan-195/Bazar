package com.example.bazar.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Epub (
    val acsTokenLink: String,
    val isAvailable: Boolean
): Parcelable
