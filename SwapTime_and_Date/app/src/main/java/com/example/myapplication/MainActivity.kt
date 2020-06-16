package com.example.myapplication

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.location.Address
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException
import java.util.*

class MainActivity : AppCompatActivity(), ExampleDialog.ExampleDialogListener {

    public override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_main)
    }

    fun showDialog(view: View) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Цвет заднего фона приложения")

        builder.setMessage("Вы хотите поменять фон на зеленый?")

        builder.setPositiveButton("Да"){dialog, which ->
            Toast.makeText(applicationContext, "Фон изменился", Toast.LENGTH_SHORT).show()
            fon.setBackgroundColor(Color.GREEN)
        }
        builder.setNegativeButton("Нет"){dialog, which ->
            Toast.makeText(applicationContext, "Фон не поменялся", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Отмена"){ _, _ ->
            Toast.makeText(applicationContext, "Отмена операции", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showDialogRadioButton(view: View) {
        val namesArray =
            arrayOf("Первый", "Второй", "Третий")
        val builder =
            AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Выбор поля из списка: ")
            .setSingleChoiceItems(
                namesArray, -1
            ) {dialog, item ->
                Toast.makeText(
                    this@MainActivity, "Вы выбрали: " + namesArray[item],
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setPositiveButton("ОК"){dialog, id ->
            }
            .setNegativeButton(
                "Отмена"
            ){dialog, id ->}
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showAlertTextFields(view: View) {
        val exampleDialog = ExampleDialog()
        exampleDialog.show(supportFragmentManager, "Пример окна")
    }
    override fun applyTexts(address: String?, city: String?, comment: String?) {
        Toast.makeText(
            this@MainActivity, "Вы ввели: $address, $city, $comment",
            Toast.LENGTH_SHORT
        ).show()
    }
}
class ExampleDialog : AppCompatDialogFragment(){
    private var editTextAddress: EditText? = null
    private var editTextCity: EditText? = null
    private var editTextComment: EditText? = null
    private var listener: ExampleDialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(activity)
            val inflater = activity!!.layoutInflater
            val view: View = inflater.inflate(R.layout.dialog_text_alert, null)

            builder.setView(view)
                .setTitle("Добавте адрес")
                .setNegativeButton("отмена"){ dialogInterface, i ->  }
                .setPositiveButton("ок") { dialogInterface, i ->
                    val address = editTextAddress!!.text.toString()
                    val city = editTextCity!!.text.toString()
                    val comment = editTextComment!!.text.toString()
                    listener!!.applyTexts(address, city, comment)
                }
        editTextAddress = view.findViewById(R.id.edtAddress)
        editTextCity = view.findViewById(R.id.edtCity)
        editTextComment = view.findViewById(R.id.edtComment)
        return builder.create()
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        listener = try {
            context as ExampleDialogListener
        } catch (e: ClassCastException){
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }

    interface ExampleDialogListener{
        fun applyTexts(
            address: String?,
            city: String?,
            comment: String?
        )
    }
}