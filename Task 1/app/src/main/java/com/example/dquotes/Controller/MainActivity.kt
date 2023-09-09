package com.example.dquotes.Controller

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.dquotes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_screen)
        Handler().postDelayed({
            val intent = Intent(this, FrontActivity::class.java)
            startActivity(intent) // Starts the above intent
            finish()  // Close the current activity
        }, 2500) // specifies the time after which the FrontActivity will pop up, 5000=5 sec
    }
}