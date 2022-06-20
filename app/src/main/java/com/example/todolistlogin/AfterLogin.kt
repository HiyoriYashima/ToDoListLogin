package com.example.todolistlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AfterLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)
        val button = findViewById<Button>(R.id.button)  //戻る
        val textView = findViewById<TextView>(R.id.textView)  //aaa
        val value1 = intent.getStringExtra("VALUE1")
        textView.text = "入力された値：${value1}"

        button.setOnClickListener {
            finish()
        }

    }
}