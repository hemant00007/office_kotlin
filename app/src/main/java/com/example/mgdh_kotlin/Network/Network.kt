package com.example.mgdh_kotlin.Network

import com.example.mgdh_kotlin.Model.Partner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface Network {
    @GET("list")
    fun getpartnerlist(@Header("Token")  token:String):Call<List<Partner>>

    companion object{
        var  network:Network?=null

        fun getInstance(): Network{
            if (network==null){
                val retrofit=Retrofit.Builder()
                    .baseUrl("https://mgdh.in/api/v2/user/partner/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                network=retrofit.create(Network::class.java)
            }
            return network!!
        }
    }
}