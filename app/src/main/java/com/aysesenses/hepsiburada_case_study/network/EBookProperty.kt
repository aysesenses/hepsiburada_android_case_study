package com.aysesenses.hepsiburada_case_study.network

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class EBookProperty (
    @Json(name = "artistId")
    val artistId: Int?,
    @Json(name = "artistName")
    val artistName: String?,
    @Json(name = "artistViewUrl")
    val artistViewUrl: String?,
    @Json(name = "artworkUrl100")
    val artworkUrl100: String?,
    @Json(name = "collectionName")
    val collectionName: String?,
    @Json(name = "collectionPrice")
    val collectionPrice: Double?,
    @Json(name = "releaseDate")
    val releaseDate: String?,
    @Json(name = "userRatingCount")
    val userRatingCount: Int?,
    @Json(name = "wrapperType")
    val wrapperType: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "longDescription")
    val longDescription: String?,
    @Json(name = "trackName")
    val trackName: String?,
    @Json(name = "trackViewUrl")
    val trackViewUrl: String?,
    @Json(name = "artworkUrl60")
    val artworkUrl60: String?,
    @Json(name = "trackId")
    val trackId: String?,
    @Json(name = "averageUserRating")
    val averageUserRating: Float?,
    @Json(name = "price")
    val price: Double?,
    @Json(name = "previewUrl")
    val previewUrl: String?,


):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(artistId)
        parcel.writeString(artistName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(artworkUrl100)
        parcel.writeString(collectionName)
        parcel.writeValue(collectionPrice)
        parcel.writeString(releaseDate)
        parcel.writeValue(userRatingCount)
        parcel.writeString(wrapperType)
        parcel.writeString(description)
        parcel.writeString(longDescription)
        parcel.writeString(trackName)
        parcel.writeString(trackViewUrl)
        parcel.writeString(artworkUrl60)
        parcel.writeString(trackId)
        parcel.writeValue(averageUserRating)
        parcel.writeValue(price)
        parcel.writeString(previewUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EBookProperty> {
        override fun createFromParcel(parcel: Parcel): EBookProperty {
            return EBookProperty(parcel)
        }

        override fun newArray(size: Int): Array<EBookProperty?> {
            return arrayOfNulls(size)
        }
    }
}



