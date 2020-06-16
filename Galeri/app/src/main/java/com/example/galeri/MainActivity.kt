package com.example.galeri

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Camera.setOnClickListener {
            val ImageTakeIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(ImageTakeIntent, 1)
        }

        Galeri.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }

        video.setOnClickListener {
            val VideoTakeIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(VideoTakeIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            Img.setImageURI(data?.data)
        }

        if(resultCode == 1 && requestCode == Activity.RESULT_OK){
            val extras = data?.extras
            val bitmap = extras?.get("data") as Bitmap?
            Img.setImageBitmap(bitmap)
        }

        if(resultCode == 1 && requestCode == Activity.RESULT_OK){
            val extras = data?.extras
            val bitmap = extras?.get("data") as Bitmap?
            Img.setImageBitmap(bitmap)
        }
    }
}