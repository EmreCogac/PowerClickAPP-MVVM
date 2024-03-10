package com.powerclick.app.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentSlpashScreenBinding
import com.powerclick.app.shared_preferences.IpDataShared
import com.powerclick.app.shared_preferences.OnboardingSharedPreferences


class SlpashScreenFragment : Fragment() {

    private var _binding : FragmentSlpashScreenBinding? = null
    private lateinit var  onboardingSharedPreferences: OnboardingSharedPreferences
    private val binding get() = _binding!!
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
        _binding = FragmentSlpashScreenBinding.inflate(inflater,container,false)
        onboardingSharedPreferences.getBool("isFirstTime", true)
        binding.apply {
            object : CountDownTimer(3000, 1000) {


                override fun onTick(millisUntilFinished: Long) {

                }

                override fun onFinish() {
                if(onboardingSharedPreferences.getBool("isFirstTime", true)){
                    findNavController().navigate(R.id.action_slpashScreenFragment_to_onboardingFragment)
                }else{
                    findNavController().navigate(R.id.action_slpashScreenFragment_to_scannerFragment)
                }
                }
            }.start()
        }

        return binding.root
    }

}