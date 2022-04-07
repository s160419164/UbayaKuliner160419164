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
import org.json.JSONObject


class ListViewReview(application: Application):AndroidViewModel(application) {
    val reviewLD = MutableLiveData<List<Review>>()

    val TAGR = "volleyTag"
    private var queue: RequestQueue?= null

    fun refreshR(){
        queue = Volley.newRequestQueue(getApplication())
        val urlR = "https://gist.githubusercontent.com/s160419164/0317852796a25beca2d9040b9255c11e/raw/51d13caece5bbbf78133dd32415d91d369b2a242/review.json"

        val stringRequestR = StringRequest(
            Request.Method.GET,urlR,
            {response ->
                val data = JSONObject(response).getJSONArray("review").toString()
                val sType = object : TypeToken<List<Review>>(){}.type
                val  result = Gson().fromJson<List<Review>>(data,sType)
                reviewLD.value = result
                Log.d("showvolley", response.toString())

            },
            {
                Log.d("showvolley",it.toString())
            }
        )
        stringRequestR.tag = TAGR
        queue?.add(stringRequestR)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAGR)
    }
}