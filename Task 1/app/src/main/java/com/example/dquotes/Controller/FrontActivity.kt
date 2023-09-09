package com.example.dquotes.Controller

import android.util.Log
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.example.dquotes.EXTRA_STRING
import com.example.dquotes.R
import com.example.dquotes.quotesArray

class FrontActivity : AppCompatActivity() {
    var favourite = ""
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        // Code that takes care for the quotes and its presentation
        val quotesText = findViewById<TextView>(R.id.QuotesText) // Find the TextView by ID
        quotesText.text = quotesArray.random()
        val quoteWithAuthor = quotesText.text.split(" –")

        if (quoteWithAuthor.size == 2) {
            val quote = quoteWithAuthor[0]
            val author = quoteWithAuthor[1]
            quotesText.text =
                "$quote \n \n \n -$author" // Display the quote and author on separate lines
        }

        // Code for share Button
        val shareButton = findViewById<Button>(R.id.ShareButton)
        shareButton.setOnClickListener {
            val contentToShare = quoteWithAuthor[0].toString() // Get the content from the TextView
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, contentToShare)
            startActivity(Intent.createChooser(intent, "Share via"))
        }

        // Code for Favourite button
        val favouriteButton = findViewById<Button>(R.id.FavoriteButton)
        favouriteButton.setOnClickListener {
            val currentQuote = quoteWithAuthor[0]
            favourite=currentQuote
            Log.d("FavouriteArray", favourite.toString())
        }

        // Code for My Favourites Button
        val  GoToFavButton= findViewById<Button>(R.id.GoToFavButton)
        GoToFavButton.setOnClickListener {
            val intent = Intent(this, FavouriteActivity::class.java)
            intent.putExtra(EXTRA_STRING, favourite)
            startActivity(intent)
        }
    }
}
