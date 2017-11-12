package ru.annin.penzgtulesson04.ui.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.annin.penzgtulesson04.R
import ru.annin.penzgtulesson04.mvp.model.Language
import ru.annin.penzgtulesson04.mvp.presenter.LanguagePresenter
import ru.annin.penzgtulesson04.mvp.view.LanguageView
import ru.annin.penzgtulesson04.ui.activity.LanguageDetailActivity
import ru.annin.penzgtulesson04.ui.adapter.LanguageAdapter

/**
 * Fragment со списком языков программирования.
 *
 * @author Pavel Annin.
 */
class LanguagesFragment : MvpAppCompatFragment(), LanguageView {

    companion object {
        const val TAG = "ru.annin.penzgtulesson04.LanguagesFragment"
        @JvmStatic fun newInstance() = LanguagesFragment()
    }

    // Component's
    @InjectPresenter lateinit var presenter: LanguagePresenter
    private lateinit var viewDelegate: ViewDelegate

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDelegate = ViewDelegate(view).apply {
            onLanguageClick = { language: Language, logo: View, title: View -> goToDetail(language, logo, title) }
        }
    }

    override fun update(languages: List<Language>) = viewDelegate.run { this.languages.swap(languages) }

    private fun goToDetail(language: Language, logo: View, title: View)
            = LanguageDetailActivity.launch(this, language, logo, title)

    private class ViewDelegate(private val vRoot: View) {

        // View's
        private val rvLanguages by lazy { vRoot.findViewById<RecyclerView>(R.id.rv_languages) }

        // Adapter's
        val languages by lazy { LanguageAdapter() }

        // Listener's
        var onLanguageClick: ((language: Language, logo: View, title: View) -> Unit)? = null

        init {
            rvLanguages.run {
                setHasFixedSize(false)
                itemAnimator = DefaultItemAnimator()
                adapter = languages
            }
            languages.onItemClick = { language: Language, logo: View, title: View -> onLanguageClick?.invoke(language, logo, title) }
        }
    }
}