package com.example.animatoin

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_frame_animations.*

class FrameAnimations: AppCompatActivity() {
    lateinit var anim: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animations)
        (FrameImg.background as AnimationDrawable).start()
        But_Last.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}