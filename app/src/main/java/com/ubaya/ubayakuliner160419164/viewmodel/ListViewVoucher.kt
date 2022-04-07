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
import com.ubaya.ubayakuliner160419164.model.Review
import com.ubaya.ubayakuliner160419164.model.Voucher
import org.json.JSONObject

class ListViewVoucher(application: Application): AndroidViewModel(application) {
    val voucherLD = MutableLiveData<List<Voucher>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/79d7a80c319091e936998b43ce0e79172ea1cb7d/voucher.json"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {response ->
                val data = JSONObject(response).getJSONArray("voucher").toString()
                val sType = object : TypeToken<List<Voucher>>(){}.type
                val  result = Gson().fromJson<List<Voucher>>(data,sType)
                voucherLD.value = result
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