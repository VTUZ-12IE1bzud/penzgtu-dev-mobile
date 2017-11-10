package ru.annin.penzgtulesson03.mvp.view

import android.support.annotation.DrawableRes
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Интерфейс представления главного экрана.
 *
 * @author Pavel Annin.
 */
interface MainView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToUrl(url: CharSequence)

    fun updatePhoto(@DrawableRes res: Int)
}