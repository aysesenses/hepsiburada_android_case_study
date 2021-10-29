package com.aysesenses.hepsiburada_case_study.network

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class SearchResponse(

    @SerializedName("resultCount")
    val resultCount: Int?,

    @SerializedName("results")
    val results: List<ItunesProperty>

)
data class ItunesProperty(
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
    @Json(name = "wrapperType")
    val wrapperType: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "longDescription")
    val longDescription: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
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
        parcel.writeString(wrapperType)
        parcel.writeString(description)
        parcel.writeString(longDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItunesProperty> {
        override fun createFromParcel(parcel: Parcel): ItunesProperty {
            return ItunesProperty(parcel)
        }

        override fun newArray(size: Int): Array<ItunesProperty?> {
            return arrayOfNulls(size)
        }
    }
}
