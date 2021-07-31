package com.example.mgdh_kotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mgdh_kotlin.Model.Partner
import com.example.mgdh_kotlin.databinding.PartnerItemBinding

class MyAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var partners = mutableListOf<Partner>()
    fun setdata(partners:List<Partner>){
        this.partners=partners.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val  inflater = LayoutInflater.from(parent.context)
        val binding=PartnerItemBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return partners.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
      val partner =partners[position]
        holder.binding.name.text=partner.name
    }


}
class MainViewHolder(val binding: PartnerItemBinding): RecyclerView.ViewHolder(binding.root)