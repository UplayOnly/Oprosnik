package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    var users: ArrayList<String> = ArrayList()
    private var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserList()
    }
    private fun getUserList(){
        _imageRecyclerView.visibility = View.VISIBLE
        _imageRecyclerView.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        val version = ArrayList<ItemOfList>()
        version.addAll(ItemOfList.getAndroidVersionList())
        val Adap = ItemAdapter(version)
        _imageRecyclerView.adapter = Adap
    }
}