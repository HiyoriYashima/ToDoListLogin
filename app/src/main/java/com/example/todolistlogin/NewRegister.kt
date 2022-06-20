package com.example.todolistlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NewRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_register)
        val button = findViewById<Button>(R.id.button)  //メインへ
        val textView1 = findViewById<TextView>(R.id.textView1)  //aaa
        val value1 = intent.getStringExtra("VALUE1")
        textView1.text = "ユーザID：${value1}"
        val textView2 = findViewById<TextView>(R.id.textView2)  //aaa
        val value2 = intent.getStringExtra("VALUE2")
        textView2.text = "名前：${value2}"
        val textView3 = findViewById<TextView>(R.id.textView3)  //aaa
        val value3 = intent.getStringExtra("VALUE3")
        textView3.text = "パスワード：${value3}"

    }
}