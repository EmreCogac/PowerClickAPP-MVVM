package com.powerclick.app.view

import android.os.Bundle
import android.os.CountDownTimer
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
            object : CountDownTimer(5000, 1000) {

                // Callback function, fired on regular interval
                override fun onTick(millisUntilFinished: Long) {
                    denme.setText("" + millisUntilFinished / 1000)
                }

                // Callback function, fired
                // when the time is up
                override fun onFinish() {
                    findNavController().navigate(R.id.action_slpashScreenFragment_to_scannerFragment)
                }
            }.start()
        }

        return binding.root
    }

}