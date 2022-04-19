package net.nathan.gere

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class Splash : AppCompatActivity() {

    private val myTime : Long = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        animation()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, myTime)
    }

    fun animation(){
        // views
        val logo : ImageView = findViewById(R.id.logo)
        val bottomText : TextView = findViewById(R.id.bottom_text)

        val logoAnim = AnimationUtils.loadAnimation(this, R.anim.logosplash)
        val textAnim = AnimationUtils.loadAnimation(this, R.anim.bottomtext)
        // applique animation
        logo.startAnimation(logoAnim)
        bottomText.startAnimation(textAnim)
    }
}