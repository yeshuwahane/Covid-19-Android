package com.alien.covid.Network

import com.alien.covid.Model.CovidResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


private const val BASE_URL = "https://api.apify.com/"
const val NewEndPoint = "v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true"


interface CovidAPI {

    companion object{
        operator fun invoke():CovidAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidAPI::class.java)
        }
    }

    @GET(NewEndPoint)
    fun getCovidData():Call<CovidResponse>
}