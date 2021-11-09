package com.example.cooldroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    private var counter = 0
    private val COUNTER = "counter"
    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER)
            cooldroidText.text = getMessageText()
        }
        imageView.setOnClickListener{
            counter++
            Log.d(LOG_TAG, "onCreate(), counter: ${counter}")
            cooldroidText.text = getMessageText()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER, counter)
        Log.d(LOG_TAG, "onSaveInstanceState(), counter: ${counter}")
        super.onSaveInstanceState(outState)
    }

    fun getMessageText() =
        when (counter) {
            1 -> getString(R.string.once)
            2 -> getString(R.string.twice)
            else -> getString(R.string.text_view_numbers, counter)
        }
}