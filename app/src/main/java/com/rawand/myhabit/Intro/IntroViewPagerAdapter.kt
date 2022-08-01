package com.rawand.myhabit.Intro

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rawand.myhabit.R


class IntroViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IntroFragment.newInstance(
                context.resources.getString(R.string.splash_a_title),
                context.resources.getString(R.string.splash_a_desc),
                R.drawable.intro1

            )
            1 -> IntroFragment.newInstance(
                context.resources.getString(R.string.splash_a_title),
                context.resources.getString(R.string.splash_a_desc),
                R.drawable.intro2

            )
            else -> IntroFragment.newInstance(
                context.resources.getString(R.string.splash_a_title),
                context.resources.getString(R.string.splash_a_desc),
                R.drawable.intro3

            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}