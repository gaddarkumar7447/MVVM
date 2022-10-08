package com.example.mvvm

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
        @GET("quotes")
        fun getData () : Call<List<MyJsonDataItem>>
}