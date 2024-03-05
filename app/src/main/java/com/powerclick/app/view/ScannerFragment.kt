package com.powerclick.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentScannerBinding
import com.powerclick.app.viewModel.HTTPViewModel

class ScannerFragment : Fragment() {

    private var _binding : FragmentScannerBinding? = null
    private val binding get() = _binding!!
    private var httpViewModel : HTTPViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        httpViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(activity?.application!!)).get(HTTPViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_scanner, container, false)
    }


}