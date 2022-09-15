package com.example.samplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var res = intent.getStringExtra("Result")
        val textRes = findViewById<TextView>(R.id.resultText)
        textRes.text = res

    }
    fun prev(view : View){
        onBackPressed()
    }
}