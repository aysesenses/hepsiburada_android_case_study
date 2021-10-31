package com.aysesenses.hepsiburada_case_study.data.model.ebook

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EBookProperty (
    @SerializedName("artistId")
    val artistId: Int?,
    @SerializedName("artistName")
    val artistName: String?,
    @SerializedName("artistViewUrl")
    val artistViewUrl: String?,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String?,
    @SerializedName("collectionName")
    val collectionName: String?,
    @SerializedName("collectionPrice")
    val collectionPrice: Double?,
    @SerializedName("releaseDate")
    val releaseDate: String?,
    @SerializedName("userRatingCount")
    val userRatingCount: Int?,
    @SerializedName("wrapperType")
    val wrapperType: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("longDescription")
    val longDescription: String?,
    @SerializedName("trackName")
    val trackName: String?,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String?,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String?,
    @SerializedName("trackId")
    val trackId: String?,
    @SerializedName("averageUserRating")
    val averageUserRating: Float?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("genreIds")
    val genres: List<String>?,

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
        parcel.readString(),
        TODO("genreIds")
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