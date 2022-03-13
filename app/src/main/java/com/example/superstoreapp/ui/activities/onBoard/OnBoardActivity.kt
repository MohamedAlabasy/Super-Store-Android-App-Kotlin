package com.example.superstoreapp.ui.activities.onBoard

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.superstoreapp.R
import com.example.superstoreapp.databinding.ActivityOnBoardBinding
import com.example.superstoreapp.ui.activities.home.HomeActivity
import com.example.superstoreapp.ui.activities.signIn.SignInActivity

class OnBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardBinding
    private lateinit var slidAdapter: OnBoardAdapter
    private var mCurrentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        slidAdapter = OnBoardAdapter(this)
        binding.onBoardViewPager.adapter = slidAdapter
        binding.onBoardViewPager.addOnPageChangeListener(vChangeListener)


        //Btn On Click
        binding.onBoardNextImg.setOnClickListener {
            if (binding.onBoardProgressBar.progress == 100) {
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            } else {
                binding.onBoardViewPager.currentItem = mCurrentPage + 1
            }
        }



        binding.onBoardBackImg.setOnClickListener {
            binding.onBoardViewPager.currentItem = mCurrentPage - 1
        }

        binding.onBoardSkipImg.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }


    }

    private var vChangeListener: ViewPager.OnPageChangeListener = object :
        ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int, positionOffset: Float, positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            mCurrentPage = position
            when (position) {
                0 -> {
                    binding.onBoardBackImg.visibility = View.GONE
                    //for ProgressBar animation1
                    val animation1 =
                        ObjectAnimator.ofInt(binding.onBoardProgressBar, "progress", 33)
                    animation1.duration = 400
                    animation1.interpolator = AccelerateInterpolator()
                    animation1.start()
                }
                1 -> {
                    binding.onBoardBackImg.visibility = View.VISIBLE
                    val animation2 =
                        ObjectAnimator.ofInt(binding.onBoardProgressBar, "progress", 66)
                    animation2.duration = 400
                    animation2.interpolator = AccelerateInterpolator()
                    animation2.start()
                }
                2 -> {
                    val animation3 =
                        ObjectAnimator.ofInt(binding.onBoardProgressBar, "progress", 100)
                    animation3.duration = 400
                    animation3.interpolator = AccelerateInterpolator()
                    animation3.start()
                }
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}