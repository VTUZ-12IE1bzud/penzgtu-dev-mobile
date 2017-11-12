package ru.annin.penzgtulesson04.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Adapter вкладок на главном экране.
 *
 * @author Pavel Annin.
 */
class MainPagerAdapter(fm: FragmentManager,
                       private val items: List<Item> = listOf()) : FragmentStatePagerAdapter(fm) {

    data class Item(val title: String, val page: Fragment)

    override fun getPageTitle(position: Int): CharSequence? = items[position].title

    override fun getItem(position: Int): Fragment = items[position].page

    override fun getCount(): Int  = items.size
}