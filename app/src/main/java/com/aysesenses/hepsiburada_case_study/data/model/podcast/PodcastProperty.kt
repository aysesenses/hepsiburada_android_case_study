package com.aysesenses.hepsiburada_case_study.data.model.podcast

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class PodcastProperty (

    @SerializedName("wrapperType") val wrapperType : String?,
    @SerializedName("kind") val kind : String?,
    @SerializedName("collectionId") val collectionId : Int?,
    @SerializedName("trackId") val trackId : Int?,
    @SerializedName("artistName") val artistName : String?,
    @SerializedName("collectionName") val collectionName : String?,
    @SerializedName("trackName") val trackName : String?,
    @SerializedName("collectionCensoredName") val collectionCensoredName : String?,
    @SerializedName("trackCensoredName") val trackCensoredName : String?,
    @SerializedName("collectionViewUrl") val collectionViewUrl : String?,
    @SerializedName("feedUrl") val feedUrl : String?,
    @SerializedName("trackViewUrl") val trackViewUrl : String?,
    @SerializedName("artworkUrl30") val artworkUrl30 : String?,
    @SerializedName("artworkUrl60") val artworkUrl60 : String?,
    @SerializedName("artworkUrl100") val artworkUrl100 : String?,
    @SerializedName("collectionPrice") val collectionPrice : Int?,
    @SerializedName("trackPrice") val trackPrice : Int?,
    @SerializedName("trackRentalPrice") val trackRentalPrice : Int?,
    @SerializedName("collectionHdPrice") val collectionHdPrice : Int?,
    @SerializedName("trackHdPrice") val trackHdPrice : Int?,
    @SerializedName("trackHdRentalPrice") val trackHdRentalPrice : Int?,
    @SerializedName("releaseDate") val releaseDate : String?,
    @SerializedName("collectionExplicitness") val collectionExplicitness : String?,
    @SerializedName("trackExplicitness") val trackExplicitness : String?,
    @SerializedName("trackCount") val trackCount : Int?,
    @SerializedName("country") val country : String?,
    @SerializedName("currency") val currency : String?,
    @SerializedName("primaryGenreName") val primaryGenreName : String?,
    @SerializedName("contentAdvisoryRating") val contentAdvisoryRating : String?,
    @SerializedName("artworkUrl600") val artworkUrl600 : String?,
    @SerializedName("genreIds") val genreIds : List<Int>?,
    @SerializedName("genres") val genres : List<String>?
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
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("genreIds"),
        parcel.createStringArrayList()
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
        parcel.writeString(collectionViewUrl)
        parcel.writeString(feedUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeValue(trackRentalPrice)
        parcel.writeValue(collectionHdPrice)
        parcel.writeValue(trackHdPrice)
        parcel.writeValue(trackHdRentalPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(trackCount)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(artworkUrl600)
        parcel.writeStringList(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PodcastProperty> {
        override fun createFromParcel(parcel: Parcel): PodcastProperty {
            return PodcastProperty(parcel)
        }

        override fun newArray(size: Int): Array<PodcastProperty?> {
            return arrayOfNulls(size)
        }
    }
}