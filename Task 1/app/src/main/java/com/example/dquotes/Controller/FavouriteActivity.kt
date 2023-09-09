package com.example.dquotes.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.util.Log
import android.view.View
import com.example.dquotes.R

class FavouriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        val favouriteQuotes = intent.getStringExtra(EXTRA_STRING) ?: ""
        Log.d("FavouriteString", favouriteQuotes)
        val favoriteTextView = findViewById<TextView>(R.id.textView1)
        favoriteTextView.text = favouriteQuotes
        favoriteTextView.visibility = View.VISIBLE
    }
    companion object {
        const val EXTRA_STRING = "extra_string"
    }
}