package com.powerclick.app.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import com.powerclick.app.R
import com.powerclick.app.databinding.FragmentScannerBinding
import com.powerclick.app.shared_preferences.IpDataShared
import com.powerclick.app.viewModel.HTTPViewModel

class ScannerFragment : Fragment() {

    private var _binding : FragmentScannerBinding? = null
    private val binding get() = _binding!!
    private var httpViewModel : HTTPViewModel? = null
    private var data : String? = null
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
    ): View? {
        _binding = FragmentScannerBinding.inflate(inflater,container,false)
        data = IpDataShared(requireContext()).toString()

        binding.apply {
            btnqr.setOnClickListener {
                val options = ScanOptions()
                options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
                options.setPrompt("Lütfen qr'ı kareye oturturnuz")
                options.setCameraId(0)
                options.setOrientationLocked(true)
                options.setBarcodeImageEnabled(true)
                barcodeLauncher.launch(options)
            }

            qrText.text = ipDataShared.getString("ip", "null")

        }

        return binding.root
    }
    private val barcodeLauncher = registerForActivityResult<ScanOptions, ScanIntentResult>(
        ScanContract()
    )  { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            data = result.contents
            ipDataShared.setString("ip", data.toString())
            binding.qrText.text = ipDataShared.getString("ip","null")
        }
    }


}