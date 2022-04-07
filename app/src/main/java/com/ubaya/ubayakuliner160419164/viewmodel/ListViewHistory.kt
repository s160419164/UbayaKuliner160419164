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
import com.ubaya.ubayakuliner160419164.model.History
import com.ubaya.ubayakuliner160419164.model.Review
import org.json.JSONObject

class ListViewHistory (application: Application): AndroidViewModel(application) {
    val historyLD = MutableLiveData<List<History>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        queue = Volley.newRequestQueue(getApplication())
        val urlR = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/1cb184c5f3d577b23e3cbb97da1ba1b77321cbc5/history.json"

        val stringRequest = StringRequest(
            Request.Method.GET,urlR,
            {response ->
                val data = JSONObject(response).getJSONArray("history").toString()
                val sType = object : TypeToken<List<History>>(){}.type
                val  result = Gson().fromJson<List<History>>(data,sType)
                historyLD.value = result
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