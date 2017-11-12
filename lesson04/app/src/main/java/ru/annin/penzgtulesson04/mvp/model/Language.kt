package ru.annin.penzgtulesson04.mvp.model

import android.support.annotation.DrawableRes

/**
 * Модель данных "Язык программирования".
 *
 * @author Pavel Annin.
 */
data class Language(val name: String, @DrawableRes val logo: Int, val description: String)