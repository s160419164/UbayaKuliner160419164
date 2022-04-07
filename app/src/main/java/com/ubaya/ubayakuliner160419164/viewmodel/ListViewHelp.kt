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
import com.ubaya.ubayakuliner160419164.model.Help
import org.json.JSONObject

class ListViewHelp (application: Application): AndroidViewModel(application) {
    val helpLD = MutableLiveData<List<Help>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/8aaa044befedf049b2fee732ba34357944a36f85/help.json"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {response ->
                val data = JSONObject(response).getJSONArray("help").toString()
                val sType = object : TypeToken<List<Help>>(){}.type
                val  result = Gson().fromJson<List<Help>>(data,sType)
                helpLD.value = result
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