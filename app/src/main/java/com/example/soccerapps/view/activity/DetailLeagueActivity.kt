package com.example.soccerapps.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.soccerapps.R
import com.example.soccerapps.api.ApiRepository
import com.example.soccerapps.model.Leagues
import com.example.soccerapps.presenter.DetailLeaguePresenter
import com.example.soccerapps.view.interfaces.DetailLeagueView
import com.example.soccerapps.view.util.gone
import com.example.soccerapps.view.util.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*
import kotlinx.android.synthetic.main.badge_league.*
import kotlinx.android.synthetic.main.desc_league.*
import org.jetbrains.anko.startActivity

class DetailLeagueActivity : AppCompatActivity(), DetailLeagueView {

    private lateinit var leagues: Leagues
    private lateinit var detailLeaguePresenter: DetailLeaguePresenter
    private var idLeagueDetail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        idLeagueDetail = intent.getStringExtra("idLeague")
        println("Ini id  $idLeagueDetail")
        getLeagueDetail()
    }

    private fun getLeagueDetail() {
        detailLeaguePresenter = DetailLeaguePresenter(this, ApiRepository(), Gson())
        detailLeaguePresenter.getDetailLeague(idLeagueDetail)
    }

    override fun showLoading() {
        progress_league_detail.visible()
        layout_league_detail.gone()
    }

    override fun hideLoading() {
        progress_league_detail.gone()
        layout_league_detail.visible()
    }

    override fun showLeagueDetail(data: List<Leagues>) {
        leagues = data[0]
        bindToView()
    }

    private fun bindToView() {
        Picasso.get().load(leagues.badge).into(image_league_detail)
        league_name_detail.text = leagues.nameLeague
        category_detail_league.text = leagues.nameSport
        formed_league_detail.text = leagues.formedYear
        date_first_league_detail.text = leagues.dateFirstEvent
        genre_league_detail.text = leagues.gender
        country_league_detail.text = leagues.country
        desc_league_detail.text = leagues.descriptionEN
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.detail_list -> {
                startActivity<ListEventActivity>("idLeague" to leagues.idLeague)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
