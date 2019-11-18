package com.example.soccerapps.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(

    var idLeague: String? = null,

    var leagueName: String? = null,

    var leagueImage: Int? = null

) : Parcelable