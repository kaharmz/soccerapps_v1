package com.example.soccerapps.presenter

import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.api.TheSportDBApi
import com.example.soccerapps.model.EventResponse
import com.example.soccerapps.model.TeamResponse
import com.example.soccerapps.view.interfaces.DetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailEventPresenter(
    val view: DetailView,
    val apiRepository: ApiRepository,
    val gson: Gson
) {
    fun getEventDetail(idEvent: String?, idHomeTeam: String?, idAwayTeam: String?) {
        view.showLoading()
        doAsync {
            val eventDetail =
                gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getDetailEvent(idEvent)),
                    EventResponse::class.java
                )

            val badgeHome =
                gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getHomeBadge(idHomeTeam)),
                    TeamResponse::class.java
                )

            val badgeAway =
                gson.fromJson(
                    apiRepository.doRequest(TheSportDBApi.getAwayBadge(idAwayTeam)),
                    TeamResponse::class.java
                )
            uiThread {
                view.hideLoading()
                view.showEventList(eventDetail.events, badgeHome.team, badgeAway.team)
            }
        }
    }
}