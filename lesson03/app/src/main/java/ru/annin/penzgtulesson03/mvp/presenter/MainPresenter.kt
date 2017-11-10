package ru.annin.penzgtulesson03.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.annin.penzgtulesson03.R
import ru.annin.penzgtulesson03.mvp.view.MainView
import java.util.*

/**
 * Presenter главного экрана.
 *
 * @author Pavel Annin.
 */
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    companion object {
        private val PHOTOS = arrayOf(R.drawable.ic_golang, R.drawable.ic_java, R.drawable.ic_kotlin,
                R.drawable.ic_golang, R.drawable.ic_swift, R.drawable.ic_tenserflow)
    }

    // Data's
    private var currentPhoto = -1

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadPhoto()
    }

    fun doSearch(query: CharSequence) {
        if (query.isNotBlank()) {
            viewState.goToUrl("https://www.google.com/search?q=$query")
        }
    }

    fun doLike() {
        loadPhoto()
    }

    fun doDislike() {
        loadPhoto()
    }

    private fun loadPhoto() {
        val newPhoto = PHOTOS.random()
        if (newPhoto == currentPhoto) {
            loadPhoto()
        } else {
            viewState.updatePhoto(newPhoto)
            currentPhoto = newPhoto
        }
    }

    private fun <T> Array<T>.random(): T = get(Random().nextInt(size - 1))
}