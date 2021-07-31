package com.example.mgdh_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mgdh_kotlin.Repo.MyRepository

class MyViewModelFactory constructor(private val repository: MyRepository): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MyViewModel(repository) as T
    }

}