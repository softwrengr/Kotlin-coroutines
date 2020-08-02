package com.example.kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.databinding.ItemLayoutBinding
import com.example.kotlin.models.Employee

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {

    var employees:List<Employee>? = null

    fun setItems(list: List<Employee>?) {
        employees = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout,
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
       return employees?.size?:0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.employee = employees!![position]
    }

    inner class MyViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)
}