package com.powerclick.app.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentOnboardingBinding
import com.powerclick.app.shared_preferences.OnboardingSharedPreferences


class OnboardingFragment : Fragment() {
    private var _binding : FragmentOnboardingBinding?  = null
    private val binding get() =  _binding!!
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
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        onboardingSharedPreferences.setBool("isFirstTime", false)
        binding.apply {
            binding.gec.setOnClickListener {
                findNavController().navigate(R.id.action_onboardingFragment_to_scannerFragment)
            }
        }
        return binding.root
    }

}