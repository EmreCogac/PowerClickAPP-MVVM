package com.powerclick.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentSlpashScreenBinding


class SlpashScreenFragment : Fragment() {

    private var _binding : FragmentSlpashScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlpashScreenBinding.inflate(inflater,container,false)
        binding.apply {
            btn.setOnClickListener {
                findNavController().navigate(R.id.action_slpashScreenFragment_to_scannerFragment)
            }
        }
        return binding.root
    }

}