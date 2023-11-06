package com.example.washbuddy

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ChooseOne : AppCompatActivity() {

    private lateinit var washerman: Button
    private lateinit var Customer: Button
    private lateinit var DeliveryPerson: Button
    private lateinit var intent: Intent
    private lateinit var type: String
    private lateinit var bgimage: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_one)

        val animationDrawable = AnimationDrawable()
        animationDrawable.addFrame(resources.getDrawable(R.drawable.bg2), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img2), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img3), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img4), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img5), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img6), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img7), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img8), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.bg3), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img9), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img10), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img11), 3000)
        animationDrawable.addFrame(resources.getDrawable(R.drawable.img11), 3000)

        animationDrawable.isOneShot = false
        animationDrawable.setEnterFadeDuration(850)
        animationDrawable.setExitFadeDuration(1600)

        bgimage = findViewById(R.id.back3)
        bgimage.background = animationDrawable
        animationDrawable.start()

        intent = getIntent()
        type = intent.getStringExtra("Home").toString().trim()

        washerman = findViewById(R.id.washerman)
        DeliveryPerson = findViewById(R.id.delivery)
        Customer = findViewById(R.id.customer)

        washerman.setOnClickListener(View.OnClickListener {
            if (type == "Email") {
                val loginemail = Intent(this@ChooseOne, washermanlogin::class.java)
                startActivity(loginemail)
            }
            if (type == "Phone") {
                val loginphone = Intent(this@ChooseOne, washermanloginphone::class.java)
                startActivity(loginphone)
            }
            if (type == "SignUp") {
                val Register = Intent(this@ChooseOne, washermanRegistration::class.java)
                startActivity(Register)
            }
        })

        Customer.setOnClickListener(View.OnClickListener {
            if (type == "Email") {
                val loginemailcust = Intent(this@ChooseOne, Login::class.java)
                startActivity(loginemailcust)
            }
            if (type == "Phone") {
                val loginphonecust = Intent(this@ChooseOne, Loginphone::class.java)
                startActivity(loginphonecust)
            }
            if (type == "SignUp") {
                val Registercust = Intent(this@ChooseOne, Registration::class.java)
                startActivity(Registercust)
            }
        })

        DeliveryPerson.setOnClickListener(View.OnClickListener {
            if (type == "Email") {
                val loginemail = Intent(this@ChooseOne, Delivery_Login::class.java)
                startActivity(loginemail)
            }
            if (type == "Phone") {
                val loginphone = Intent(this@ChooseOne, Delivery_Loginphone::class.java)
                startActivity(loginphone)
            }
            if (type == "SignUp") {
                val Registerdelivery = Intent(this@ChooseOne, Delivery_Registration::class.java)
                startActivity(Registerdelivery)
            }
        })

    }
    override fun onBackPressed() {
        val mainMenuIntent = Intent(this, MainMenu::class.java)
        startActivity(mainMenuIntent)
        finish()
    }
}
