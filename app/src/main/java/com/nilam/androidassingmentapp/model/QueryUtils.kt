package com.nilam.androidassingmentapp.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest


import com.android.volley.toolbox.Volley

//this class is not used
class QueryUtils {

    companion object{
        var mutableLiveData:MutableLiveData<String> = MutableLiveData()
        var liveDataString : LiveData<String> = MutableLiveData()

        fun videoDownload(context:Context,url:String){
            //volley request
            val queue= Volley.newRequestQueue(context)
            val stringRequest= StringRequest(Request.Method.GET, url,Response.Listener<String> {

                  mutableLiveData.value=it
                  liveDataString= mutableLiveData


            },
            Response.ErrorListener {

                    mutableLiveData.value= it?.message

            })
            stringRequest.setRetryPolicy(DefaultRetryPolicy(20000,1,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT))
            queue.add(stringRequest)
        }


    }
}