package com.example.soccerapps.view.fragment.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerapps.R
import com.example.soccerapps.model.League
import com.example.soccerapps.view.adapter.LeagueAdapter
import kotlinx.android.synthetic.main.fragment_league.*
import kotlinx.android.synthetic.main.fragment_league.view.*

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment() {

    private var league: MutableList<League> = mutableListOf()
    private lateinit var listLeague: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_league, container, false)
        listLeague = view.league_recycler
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        league_recycler.layoutManager = LinearLayoutManager(context)
        league_recycler.adapter = LeagueAdapter(league, context)
        bindToView()
    }

    private fun bindToView() {
        val id = resources.getStringArray(R.array.league_id)
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_images)
        league.clear()
        for (i in name.indices) {
            league.add(League(id[i], name[i], image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}

