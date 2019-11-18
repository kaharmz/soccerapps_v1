package com.example.soccerapps.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soccerapps.R
import com.example.soccerapps.model.Event
import com.example.soccerapps.view.activity.DetailEventActivity
import kotlinx.android.synthetic.main.item_event.view.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class EventAdapter(
    private val event: List<Event>,
    private val context: Context?
) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventViewHolder(LayoutInflater.from(context).inflate(R.layout.item_event, parent, false))

    override fun getItemCount(): Int = event.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(event[position])
    }

    class EventViewHolder(eventView: View) : RecyclerView.ViewHolder(eventView) {
        fun bindItem(event: Event) {
            val timeEvent = event.dateEvent?.let {
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(
                    it
                )
            }

            val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

            itemView.date_event.text = dateEvent.toString()

            if (event.homeScore != null){
                itemView.home_name.text = event.nameHomeTeam
                itemView.away_name.text = event.nameAwayTeam
                itemView.home_score.text = event.homeScore.toString()
                itemView.away_score.text = event.awayScore.toString()
            } else {
                itemView.home_score.text = "-"
                itemView.away_score.text = "-"
                itemView.home_name.text = event.nameHomeTeam
                itemView.away_name.text = event.nameAwayTeam
            }

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailEventActivity>(
                    "idEvent" to event.idEvent,
                    "idHomeTeam" to event.idHomeTeam,
                    "idAwayTeam" to event.idAwayTeam
                )
            }
        }
    }
}