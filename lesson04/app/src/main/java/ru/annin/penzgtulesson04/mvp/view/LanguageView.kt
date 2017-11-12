package ru.annin.penzgtulesson04.mvp.view

import com.arellomobile.mvp.MvpView
import ru.annin.penzgtulesson04.mvp.model.Language

/**
 * Интерфейс представления экрана "Список языков программирования".
 *
 * @author Pavel Annin.
 */
interface LanguageView : MvpView {

    fun update(languages: List<Language>)
}