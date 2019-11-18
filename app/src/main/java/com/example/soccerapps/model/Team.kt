package com.example.soccerapps.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idLeague")
    var idLeague: String?,

    @SerializedName("idSoccerXML")
    var idSoccerXML: String?,

    @SerializedName("idTeam")
    var idTeam: String,

    @SerializedName("intFormedYear")
    var formedYear: String?,

    @SerializedName("intLoved")
    var loved: String?,

    @SerializedName("intStadiumCapacity")
    var stadiumCapacity: String?,

    @SerializedName("strAlternate")
    var alternate: String?,

    @SerializedName("strCountry")
    var country: String?,

    @SerializedName("strDivision")
    var division: String?,

    var keywords: String?,
    @SerializedName("strLeague")

    var league: String?,
    @SerializedName("strLocked")

    var strLocked: String?,
    @SerializedName("strManager")

    var manager: String?,
    @SerializedName("strRSS")

    var sport: String?,
    @SerializedName("strStadium")

    var stadium: String?,
    @SerializedName("strStadiumDescription")

    var stadiumDescription: String?,

    @SerializedName("strStadiumLocation")
    var stadiumLocation: String?,

    @SerializedName("strStadiumThumb")
    var stadiumThumb: String?,

    @SerializedName("strTeam")
    var team: String?,

    @SerializedName("strTeamBadge")
    var teamBadge: String,

    @SerializedName("strTeamJersey")
    var teamJersey: String?,

    @SerializedName("strTeamLogo")
    var teamLogo: String?,

    @SerializedName("strTeamShort")
    var teamShort: String?,

    @SerializedName("strWebsite")
    var strWebsite: String?
)