package com.powerclick.app.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.powerclick.app.databinding.FragmentAboutBinding
import com.powerclick.app.shared_preferences.OnboardingSharedPreferences

class AboutFragment : Fragment() {

    private lateinit var _binding: FragmentAboutBinding
    private val binding get() = _binding
    private val githubLink: String = "https://github.com/EmreCogac"
    private val linkedinLink: String = "https://www.linkedin.com/in/emre-aktas-9176a31a6/"
    private val taluyLink: String = "https://www.linkedin.com/company/taluy"
    private val tutorialVideoLink: String = "https://memreaktas.blogspot.com/2024/03/powerclik-nasl-kurulur.html"
    private val downloadLinkBlog: String = "https://memreaktas.blogspot.com/2024/03/powerclik-nasl-kurulur.html"
    private lateinit var onboardingSharedPreferences : OnboardingSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        onboardingSharedPreferences = OnboardingSharedPreferences(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        onboardingSharedPreferences.setBool("isFirstTime", false)
        binding.apply {
            buttonEffectAndUri(github, githubLink)
            buttonEffectAndUri(linkedin, linkedinLink)
            buttonEffectAndUri(taluy, taluyLink)
            buttonEffectAndUri(downloadLink, downloadLinkBlog)
            buttonEffectAndUri(ttlink, tutorialVideoLink)
        }

        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    fun buttonEffectAndUri(button: View, url: String) {
        button.setOnTouchListener { v, event ->
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(
                        Color.rgb(191, 207, 231), PorterDuff.Mode.SRC_ATOP
                    )
                    v.invalidate()
                }

                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                    startActivity(i)
                }
            }
            false

        }

    }
}