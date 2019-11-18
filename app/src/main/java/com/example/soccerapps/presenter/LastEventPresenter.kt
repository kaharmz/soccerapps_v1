package com.example.soccerapps.presenter

import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.api.TheSportDBApi
import com.example.soccerapps.model.EventResponse
import com.example.soccerapps.view.interfaces.LastView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastEventPresenter(
    private val lastView: LastView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getEventList(leagueId: String?) {
        lastView.showLoading()
        doAsync {
            val data =
                gson.fromJson(
                    apiRepository.doRequest(
                        TheSportDBApi.getLastEvent(leagueId)
                    ), EventResponse::class.java
                )

            uiThread {
                lastView.hideLoading()
                lastView.showEventList(data.events)
            }
        }
    }
}