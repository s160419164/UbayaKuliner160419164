package com.ubaya.ubayakuliner160419164.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.ubayakuliner160419164.model.Kuliner
import com.ubaya.ubayakuliner160419164.util.GlobalData

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val kulinerLD = MutableLiveData<Kuliner>()
    fun getKulinerID(kulinerID:String){
        for(i in GlobalData.globalKuliner){
            if(i.id == kulinerID){
                kulinerLD.value = i
            }
        }
    }
}