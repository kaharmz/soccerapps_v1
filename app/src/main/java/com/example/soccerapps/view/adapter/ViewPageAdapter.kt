package com.example.soccerapps.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPageAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
    private val fragment = ArrayList<Fragment>()
    private val title = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragment.get(position)

    override fun getCount(): Int = fragment.size

    override fun getPageTitle(position: Int): CharSequence? = title.get(position)

    fun addFragment(fragments: Fragment, titles: String) {
        fragment.add(fragments)
        title.add(titles)
    }
}