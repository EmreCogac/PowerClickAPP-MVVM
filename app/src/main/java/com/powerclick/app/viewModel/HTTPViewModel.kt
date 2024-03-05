package com.powerclick.app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.powerclick.app.model.IpDataClass
import com.powerclick.app.repository.HTTPRepository

class HTTPViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: HTTPRepository

    init {
        repository = HTTPRepository(application)
    }

    fun test(ipDataClass: IpDataClass){
        repository.testRequest(ipDataClass)
    }

    fun left(ipDataClass: IpDataClass){
        repository.leftRequest(ipDataClass)
    }

    fun right(ipDataClass: IpDataClass){
        repository.rightRequest(ipDataClass)
    }
}