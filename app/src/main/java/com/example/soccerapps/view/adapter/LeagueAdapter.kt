package com.example.soccerapps.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerapps.R
import com.example.soccerapps.model.League
import com.example.soccerapps.view.activity.DetailLeagueActivity
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.league_item.*
import kotlinx.android.synthetic.main.league_item.view.*
import org.jetbrains.anko.startActivity

class LeagueAdapter(
    private val league: List<League>,
    private val context: Context?
) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LeagueViewHolder(LayoutInflater.from(context).inflate(R.layout.league_item, parent, false))

    override fun getItemCount(): Int = league.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(league[position])
    }

    class LeagueViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(league: League) {
            itemView.league_name_item.text = league.leagueName
            league.leagueImage?.let { Picasso.get().load(it).fit().into(league_image_item) }
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailLeagueActivity>("idLeague" to league.idLeague)
            }
        }
    }
}