package com.example.soccerapps.view.interfaces

import com.example.soccerapps.model.Event

interface NextView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>?)
}