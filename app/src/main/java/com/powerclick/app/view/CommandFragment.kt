package com.powerclick.app.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.powerclick.app.databinding.FragmentCommandBinding
import com.powerclick.app.model.IpDataClass
import com.powerclick.app.shared_preferences.IpDataShared
import com.powerclick.app.viewModel.HTTPViewModel


class CommandFragment : Fragment() {

    private var _binding : FragmentCommandBinding? = null
    private val binding get() = _binding!!
    private var httpViewModel : HTTPViewModel? = null
    private lateinit var ipDataShared : IpDataShared
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ipDataShared = IpDataShared(requireContext())

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        httpViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(activity?.application!!)).get(HTTPViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommandBinding.inflate(inflater,container,false)


        binding.apply {
            iptext.text = ipDataShared.getString("ip", "no ip")
            left.setOnClickListener{
                val data =  ipDataShared.getString("ip", "no ip")
                if (data.isNotEmpty()){
                    val model = IpDataClass(data)
                    httpViewModel?.left(model)
                }
            }

            right.setOnClickListener {
                val data =  ipDataShared.getString("ip", "no ip")
                if(data.isNotEmpty()){
                    val model = IpDataClass(data)
                    httpViewModel?.right(model)
                }
            }


            save.setOnClickListener {
                val data  = ip.text.toString()
                if(data.isNotEmpty()){
                    ipDataShared.setString("ip",data)
                }
                iptext.text = ipDataShared.getString("ip", "no ip")
            }

//            test.setOnClickListener {
//                val data =  ipDataShared.getString("ip", "no ip")
//                if(data.isNotEmpty()){
//                    val model = IpDataClass(data)
//                    httpViewModel?.test(model)
//                }
//        }

        }
        return binding.root
    }


}