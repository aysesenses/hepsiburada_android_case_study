package com.aysesenses.hepsiburada_case_study.data.model.music

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MusicProperty (

    @SerializedName("wrapperType") val wrapperType : String?,
    @SerializedName("kind") val kind : String?,
    @SerializedName("artistId") val artistId : Int?,
    @SerializedName("trackId") val trackId : Int?,
    @SerializedName("artistName") val artistName : String?,
    @SerializedName("trackName") val trackName : String?,
    @SerializedName("trackCensoredName") val trackCensoredName : String?,
    @SerializedName("artistViewUrl") val artistViewUrl : String?,
    @SerializedName("trackViewUrl") val trackViewUrl : String?,
    @SerializedName("previewUrl") val previewUrl : String?,
    @SerializedName("artworkUrl30") val artworkUrl30 : String?,
    @SerializedName("artworkUrl60") val artworkUrl60 : String?,
    @SerializedName("artworkUrl100") val artworkUrl100 : String?,
    @SerializedName("collectionPrice") val collectionPrice : Double?,
    @SerializedName("trackPrice") val trackPrice : Double?,
    @SerializedName("releaseDate") val releaseDate : String?,
    @SerializedName("collectionExplicitness") val collectionExplicitness : String?,
    @SerializedName("trackExplicitness") val trackExplicitness : String?,
    @SerializedName("trackTimeMillis") val trackTimeMillis : Int?,
    @SerializedName("country") val country : String?,
    @SerializedName("currency") val currency : String?,
    @SerializedName("primaryGenreName") val primaryGenreName : String?

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(artistId)
        parcel.writeValue(trackId)
        parcel.writeString(artistName)
        parcel.writeString(trackName)
        parcel.writeString(trackCensoredName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MusicProperty> {
        override fun createFromParcel(parcel: Parcel): MusicProperty {
            return MusicProperty(parcel)
        }

        override fun newArray(size: Int): Array<MusicProperty?> {
            return arrayOfNulls(size)
        }
    }
}