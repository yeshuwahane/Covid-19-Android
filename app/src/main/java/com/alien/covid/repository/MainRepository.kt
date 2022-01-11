package com.alien.covid.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alien.covid.Model.CovidResponse
import com.alien.covid.Network.CovidAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {


    val response_liveData = MutableLiveData<CovidResponse>()

    fun getData(){

        CovidAPI().getCovidData().enqueue(object : Callback<CovidResponse>{
            override fun onResponse(call: Call<CovidResponse>, response: Response<CovidResponse>) {
                Log.d("Yeshu","This is success ${response.body()}")
                response_liveData.value = response.body()

            }

            override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                Log.d("Yeshu","Failed ${t.message}")
            }

        })
    }


}