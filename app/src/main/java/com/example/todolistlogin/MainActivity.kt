package com.example.todolistlogin

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)  //ログイン
        val textView1 = findViewById<TextView>(R.id.textView1)  //ユーザーID
        val textView2 = findViewById<TextView>(R.id.textView2)  //名前
        val textView3 = findViewById<TextView>(R.id.textView3)  //パスワード
        val textView4 = findViewById<TextView>(R.id.textView4)  //新規登録について

        val editText1 = findViewById<EditText>(R.id.editText1)  //ユーザーID
        val editText2 = findViewById<EditText>(R.id.editText2)  //名前
        val editText3 = findViewById<EditText>(R.id.editText3)  //パスワード

        val button1 = findViewById<Button>(R.id.button1)  //ログイン
        val button2 = findViewById<Button>(R.id.button2)  //新規登録
        //ログイン処理
        button1.setOnClickListener {
            // 起動する対象をクラスオブジェクトで指定する
            val intent = Intent(this@MainActivity, AfterLogin::class.java)
            intent.putExtra("VALUE1", editText1.text.toString())
            intent.putExtra("VALUE2", editText2.text.toString())
            intent.putExtra("VALUE3", editText3.text.toString())
            val VALUE1="VALUE1"
            val VALUE2="VALUE2"
            val VALUE3="VALUE3"
            //ここでサーバと通信し、データベース上に同じものがあればメイン画面へ
            val (request, response, result) =
                "https://jsonplaceholder.typicode.com/posts"
                    .httpGet(listOf("userId" to VALUE1)).response()

            //何か１つでも間違えていたらMissLoginへ。

        }
        //新規登録処理
        button2.setOnClickListener {
            // 起動する対象をクラスオブジェクトで指定する
            val intent = Intent(this@MainActivity, NewRegister::class.java)
            intent.putExtra("VALUE1", editText1.text.toString())//書かれていないはず
            intent.putExtra("VALUE2", editText2.text.toString())
            intent.putExtra("VALUE3", editText3.text.toString())
            val VALUE1="VALUE1"
            val VALUE2="VALUE2"
            val VALUE3="VALUE3"
            startActivity(intent)
            //もし、名前とパスワード両方が書かれていなかったらMissLoginへ。
            if(VALUE1!=null)//ID:書かれていないはず
            startActivity(intent)
            if(VALUE2.isEmpty())//name:何か書かれていないといけない
                startActivity(intent)
            if (VALUE3.isEmpty())//pass:何か書かれていないといけない
                startActivity(intent)
            //ここでサーバと通信し、データベースから最後のユーザーIDを持ってきて、
            "https://www.casareal.co.jp/".httpGet().response { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        // レスポンスボディを表示
                        println("非同期処理の結果：" + String(response.data))
                    }
                    is Result.Failure -> {
                        println("通信に失敗しました。")
                    }
                }
            }
            //それ＋１のユーザーIDを指定。ユーザー情報をデータベースに書き込む。


        }
    }
}