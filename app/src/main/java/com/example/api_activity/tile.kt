package com.example.api_activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tile() {
    lateinit var img : ImageView
    lateinit var draw : RequestCreator
    var flipped = false
    fun init(i : ImageView){
        img = i
        getDuck(this)
        //img.setImageResource(0)
        //img.setBackgroundColor(Color.rgb(1f,0f,1f))
    }
    fun flip(){
        getDuck(this)
    }
}