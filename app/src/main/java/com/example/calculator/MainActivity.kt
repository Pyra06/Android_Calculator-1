package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity()
    {
        lateinit var editText1: EditText
        lateinit var editText2: EditText
        lateinit var Button1: Button
        lateinit var Button2: Button
        lateinit var Button3: Button
        lateinit var Button4: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            editText1 = findViewById(R.id.num1)
            editText2 = findViewById(R.id.num2)
            Button1 = findViewById(R.id.bt1)
            Button2 = findViewById(R.id.bt2)
            Button3 = findViewById(R.id.bt3)
            Button4 = findViewById(R.id.bt4)
            editText1.addTextChangedListener(mTextWatcher)
            editText2.addTextChangedListener(mTextWatcher)

            bt1.setOnClickListener{

                textResult.text = (num1.text.toString().toFloat() + num2.text.toString().toFloat()).toString()
            }

            bt2.setOnClickListener {

                textResult.text = (num1.text.toString().toFloat() - num2.text.toString().toFloat()).toString()
            }

            bt3.setOnClickListener {

                textResult.text = (num1.text.toString().toFloat() * num2.text.toString().toFloat()).toString()
            }

            bt4.setOnClickListener {

                textResult.text = (num1.text.toString().toFloat() / num2.text.toString().toFloat()).toString()
            }

        }

        fun clearInput(view: View) {
            num1?.text?.clear()
            num2?.text?.clear()
            textResult.setText("")
        }

        fun closeApp(view: View) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            exitProcess(1)

        }

        private var mTextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            var number1 = editText1.text.toString()
            var number2 = editText2.text.toString()
                Button1.isEnabled=(!number1.isEmpty() && !number2.isEmpty())
                Button2.isEnabled=(!number1.isEmpty() && !number2.isEmpty())
                Button3.isEnabled=(!number1.isEmpty() && !number2.isEmpty())
                Button4.isEnabled=(!number1.isEmpty() && !number2.isEmpty())

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }

    }




