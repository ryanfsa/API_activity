package com.example.api_activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import android.graphics.BitmapFactory

import android.graphics.Bitmap

import android.R
import android.annotation.SuppressLint
import android.provider.ContactsContract
import android.service.quicksettings.Tile
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_activity.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.nio.channels.Pipe


@SuppressLint("StaticFieldLeak")
var flipped : tile? = null
class MainActivity : AppCompatActivity() {
    lateinit var adapter : tileAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.layoutManager = GridLayoutManager(this,4)
        adapter = tileAdapter(listOf(tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),tile(),))
        binding.mainRecyclerView.adapter = adapter
    }
}
fun getDuck(t : tile) {
    val duckApi = RetrofitHelper.getInstance().create(DuckService::class.java)
    val duckCall = duckApi.getDuck()
    duckCall.enqueue(object : Callback<duck> {
        override fun onResponse(call: Call<duck>, response: Response<duck>) {
            var d = response.body()
            var url = d!!.url
            t.draw = Picasso.get().load(url).resize(2000,2000)
            t.draw.into(t.img)
        }
        override fun onFailure(call: Call<duck>, t: Throwable) {
        }
    })
}