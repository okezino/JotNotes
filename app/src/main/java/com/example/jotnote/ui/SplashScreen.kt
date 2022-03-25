package com.example.jotnote.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.jotnote.R
import com.example.jotnote.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    lateinit var bottomAnimation : Animation
    lateinit var topAnimation : Animation
    lateinit var binding : ActivitySplashScreenBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.flow_up)
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.flow_down)

        with(binding){
            splashImage.animation = topAnimation
            jot.animation = bottomAnimation
            simple.animation = bottomAnimation
        }
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
           navigateToHomeScreen()
        },2000)
    }

    private fun navigateToHomeScreen(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}