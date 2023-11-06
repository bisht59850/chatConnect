package com.example.washbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainMenu : AppCompatActivity() {

    private lateinit var signinemail: Button
    private lateinit var signinphone: Button
    private lateinit var signup: Button
    private lateinit var bgimage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val zoomin: Animation = AnimationUtils.loadAnimation(this, R.anim.zoomin)
        val zoomout: Animation = AnimationUtils.loadAnimation(this, R.anim.zoomout)

        bgimage = findViewById(R.id.back2)
        bgimage.startAnimation(zoomin)

        zoomout.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                bgimage.startAnimation(zoomin)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        zoomin.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                bgimage.startAnimation(zoomout)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        signinemail = findViewById(R.id.SignwithEmail)
        signinphone = findViewById(R.id.SignwithPhone)
        signup = findViewById(R.id.Signup)

        signinemail.setOnClickListener {
            val signemail = Intent(this, ChooseOne::class.java)
            signemail.putExtra("Home", "Email")
            startActivity(signemail)
            finish()
        }

        signinphone.setOnClickListener {
            val signphone = Intent(this, ChooseOne::class.java)
            signphone.putExtra("Home", "Phone")
            startActivity(signphone)
            finish()
        }

        signup.setOnClickListener {
            val signupIntent = Intent(this, ChooseOne::class.java)
            signupIntent.putExtra("Home", "SignUp")
            startActivity(signupIntent)
            finish()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        System.gc()
    }
}