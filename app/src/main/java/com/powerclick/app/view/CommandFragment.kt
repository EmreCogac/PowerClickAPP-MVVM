package com.powerclick.app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.powerclick.app.databinding.FragmentCommandBinding
import com.powerclick.app.model.IpDataClass
import com.powerclick.app.viewModel.HTTPViewModel


class CommandFragment : Fragment() {

    private var _binding : FragmentCommandBinding? = null
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
        _binding = FragmentCommandBinding.inflate(inflater,container,false)
        binding.apply {
        test.setOnClickListener {
            val data = ip.text.toString()
            if(data.isNotEmpty()){
                val model = IpDataClass(data)
                httpViewModel?.test(model)
            }
        }
        }
        return binding.root
    }

}