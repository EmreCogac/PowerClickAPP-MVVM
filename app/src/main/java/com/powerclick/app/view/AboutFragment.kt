package com.powerclick.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var _binding : FragmentAboutBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater,container,false)

        binding.apply {
            testButton.setOnClickListener {
                Toast.makeText(context,"Testdata", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
        }

}