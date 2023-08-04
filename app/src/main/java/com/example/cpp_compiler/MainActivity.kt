package com.example.cpp_compiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var num1ET:EditText
    private lateinit var num2ET:EditText
    private lateinit var totalTV:TextView

    private var result:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        System.loadLibrary("native-lib")

        num1ET = findViewById(R.id.num1ET)
        num2ET = findViewById(R.id.num2ET)
        totalTV = findViewById(R.id.totalTV)

        val addBtn = findViewById<Button>(R.id.addBTN)
        addBtn.setOnClickListener { addition() }

        val subBtn = findViewById<Button>(R.id.subBTN)
        subBtn.setOnClickListener { subtraction() }

        val mulBtn = findViewById<Button>(R.id.mulBTN)
        mulBtn.setOnClickListener { multiplication() }

        val divBtn = findViewById<Button>(R.id.divBTN)
        divBtn.setOnClickListener { division() }



    }

    private fun division() {
        result = getAnswer(num1ET.text.toString().toInt(), num2ET.text.toString().toInt(), "/")
        totalTV.text = result.toString()
    }

    private fun multiplication() {
        result = getAnswer(num1ET.text.toString().toInt(), num2ET.text.toString().toInt(), "*")
        totalTV.text = result.toString()
    }

    private fun subtraction() {
        result = getAnswer(num1ET.text.toString().toInt(), num2ET.text.toString().toInt(), "-")
        totalTV.text = result.toString()
    }

    private fun addition() {
        result = getAnswer(num1ET.text.toString().toInt(), num2ET.text.toString().toInt(), "+")
        totalTV.text = result.toString()
    }

    private external fun getAnswer(num1:Int, num2:Int, checkBTN:String): Int

}