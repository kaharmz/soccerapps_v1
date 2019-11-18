package com.example.soccerapps.view.interfaces

import com.example.soccerapps.model.Event
import com.example.soccerapps.model.Team

interface DetailView {
    fun hideLoading()
    fun showLoading()
    fun showEventList(
        data: List<Event>,
        home: List<Team>,
        away: List<Team>
    )
}