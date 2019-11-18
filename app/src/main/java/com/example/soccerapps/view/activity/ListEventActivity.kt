package com.example.soccerapps.view.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.viewpager.widget.ViewPager
import com.example.soccerapps.R
import com.example.soccerapps.view.adapter.ViewPageAdapter
import com.example.soccerapps.view.fragment.event.LastEventFragment
import com.example.soccerapps.view.fragment.event.NextEventFragment
import kotlinx.android.synthetic.main.activity_list_event.*
import org.jetbrains.anko.startActivity

class ListEventActivity : AppCompatActivity() {

    private var idLeague: String? = null
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_event)
        idLeague = intent.getStringExtra("idLeague")
        bundle = Bundle()
        bundle.putString("idLeague", idLeague)
        setViewPager(viewpager_event)
        tab_event.setupWithViewPager(viewpager_event)
    }

    private fun setViewPager(viewpagerEvent: ViewPager?) {
        val adapter = fragmentManager?.let { ViewPageAdapter(supportFragmentManager) }
        val last = LastEventFragment.lastInstance()
        last.arguments = bundle
        adapter?.addFragment(last, getString(R.string.last_match_text))
        val next = NextEventFragment.nextInstance()
        next.arguments = bundle
        adapter?.addFragment(next, getString(R.string.next_match_text))
        viewpagerEvent?.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView?
        searchView?.queryHint = "Search matches"
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                startActivity<SearchEventActivity>("query" to query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }
}
