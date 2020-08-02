package com.example.kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.R
import com.example.kotlin.adapter.EmployeeAdapter
import com.example.kotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val quotesAdapter by lazy { EmployeeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)


        val viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)

        viewModel.employeeList.observe(this, Observer {
            quotesAdapter.setItems(it)
            recyclerview.adapter = quotesAdapter

        })

    }
}