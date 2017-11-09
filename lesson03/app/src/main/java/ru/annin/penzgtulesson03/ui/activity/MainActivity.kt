package ru.annin.penzgtulesson03.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.annin.penzgtulesson03.R

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic fun launch(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
