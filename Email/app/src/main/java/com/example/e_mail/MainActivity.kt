package com.example.e_mail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {sendMail()}
    }
    private fun sendMail(){
        val recipientList: String = edtTo.text.toString()
        val recipients = recipientList.split(",").toTypedArray()

        val subject:String = edtSubject.text.toString()
        val message:String = edtMessage.text.toString()

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, recipients)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "message/rfc822"

        startActivity(Intent.createChooser(intent, "Через какой почтовый клиент отправить письмо?"))
    }
}
