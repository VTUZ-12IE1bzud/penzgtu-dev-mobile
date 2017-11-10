package ru.annin.penzgtulesson03.ui.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.annin.penzgtulesson03.R
import ru.annin.penzgtulesson03.mvp.presenter.MainPresenter
import ru.annin.penzgtulesson03.mvp.view.MainView
import ru.annin.penzgtulesson03.util.GlideApp

/**
 * Главный экран.
 *
 * @author Pavel Annin.
 */
class MainActivity : MvpAppCompatActivity(), MainView {

    companion object {
        @JvmStatic
        fun launch(context: Context) = Intent(context, MainActivity::class.java)
    }

    // Component's
    @InjectPresenter lateinit var presenter: MainPresenter
    private lateinit var searchView: SearchViewDelegate
    private lateinit var photoView: PhotoViewDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = SearchViewDelegate(findViewById(R.id.root)).apply {
            onSearchClick = { query -> presenter.doSearch(query) }
        }
        photoView = PhotoViewDelegate(findViewById(R.id.root)).apply {
            onLikeClick = { presenter.doLike() }
            onDislikeClick = { presenter.doDislike() }
        }
    }

    override fun goToUrl(url: CharSequence) {
        val newIntent = CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setToolbarColor(ContextCompat.getColor(this, R.color.primary))
                .build()
        newIntent.launchUrl(this, Uri.parse(url.toString()))
    }

    override fun updatePhoto(@DrawableRes res: Int) = photoView.run { update(res) }

    private class SearchViewDelegate(private val vRoot: ViewGroup) {

        // View's
        private val edtQuery by lazy { vRoot.findViewById<EditText>(R.id.edt_query) }
        private val ibtnSearch by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_search) }

        // Listener's
        var onSearchClick: ((query: CharSequence) -> Unit)? = null

        init {
            ibtnSearch.setOnClickListener { onSearchClick?.invoke(edtQuery.text) }
        }
    }

    private class PhotoViewDelegate(private val vRoot: ViewGroup) {

        // View's
        private val ivPhoto by lazy { vRoot.findViewById<ImageView>(R.id.iv_photo) }
        private val ibtnLike by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_like) }
        private val ibtnDislike by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_dislike) }

        // Listener's
        var onLikeClick: (() -> Unit)? = null
        var onDislikeClick: (() -> Unit)? = null

        init {
            ibtnLike.setOnClickListener { onLikeClick?.invoke() }
            ibtnDislike.setOnClickListener { onDislikeClick?.invoke() }
        }

        fun update(@DrawableRes res: Int) {
            GlideApp.with(vRoot)
                    .load(res)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .transition(GenericTransitionOptions.with(R.anim.slide_in_right))
                    .into(ivPhoto)
        }
    }
}
