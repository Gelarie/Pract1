package com.example.myapplication

import android.app.DownloadManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.UsersAdapter
import com.example.myapplication.GitInfo
import com.example.myapplication.R.id.recyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException



class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        fetchRepositoriesJson()


    }
}
    fun fetchRepositoriesJson(){
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://api.github.com/users/square/repos")
                .build()
        val response = client.newCall(request).execute()
        val responseText = response.body()!!.string()
        val repos = Gson().fromJson(responseText, GitInfo.List::class.java)
        android.util.Log.d("Repos", repos.joinToString { it.name })

    }










