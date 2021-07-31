package com.example.mgdh_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mgdh_kotlin.Adapter.MyAdapter
import com.example.mgdh_kotlin.Network.Network
import com.example.mgdh_kotlin.Repo.MyRepository
import com.example.mgdh_kotlin.ViewModel.MyViewModel
import com.example.mgdh_kotlin.ViewModel.MyViewModelFactory
import com.example.mgdh_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
     val adapter=MyAdapter()
    val network=Network.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this,MyViewModelFactory(MyRepository(network))).get(MyViewModel::class.java)
        binding.recyclerview.adapter
        viewModel.partners.observe(this, Observer {
            adapter.setdata(it)
            Log.d("partnerlist",it.toString())
        })
        viewModel.partners.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        })
        viewModel.getallpartner()
    }
}