package com.example.soccerapps.view.interfaces

import com.example.soccerapps.model.Leagues

interface DetailLeagueView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueDetail(data: List<Leagues>)
}