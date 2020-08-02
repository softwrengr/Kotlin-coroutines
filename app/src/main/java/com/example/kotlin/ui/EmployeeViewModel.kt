package com.example.kotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.models.Employee
import com.example.kotlin.models.EmployeeResponse
import com.example.kotlin.network.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmployeeViewModel : ViewModel() {

    val employeeList: LiveData<List<Employee>?> = MutableLiveData()

    init {

        viewModelScope.launch {
            employeeList as MutableLiveData

            val employee = getEmployee()
            employeeList.value = employee?.data
        }
    }

    private suspend fun getEmployee(): EmployeeResponse? {
        return withContext(Dispatchers.IO) {
            ApiServices().getEmployee().body()
        }
    }

}