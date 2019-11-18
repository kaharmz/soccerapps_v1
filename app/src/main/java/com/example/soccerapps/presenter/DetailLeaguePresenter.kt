package com.example.soccerapps.presenter

import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.api.TheSportDBApi
import com.example.soccerapps.model.LeaguesResponse
import com.example.soccerapps.view.interfaces.DetailLeagueView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailLeaguePresenter(
    val detailView: DetailLeagueView,
    val apiRepository: ApiRepository,
    val gson: Gson
) {
    fun getDetailLeague(leagueId: String?) {
        detailView.showLoading()
        doAsync {
            val data =
                gson.fromJson(
                    apiRepository.doRequest(
                        TheSportDBApi.getDetailLeagueById(leagueId)
                    ), LeaguesResponse::class.java
                )

            uiThread {
                detailView.hideLoading()
                detailView.showLeagueDetail(data.leagues)
            }
        }
    }
}