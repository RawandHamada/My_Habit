package com.rawand.myhabit.Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.rawand.myhabit.R

class IntroFragment : Fragment() {
    private var title: String? = null
    private var description: String? = null
    private var imageResource :Int?=null
    private lateinit var SplashIcon : ImageView
    private lateinit var tvTitle: AppCompatTextView
    private lateinit var tvDescription: AppCompatTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageResource =R.drawable.intro1
        if (arguments != null) {
            title = requireArguments().getString(ARG_PARAM1)
            description = requireArguments().getString(ARG_PARAM2)
            imageResource = requireArguments().getInt(ARG_PARAM3)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootLayout: View = inflater.inflate(R.layout.fragment_intro, container, false)
        tvTitle = rootLayout.findViewById(R.id.SplashTitle)
        tvDescription = rootLayout.findViewById(R.id.SplashDesc)
        SplashIcon= rootLayout.findViewById<ImageView>(R.id.SplashIcon)
        tvTitle.text = title
        tvDescription.text = description
        SplashIcon.setImageResource(imageResource!!)
        return rootLayout
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"
        fun newInstance(
            title: String?,
            description: String?,
            imageResource: Int
        ): IntroFragment {
            val fragment = IntroFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, title)
            args.putString(ARG_PARAM2, description)
            args.putInt(ARG_PARAM3, imageResource)
            fragment.arguments = args
            return fragment
        }
    }
}