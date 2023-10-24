package com.example.attendancesystemandroid.ui.fragment.sort

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.attendancesystemandroid.data.remote.ApiHelper
import com.example.attendancesystemandroid.data.remote.ApiService
import com.example.attendancesystemandroid.data.remote.ServiceCreator
import com.example.attendancesystemandroid.data.repository.SortRepository
import com.example.attendancesystemandroid.utils.Resource
import kotlinx.coroutines.Dispatchers

class SortViewModel:ViewModel(){

    private var sortRepository: SortRepository = SortRepository(ApiHelper(ServiceCreator.create(ApiService::class.java)))

    fun getRank(index: Int) = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            when(index){
                2->emit(Resource.success(data = sortRepository.getOldUsers()))
                1->emit(Resource.success(data = sortRepository.getUsers()))
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


}