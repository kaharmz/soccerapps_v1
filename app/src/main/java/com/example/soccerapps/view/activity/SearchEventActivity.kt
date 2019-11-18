package com.example.soccerapps.view.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soccerapps.R
import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.model.Event
import com.example.soccerapps.presenter.SearchEventPresenter
import com.example.soccerapps.view.adapter.EventAdapter
import com.example.soccerapps.view.interfaces.SearchViews
import com.example.soccerapps.view.util.gone
import com.example.soccerapps.view.util.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search_event.*

class SearchEventActivity : AppCompatActivity(), SearchViews {

    private var events: MutableList<Event> = mutableListOf()
    private lateinit var searchEventPresenter: SearchEventPresenter
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_event)
        adapter = EventAdapter(events, this)
        val query = intent.getStringExtra("query")
        if (query != null) {
            searchEventPresenter = SearchEventPresenter(this, ApiRepository(), Gson())
            searchEventPresenter.searchEventList(query)
        }
    }

    override fun showLoading() {
        progress_search.visible()
        recycler_search.gone()
    }

    override fun hideLoading() {
        progress_search.gone()
        recycler_search.visible()
    }

    override fun showEventList(data: List<Event>?) {
        events.clear()
        if (data != null)events.addAll(data)
        else error_message.visible()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_search.layoutManager = layoutManager
        recycler_search.adapter = data?.let { EventAdapter(it, this) }
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView?
        searchView?.queryHint = "Search Matches"
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                error_message.gone()
                searchEventPresenter.searchEventList(newText)
                return false
            }
        })
        return true
    }
}
