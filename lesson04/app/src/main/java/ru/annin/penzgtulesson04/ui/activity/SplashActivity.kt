package ru.annin.penzgtulesson04.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Экран загрузки.
 *
 * @author Pavel Annin.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.launch(this)
        finish()
    }
}