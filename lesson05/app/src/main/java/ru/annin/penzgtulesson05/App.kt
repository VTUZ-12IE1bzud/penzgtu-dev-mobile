package ru.annin.penzgtulesson05

import android.app.Application
import android.support.v7.app.AppCompatDelegate

/**
 * Класс приложения.
 *
 * @author Pavel Annin.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}