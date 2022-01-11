package com.alien.covid.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alien.covid.Model.CovidResponse
import com.alien.covid.repository.MainRepository

class MainViewModel : ViewModel() {

    val mainRepository = MainRepository()
    var responseLiveData = MutableLiveData<CovidResponse>()

    init {
        responseLiveData = mainRepository.response_liveData
    }


    fun getData(){
        mainRepository.getData()
    }
}