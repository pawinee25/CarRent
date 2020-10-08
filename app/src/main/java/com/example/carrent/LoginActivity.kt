package com.example.carrent

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        bt_login.setOnClickListener {
            val username = edt_loginusername.getContents()
            val password = edt_loginpassword.getContents()
            viewModel.requestLogin(username, password)
        }

        bt_register1.setOnClickListener {
            startActivity(Intent(baseContext, RegisterActivity::class.java))
        }

        viewModel.responselogin().observe {
            if (it) {
                startActivity(Intent(baseContext, MainActivity::class.java))
                // go to main
            } else {
                toast("ชื่อหรือรหัสผ่านไม่ถูกต้อง")
            }
        }

        viewModel.responseToast().observe {
            toast(it)
        }
    }
}
