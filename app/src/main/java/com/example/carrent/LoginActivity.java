package com.example.carrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private Button mBtregister;
    private Button mBtlogin;
    private LoginViewModel viewModel;
    private EditText mEdtloginusername;
    private EditText mEdtloginpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        mEdtloginusername = (EditText) findViewById(R.id.edt_loginusername);
        mEdtloginpassword = (EditText) findViewById(R.id.edt_loginpassword);
        mBtlogin = (Button) findViewById(R.id.bt_login);
        mBtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = mEdtloginusername.getText().toString().trim();
                String password = mEdtloginpassword.getText().toString().trim();

                viewModel.requestLogin(username, password);
            }
        });
        mBtregister = (Button) findViewById(R.id.bt_register1);
        mBtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });

        viewModel.responselogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    startActivity(new Intent(getBaseContext(),MainActivity.class));
                    // go to main
                } else {
                    Toast.makeText(getBaseContext(),"ชื่อหรือรหัสผ่านไม่ถูกต้อง",Toast.LENGTH_SHORT).show();
                    // errr
                }
            }
        });

        viewModel.responseToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}