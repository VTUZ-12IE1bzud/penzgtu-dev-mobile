package ru.annin.penzgtulesson04.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_language_detail.view.*
import ru.annin.penzgtulesson04.R
import ru.annin.penzgtulesson04.mvp.model.Language

/**
 * Экран с просмотром языка программирования.
 *
 * @author Pavel Annin.
 */
class LanguageDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_LANGUAGE = "ru.annin.penzgtulesson04.extra.language"
        private const val SHARE_LOGO = "ru.annin.penzgtulesson04.share.logo"
        private const val SHARE_TITILE = "ru.annin.penzgtulesson04.share.title"
        @JvmStatic fun newInstance(context: Context, language: Language) = Intent(context, LanguageDetailActivity::class.java).apply {
            putExtra(EXTRA_LANGUAGE, language)
        }
        @JvmStatic fun launch(fragment: Fragment, language: Language, logo: View, title: View) {
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(fragment.activity!!,
                    Pair.create(logo, SHARE_LOGO), Pair(title, SHARE_TITILE))
            fragment.startActivity(newInstance(fragment.context!!, language), option.toBundle())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportPostponeEnterTransition()
        setContentView(R.layout.activity_language_detail)
        val viewDelegate = ViewDelegate(findViewById(R.id.root)).apply {
            onBackClick = { supportFinishAfterTransition() }
        }

        val language = intent?.extras?.getSerializable(EXTRA_LANGUAGE) as Language?
        language?.let { viewDelegate.bindToData(it) } ?: finish()

        findViewById<View>(R.id.root).viewTreeObserver.addOnPreDrawListener {
            supportStartPostponedEnterTransition()
            true
        }
    }

    private class ViewDelegate(private val vRoot: ViewGroup) {

        // View's
        private val vToolbar by lazy { vRoot.findViewById<Toolbar>(R.id.v_toolbar) }
        private val ivLogo by lazy { vRoot.findViewById<ImageView>(R.id.iv_logo) }
        private val txtTitle by lazy { vRoot.findViewById<TextView>(R.id.txt_title) }
        private val txtDescription by lazy { vRoot.findViewById<TextView>(R.id.txt_description) }

        // Listener's
        var onBackClick: (() -> Unit)? = null

        init {
            vToolbar.setNavigationOnClickListener { onBackClick?.invoke() }
        }

        fun bindToData(data: Language) {
            Glide.with(vRoot)
                    .load(data.logo)
                    .apply(RequestOptions.centerCropTransform())
                    .into(ivLogo)
            txtTitle.text = data.name
            txtDescription.text= data.description
        }
    }
}