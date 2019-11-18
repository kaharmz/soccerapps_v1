package com.example.soccerapps.presenter

import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.api.TheSportDBApi
import com.example.soccerapps.model.EventResponse
import com.example.soccerapps.view.interfaces.SearchViews
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SearchEventPresenter(
    private val searchViews: SearchViews,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun searchEventList(query: String?) {
        searchViews.showLoading()
        doAsync {
            val data =
                gson.fromJson(
                    apiRepository.doRequest(
                        TheSportDBApi.searchEvent(query)
                    ), EventResponse::class.java
                )
            uiThread {
                searchViews.hideLoading()
                val result = data.search?.filter { it.nameSport == "Soccer" }
                searchViews.showEventList(result)
            }
        }
    }
}