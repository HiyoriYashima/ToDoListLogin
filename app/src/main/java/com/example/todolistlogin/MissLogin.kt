package com.example.todolistlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MissLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miss_login)
        val button = findViewById<Button>(R.id.button)  //戻る
        val textView = findViewById<TextView>(R.id.textView)  //aaa
        val value1 = intent.getStringExtra("VALUE")
        textView.text = "ログインの場合：ユーザID,名前,パスワードが一致しません。"
        val textView2 = findViewById<TextView>(R.id.textView2)  //aaa
        textView2.text = "新規登録の場合：名前とパスワードどちらかが抜けています。"
        button.setOnClickListener {
            finish()
        }
    }
}