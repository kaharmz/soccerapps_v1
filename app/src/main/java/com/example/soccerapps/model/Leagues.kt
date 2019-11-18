package com.example.soccerapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leagues(
    @SerializedName("idLeague")
    var idLeague: String? = null,

    @SerializedName("idSoccerXML")
    var idSoccerXml: String? = null,

    @SerializedName("strSport")
    var nameSport: String? = null,

    @SerializedName("strLeague")
    var nameLeague: String? = null,

    @SerializedName("intFormedYear")
    var formedYear: String? = null,

    @SerializedName("dateFirstEvent")
    var dateFirstEvent: String? = null,

    @SerializedName("strGender")
    var gender: String? = null,

    @SerializedName("strCountry")
    var country: String? = null,

    @SerializedName("strDescriptionEN")
    var descriptionEN: String? = null,

    @SerializedName("strBadge")
    var badge: String? = null

) : Parcelable