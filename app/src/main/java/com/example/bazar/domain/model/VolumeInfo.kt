package com.example.bazar.domain.model

import android.os.Parcelable
import com.example.bazar.data.remote.dto.IndustryIdentifier
import com.example.bazar.data.remote.dto.PanelizationSummary
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VolumeInfo (
    val allowAnonLogging: Boolean,
    @SerializedName("authors") val authors: List<String>,
    @SerializedName("averageRating") val averageRating: Int,
    val canonicalVolumeLink: String,
    @SerializedName("categories") val categories: List<String>,
    val contentVersion: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageLinks") val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    @SerializedName("language") val language: String,
    val maturityRating: String,
    @SerializedName("pageCount") val pageCount: Int,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("ratingsCount") val ratingsCount: Int,
    val readingModes: ReadingModes,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("title") val title: String
) : Parcelable