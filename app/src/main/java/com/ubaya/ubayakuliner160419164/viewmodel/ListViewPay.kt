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
import com.ubaya.ubayakuliner160419164.model.Pay
import org.json.JSONObject

class ListViewPay (application: Application): AndroidViewModel(application) {
    val payLD = MutableLiveData<List<Pay>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/f216ccfe5aadb922c641caa7f260af6fb39c7b56/pay.json"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {response ->
                val data = JSONObject(response).getJSONArray("pay").toString()
                val sType = object : TypeToken<List<Pay>>(){}.type
                val  result = Gson().fromJson<List<Pay>>(data,sType)
                payLD.value = result
                Log.d("showvolley", response.toString())

            },
            {
                Log.d("showvolley",it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}