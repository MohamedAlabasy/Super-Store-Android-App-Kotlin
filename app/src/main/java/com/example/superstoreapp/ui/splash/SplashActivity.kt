package com.example.superstoreapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.superstoreapp.R
import com.example.superstoreapp.databinding.ActivitySplashBinding
import com.example.superstoreapp.ui.activities.onBoard.OnBoardActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val HANDLER_TIME: Long = 2000
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set status background text white
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_anmetion)


        //to make full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.setFlags(
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            )
        }

        binding.splashImg.animation = topAnimation
        binding.splashTv.animation = bottomAnimation

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, OnBoardActivity::class.java))
            finish()
        }, HANDLER_TIME)
    }

}