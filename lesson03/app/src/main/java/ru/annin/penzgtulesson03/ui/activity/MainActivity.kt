package ru.annin.penzgtulesson03.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import ru.annin.penzgtulesson03.R

/**
 * Главный экран.
 *
 * @author Pavel Annin.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic fun launch(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private class ViewDelegate(private val vRoot: View) {

        // View's
        private val edtUrl by lazy { vRoot.findViewById<EditText>(R.id.edt_url) }
        private val ibtnSearch by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_search) }
        private val ivPhoto by lazy { vRoot.findViewById<ImageView>(R.id.iv_photo) }
        private val ibtnLike by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_like) }
        private val ibtnDislike by lazy { vRoot.findViewById<ImageButton>(R.id.ibtn_dislike) }

        // Listener's
        var onSearchClick: ((url: CharSequence) -> Unit)? = null
        var onLikeClick: (() -> Unit)? = null
        var onDislikeClick: (() -> Unit)? = null

        init {
            ibtnSearch.setOnClickListener { onSearchClick?.invoke(edtUrl.text) }
            ibtnLike.setOnClickListener { onLikeClick?.invoke() }
            ibtnDislike.setOnClickListener { onDislikeClick?.invoke() }
        }
    }
}
