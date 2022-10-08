package com.example.mvvm

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.withStarted
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding : ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter
    lateinit var pro : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pro = findViewById(R.id.prog)
        pro.visibility =  View.VISIBLE
        getMyData()

        /*findViewById<Button>(R.id.buttonPanel).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ContentView::class.java))
        })*/
    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://type.fit/api/").build().create(ApiInterface ::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyJsonDataItem>?> {
            override fun onResponse(call: Call<List<MyJsonDataItem>?>, response: Response<List<MyJsonDataItem>?>) {
                val responce = response.body()!!
                adapter = Adapter(applicationContext, responce as ArrayList<MyJsonDataItem>)
                recyclerView.adapter = adapter
                pro.visibility =  View.INVISIBLE
            }


            override fun onFailure(call: Call<List<MyJsonDataItem>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Not responding", Toast.LENGTH_SHORT).show()
            }
        })
    }

}

