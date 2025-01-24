package com.example.bazar.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.bazar.domain.model.AccessInfo
import com.example.bazar.domain.model.SaleInfo
import com.example.bazar.domain.model.VolumeInfo

class BazarTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromAccessInfo(accessInfo: AccessInfo): String {
        return gson.toJson(accessInfo)
    }

    @TypeConverter
    fun toAccessInfo(accessInfoString: String): AccessInfo {
        val type = object : TypeToken<AccessInfo>() {}.type
        return gson.fromJson(accessInfoString, type)
    }

    @TypeConverter
    fun fromSaleInfo(saleInfo: SaleInfo): String {
        return gson.toJson(saleInfo)
    }

    @TypeConverter
    fun toSaleInfo(saleInfoString: String): SaleInfo {
        val type = object : TypeToken<SaleInfo>() {}.type
        return gson.fromJson(saleInfoString, type)
    }

    @TypeConverter
    fun fromVolumeInfo(volumeInfo: VolumeInfo): String {
        return gson.toJson(volumeInfo)
    }

    @TypeConverter
    fun toVolumeInfo(volumeInfoString: String): VolumeInfo {
        val type = object : TypeToken<VolumeInfo>() {}.type
        return gson.fromJson(volumeInfoString, type)
    }
}
