package com.example.soccerapps.model

import com.google.gson.annotations.SerializedName

class EventResponse(
    @SerializedName("events")
    val events: List<Event>,

    @SerializedName("event")
    val search: List<Event>?
)