package com.example.bazar.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Item (
    @ColumnInfo val accessInfo: AccessInfo,
    @ColumnInfo val etag: String,
    @PrimaryKey val id: String,
    @ColumnInfo val kind: String,
    @ColumnInfo val saleInfo: SaleInfo,
    @ColumnInfo val selfLink: String,
    @ColumnInfo val volumeInfo: VolumeInfo
) : Parcelable
