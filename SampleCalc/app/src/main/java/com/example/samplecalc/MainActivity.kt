package com.example.samplecalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun sum(view : View){
        val op1 = findViewById<EditText>(R.id.op1)
        val op2 = findViewById<EditText>(R.id.op2)

        var result : BigDecimal

        try{
            var x : BigDecimal = op1.text.toString().toBigDecimal()
            var y : BigDecimal = op2.text.toString().toBigDecimal()
            result = x + y
        } catch (e: Exception){
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, R.string.exceptionWarning, duration)
            toast.show()
            return
        }

        val intent = Intent(this@MainActivity, ResultActivity::class.java)
        intent.putExtra("Result", result.toString())
        startActivity(intent)
    }

    fun minus(view : View){
        val op1 = findViewById<EditText>(R.id.op1)
        val op2 = findViewById<EditText>(R.id.op2)

        var result : BigDecimal

        try{
            var x : BigDecimal = op1.text.toString().toBigDecimal()
            var y : BigDecimal = op2.text.toString().toBigDecimal()
            result = x - y
        } catch (e: Exception){
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, R.string.exceptionWarning, duration)
            toast.show()
            return
        }

        val intent = Intent(this@MainActivity, ResultActivity::class.java)
        intent.putExtra("Result", result.toString())
        startActivity(intent)
    }

    fun mult(view : View){
        val op1 = findViewById<EditText>(R.id.op1)
        val op2 = findViewById<EditText>(R.id.op2)

        var result : BigDecimal

        try{
            var x : BigDecimal = op1.text.toString().toBigDecimal()
            var y : BigDecimal = op2.text.toString().toBigDecimal()
            result = x.multiply(y,  MathContext.DECIMAL64)
        } catch (e: Exception){
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, R.string.exceptionWarning, duration)
            toast.show()
            return
        }

        val intent = Intent(this@MainActivity, ResultActivity::class.java)
        intent.putExtra("Result", result.toString())
        startActivity(intent)
    }


    fun dev(view : View){
        val op1 = findViewById<EditText>(R.id.op1)
        val op2 = findViewById<EditText>(R.id.op2)

        var result : BigDecimal

        try{
            var x : BigDecimal = op1.text.toString().toBigDecimal()
            var y : BigDecimal = op2.text.toString().toBigDecimal()
            result = x.divide(y,  MathContext.DECIMAL64)
        } catch (e: Exception){
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, R.string.exceptionWarning, duration)
            toast.show()
            return
        }

        val intent = Intent(this@MainActivity, ResultActivity::class.java)
        intent.putExtra("Result", result.toString())
        startActivity(intent)
    }

}