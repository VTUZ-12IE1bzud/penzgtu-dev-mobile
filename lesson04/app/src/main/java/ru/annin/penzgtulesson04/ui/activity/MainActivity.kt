package ru.annin.penzgtulesson04.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import ru.annin.penzgtulesson04.R
import ru.annin.penzgtulesson04.ui.adapter.MainPagerAdapter
import ru.annin.penzgtulesson04.ui.fragment.LanguagesFragment
import ru.annin.penzgtulesson04.ui.fragment.RelaxFragment

/**
 * Глвный экран.
 *
 * @author Pavel Annin.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
        @JvmStatic fun launch(activity: Activity) = activity.startActivity(newInstance(activity))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewDelegate(findViewById(R.id.root), supportFragmentManager)
    }

    private class ViewDelegate(private val vRoot: ViewGroup, private val fm: FragmentManager) {

        // View's
        private val tlPages by lazy { vRoot.findViewById<TabLayout>(R.id.tl_pages) }
        private val vpPages by lazy { vRoot.findViewById<ViewPager>(R.id.pages) }

        private val pages by lazy {
            MainPagerAdapter(fm, listOf(
                    MainPagerAdapter.Item(vRoot.resources.getString(R.string.main_tabs_language), LanguagesFragment.newInstance()),
                    MainPagerAdapter.Item(vRoot.resources.getString(R.string.main_tabs_relax), RelaxFragment.newInstance())
            ))
        }

        init {
            vpPages.adapter = pages
            tlPages.setupWithViewPager(vpPages)
        }
    }
}
