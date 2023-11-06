package com.example.washbuddy

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView7)

        imageView.animate().alpha(0f).setDuration(0)
        textView.animate().alpha(0f).setDuration(0)

        imageView.animate().alpha(1f).setDuration(1000).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                textView.animate().alpha(1f).setDuration(800)
            }
        })

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, MainMenu::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}