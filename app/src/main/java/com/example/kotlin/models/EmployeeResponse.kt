package com.example.kotlin.models

data class EmployeeResponse (
        val status: Boolean,
        val data: List<Employee>,
        val message:String)