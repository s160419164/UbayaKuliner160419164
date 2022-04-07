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
import org.json.JSONObject

class ListViewModel(application: Application):AndroidViewModel(application) {
    val kulinerLD = MutableLiveData<List<Kuliner>>()

    val TAG = "volleyTag"
    private var queue:RequestQueue?= null

    fun refresh(){

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/6b48c0f5606e7b925097be95eb5040c999624d9e/kuliner.json"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {response ->
                val data = JSONObject(response).getJSONArray("kuliner").toString()
                val sType = object : TypeToken<List<Kuliner>>(){}.type
                val  result = Gson().fromJson<List<Kuliner>>(data,sType)
                kulinerLD.value = result
                GlobalData.globalKuliner = result as ArrayList<Kuliner>
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