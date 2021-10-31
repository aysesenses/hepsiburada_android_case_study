package com.aysesenses.hepsiburada_case_study.data.model.movie

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieProperty (

    @SerializedName("wrapperType") val wrapperType : String?,
    @SerializedName("kind") val kind : String?,
    @SerializedName("collectionId") val collectionId : Int?,
    @SerializedName("trackId") val trackId : Int?,
    @SerializedName("artistName") val artistName : String?,
    @SerializedName("collectionName") val collectionName : String?,
    @SerializedName("trackName") val trackName : String?,
    @SerializedName("collectionCensoredName") val collectionCensoredName : String?,
    @SerializedName("trackCensoredName") val trackCensoredName : String?,
    @SerializedName("collectionArtistId") val collectionArtistId : Int?,
    @SerializedName("collectionArtistViewUrl") val collectionArtistViewUrl : String?,
    @SerializedName("collectionViewUrl") val collectionViewUrl : String?,
    @SerializedName("trackViewUrl") val trackViewUrl : String?,
    @SerializedName("previewUrl") val previewUrl : String?,
    @SerializedName("artworkUrl30") val artworkUrl30 : String?,
    @SerializedName("artworkUrl60") val artworkUrl60 : String?,
    @SerializedName("artworkUrl100") val artworkUrl100 : String?,
    @SerializedName("collectionPrice") val collectionPrice : Double?,
    @SerializedName("trackPrice") val trackPrice : Double?,
    @SerializedName("collectionHdPrice") val collectionHdPrice : Double?,
    @SerializedName("trackHdPrice") val trackHdPrice : Double?,
    @SerializedName("releaseDate") val releaseDate : String?,
    @SerializedName("collectionExplicitness") val collectionExplicitness : String?,
    @SerializedName("trackExplicitness") val trackExplicitness : String?,
    @SerializedName("discCount") val discCount : Int?,
    @SerializedName("discNumber") val discNumber : Int?,
    @SerializedName("trackCount") val trackCount : Int?,
    @SerializedName("trackNumber") val trackNumber : Int?,
    @SerializedName("trackTimeMillis") val trackTimeMillis : Int?,
    @SerializedName("country") val country : String?,
    @SerializedName("currency") val currency : String?,
    @SerializedName("primaryGenreName") val primaryGenreName : String?,
    @SerializedName("contentAdvisoryRating") val contentAdvisoryRating : String?,
    @SerializedName("longDescription") val longDescription : String?,
    @SerializedName("hasITunesExtras") val hasITunesExtras : Boolean
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
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(collectionId)
        parcel.writeValue(trackId)
        parcel.writeString(artistName)
        parcel.writeString(collectionName)
        parcel.writeString(trackName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackCensoredName)
        parcel.writeValue(collectionArtistId)
        parcel.writeString(collectionArtistViewUrl)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeValue(collectionHdPrice)
        parcel.writeValue(trackHdPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(discCount)
        parcel.writeValue(discNumber)
        parcel.writeValue(trackCount)
        parcel.writeValue(trackNumber)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(longDescription)
        parcel.writeByte(if (hasITunesExtras) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieProperty> {
        override fun createFromParcel(parcel: Parcel): MovieProperty {
            return MovieProperty(parcel)
        }

        override fun newArray(size: Int): Array<MovieProperty?> {
            return arrayOfNulls(size)
        }
    }
}



