package com.example.mgdh_kotlin.ViewModel

import android.view.Window
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mgdh_kotlin.Model.Partner
import com.example.mgdh_kotlin.Repo.MyRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel constructor(private val repo:MyRepository) :ViewModel(){

    val  partners =MutableLiveData<List<Partner>>()
    val  error = MutableLiveData<String>()

    fun getallpartner(){
        val response = repo.getallpartner()
        response.enqueue(object :Callback<List<Partner>>{
            override fun onFailure(call: Call<List<Partner>>, t: Throwable) {
               error.postValue(t.message)
            }

            override fun onResponse(call: Call<List<Partner>>, response: Response<List<Partner>>) {
               partners.postValue(response.body())
            }

        })
    }

}