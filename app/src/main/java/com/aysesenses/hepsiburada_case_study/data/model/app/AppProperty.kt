package com.aysesenses.hepsiburada_case_study.data.model.app

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class AppProperty(
    @SerializedName("screenshotUrls") val screenshotUrls: ArrayList<String>?,
    @SerializedName("ipadScreenshotUrls") val ipadScreenshotUrls: ArrayList<String>?,
    @SerializedName("appletvScreenshotUrls") val appletvScreenshotUrls: ArrayList<String>?,
    @SerializedName("artworkUrl60") val artworkUrl60: String?,
    @SerializedName("artworkUrl512") val artworkUrl512: String?,
    @SerializedName("artworkUrl100") val artworkUrl100: String?,
    @SerializedName("artistViewUrl") val artistViewUrl: String?,
    @SerializedName("supportedDevices") val supportedDevices: ArrayList<String>?,
    @SerializedName("features") val features: ArrayList<String>?,
    @SerializedName("advisories") val advisories: ArrayList<String>?,
    @SerializedName("isGameCenterEnabled") val isGameCenterEnabled: Boolean,
    @SerializedName("kind") val kind: String?,
    @SerializedName("minimumOsVersion") val minimumOsVersion: Double?,
    @SerializedName("trackCensoredName") val trackCensoredName: String?,
    @SerializedName("languageCodesISO2A") val languageCodesISO2A: ArrayList<String>?,
    @SerializedName("fileSizeBytes") val fileSizeBytes: Int?,
    @SerializedName("sellerUrl") val sellerUrl: String?,
    @SerializedName("formattedPrice") val formattedPrice: String?,
    @SerializedName("contentAdvisoryRating") val contentAdvisoryRating: String?,
    @SerializedName("averageUserRatingForCurrentVersion") val averageUserRatingForCurrentVersion: Double?,
    @SerializedName("userRatingCountForCurrentVersion") val userRatingCountForCurrentVersion: Int?,
    @SerializedName("averageUserRating") val averageUserRating: Float?,
    @SerializedName("trackViewUrl") val trackViewUrl: String?,
    @SerializedName("trackContentRating") val trackContentRating: String?,
    @SerializedName("bundleId") val bundleId: String?,
    @SerializedName("trackId") val trackId: Int?,
    @SerializedName("trackName") val trackName: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("primaryGenreName") val primaryGenreName: String?,
    @SerializedName("genreIds") val genreIds: List<Int>?,
    @SerializedName("releaseDate") val releaseDate: String?,
    @SerializedName("isVppDeviceBasedLicensingEnabled") val isVppDeviceBasedLicensingEnabled: Boolean,
    @SerializedName("sellerName") val sellerName: String?,
    @SerializedName("currentVersionReleaseDate") val currentVersionReleaseDate: String?,
    @SerializedName("releaseNotes") val releaseNotes: String?,
    @SerializedName("primaryGenreId") val primaryGenreId: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("artistId") val artistId: Int?,
    @SerializedName("artistName") val artistName: String?,
    @SerializedName("genres") val genres: ArrayList<String>?,
    @SerializedName("price") val price: Int?,
    @SerializedName("version") val version: String?,
    @SerializedName("wrapperType") val wrapperType: String?,
    @SerializedName("userRatingCount") val userRatingCount: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("screenshotUrls"),
        TODO("ipadScreenshotUrls"),
        TODO("appletvScreenshotUrls"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("supportedDevices"),
        TODO("features"),
        TODO("advisories"),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        TODO("languageCodesISO2A"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Float,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("genreIds"),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        TODO("genres"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl512)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artistViewUrl)
        parcel.writeByte(if (isGameCenterEnabled) 1 else 0)
        parcel.writeString(kind)
        parcel.writeValue(minimumOsVersion)
        parcel.writeString(trackCensoredName)
        parcel.writeValue(fileSizeBytes)
        parcel.writeString(sellerUrl)
        parcel.writeString(formattedPrice)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeValue(averageUserRatingForCurrentVersion)
        parcel.writeValue(userRatingCountForCurrentVersion)
        parcel.writeValue(averageUserRating)
        parcel.writeString(trackViewUrl)
        parcel.writeString(trackContentRating)
        parcel.writeString(bundleId)
        parcel.writeValue(trackId)
        parcel.writeString(trackName)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
        parcel.writeByte(if (isVppDeviceBasedLicensingEnabled) 1 else 0)
        parcel.writeString(sellerName)
        parcel.writeString(currentVersionReleaseDate)
        parcel.writeString(releaseNotes)
        parcel.writeValue(primaryGenreId)
        parcel.writeString(description)
        parcel.writeValue(artistId)
        parcel.writeString(artistName)
        parcel.writeValue(price)
        parcel.writeString(version)
        parcel.writeString(wrapperType)
        parcel.writeValue(userRatingCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppProperty> {
        override fun createFromParcel(parcel: Parcel): AppProperty {
            return AppProperty(parcel)
        }

        override fun newArray(size: Int): Array<AppProperty?> {
            return arrayOfNulls(size)
        }
    }
}


