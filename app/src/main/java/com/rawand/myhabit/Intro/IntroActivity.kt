package com.rawand.myhabit.Intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rawand.myhabit.MainActivity
import com.rawand.myhabit.R

class IntroActivity : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val viewPager=findViewById<ViewPager2>(R.id.viewPager)
        val  pageIndicator=findViewById<TabLayout>(R.id.pageIndicator)
        mViewPager = viewPager
        mViewPager.adapter = IntroViewPagerAdapter(this, this)
        TabLayoutMediator(pageIndicator, mViewPager) { _, _ -> }.attach()

        val btnNextStep: TextView = findViewById(R.id.btn_next_step)

        btnNextStep.setOnClickListener {
            if (getItem() > mViewPager.childCount) {
                finish()
                val intent =
                    Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            } else {
                mViewPager.setCurrentItem(getItem() + 1, true)
            }
        }

    }

    private fun getItem(): Int {
        return mViewPager.currentItem
    }

}
