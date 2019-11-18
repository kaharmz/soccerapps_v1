package com.example.soccerapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(

    @SerializedName("idEvent")
    var idEvent: String? = null,

    @SerializedName("idSoccerXML")
    var idSoccerXML: String? = null,

    @SerializedName("strEvent")
    var nameEvent: String? = null,

    @SerializedName("strSport")
    var nameSport: String? = null,

    @SerializedName("idLeague")
    var idLeague: String? = null,

    @SerializedName("strLeague")
    var nameLeague: String? = null,

    @SerializedName("strSeason")
    var nameSeason: String? = null,

    @SerializedName("strDescriptionEN")
    var descriptionEN: String? = null,

    @SerializedName("strHomeTeam")
    var nameHomeTeam: String? = null,

    @SerializedName("strAwayTeam")
    var nameAwayTeam: String? = null,

    @SerializedName("intHomeScore")
    var homeScore: Int? = null,

    @SerializedName("intRound")
    var round: Int? = null,

    @SerializedName("intAwayScore")
    var awayScore: Int? = null,

    @SerializedName("strHomeGoalDetails")
    var homeGoalDetails: String? = null,

    @SerializedName("strHomeRedCards")
    var homeRedCards: String? = null,

    @SerializedName("strHomeYellowCards")
    var homeYellowCards: String? = null,

    @SerializedName("strHomeLineupGoalkeeper")
    var homeLineupGoalKeeper: String? = null,

    @SerializedName("strHomeLineupDefense")
    var homeLineupDefense: String? = null,

    @SerializedName("strHomeLineupMidfield")
    var homeLineupMidfield: String? = null,

    @SerializedName("strHomeLineupForward")
    var homeLineupForward: String? = null,

    @SerializedName("strHomeLineupSubstitutes")
    var homeLineupSubstitutes: String? = null,

    @SerializedName("strHomeFormation")
    var homeFormation: String? = null,

    @SerializedName("strAwayRedCards")
    var awayRedCards: String? = null,

    @SerializedName("strAwayYellowCards")
    var awayYellowCards: String? = null,

    @SerializedName("strAwayGoalDetails")
    var awayGoalDetails: String? = null,

    @SerializedName("strAwayLineupGoalkeeper")
    var awayLineupGoalkeeper: String? = null,

    @SerializedName("strAwayLineupDefense")
    var awayLineupDefense: String? = null,

    @SerializedName("strAwayLineupMidfield")
    var awayLineupMidfield: String? = null,

    @SerializedName("strAwayLineupForward")
    var awayLineupForward: String? = null,

    @SerializedName("strAwayLineupSubstitutes")
    var awayLineupSubstitutes: String? = null,

    @SerializedName("strAwayFormation")
    var awayFormation: String? = null,

    @SerializedName("intHomeShots")
    var homeShots: Int? = null,

    @SerializedName("intAwayShots")
    var awayShots: Int? = null,

    @SerializedName("dateEvent")
    var dateEvent: String? = null,

    @SerializedName("strDate")
    var date: String? = null,

    @SerializedName("strTime")
    var time: String? = null,

    @SerializedName("idHomeTeam")
    var idHomeTeam: String? = null,

    @SerializedName("idAwayTeam")
    var idAwayTeam: String? = null,

    @SerializedName("strResult")
    var result: String? = null,

    @SerializedName("strCountry")
    var country: String? = null,

    @SerializedName("strCity")
    var city: String? = null,

    @SerializedName("strPoster")
    var poster: String? = null,

    @SerializedName("strFanart")
    var fanart: String? = null,

    @SerializedName("strBanner")
    var banner: String? = null
) : Parcelable