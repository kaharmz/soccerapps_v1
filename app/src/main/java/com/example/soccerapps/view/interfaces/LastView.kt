package com.example.soccerapps.view.interfaces

import com.example.soccerapps.model.Event

interface LastView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(
        data: List<Event>?
    )
}