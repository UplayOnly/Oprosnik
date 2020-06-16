package com.example.animatoin

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tween_animations.*

class TweenAnimations : AppCompatActivity() {
    lateinit var anim: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_animations)
        start.setOnClickListener {
            anim = AnimationUtils.loadAnimation(this, R.anim.exemple_anim)
            TweenImg.startAnimation(anim)
        }
        But_Last1.setOnClickListener{
        startActivity(Intent(this, MainActivity::class.java))}
    }
}