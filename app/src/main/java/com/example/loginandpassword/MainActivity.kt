package com.example.loginandpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int){
        login (1),
        password (2),
        success (0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idTxtLogin)
        val txtPassword = findViewById<TextView>(R.id.idTxtPassword)
        val txtButton = findViewById<Button>(R.id.idBtn)

        txtButton.setOnClickListener {
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else ->
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Emily"
        val holdPassword = "password"

        if (holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPassword != txtPassword){
            return LoginSuccess.password
        } else LoginSuccess.success

    }
}