package com.example.listview

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val req = 1
    private val  read = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val perm = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
        if (perm == PackageManager.PERMISSION_GRANTED){
            read == true
        }else{
            ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.READ_CONTACTS), req)
        }
        if(read){
            loadContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {when (requestCode){
        req -> {
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                loadContacts()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),req)
            }
        }
    }

    }

    private  fun loadContacts(){
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        val from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID)
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val simple = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to)
        contList.adapter = simple
    }
}