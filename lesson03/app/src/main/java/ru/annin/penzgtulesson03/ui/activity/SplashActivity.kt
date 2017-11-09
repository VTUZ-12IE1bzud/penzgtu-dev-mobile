package ru.annin.penzgtulesson03.ui.activity

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
        val newIntent = MainActivity.launch(this)
        startActivity(newIntent)
        finish()
    }
}