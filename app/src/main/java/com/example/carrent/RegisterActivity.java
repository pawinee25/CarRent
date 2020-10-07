package com.example.carrent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteUpdate;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private EditText mEdtusername;
    private EditText mEdtname;
    private EditText mEdtsurname;
    private EditText mEdtidcard;
    private EditText mEdttel;
    private EditText mEdthouse;
    private EditText mEdtprovince;
    private EditText mEdtdistrict;
    private EditText mEdtsubdistrict;
    private EditText mEdtpostalcode;
    private EditText mEdtpassword;
    private Button mBtconfirm;
    private Button mBtcancel;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        mEdtusername = (EditText) findViewById(R.id.edt_username);
        mEdtname = (EditText) findViewById(R.id.edt_name);
        mEdtsurname = (EditText) findViewById(R.id.edt_surname);
        mEdtidcard = (EditText) findViewById(R.id.edt_idcard);
        mEdttel = (EditText) findViewById(R.id.edt_tel);
        mEdthouse = (EditText) findViewById(R.id.edt_house);
        mEdtprovince = (EditText) findViewById(R.id.edt_province);
        mEdtdistrict = (EditText) findViewById(R.id.edt_district);
        mEdtsubdistrict = (EditText) findViewById(R.id.edt_subdistrict);
        mEdtpostalcode = (EditText) findViewById(R.id.edt_postalcode);
        mEdtpassword = (EditText) findViewById(R.id.edt_password);
        mBtcancel = (Button) findViewById(R.id.bt_cancel);
        mBtconfirm = (Button) findViewById(R.id.bt_confirm);

        viewModel.register().observe(this, new Observer<Objects>() {
            @Override
            public void onChanged(Objects objects) {
                mEdtusername.setText("");
                mEdtname.setText("");
                mEdtsurname.setText("");
                mEdtidcard.setText("");
                mEdttel.setText("");
                mEdthouse.setText("");
                mEdtprovince.setText("");
                mEdtdistrict.setText("");
                mEdtsubdistrict.setText("");
                mEdtpostalcode.setText("");
                mEdtpassword.setText("");

                Toast.makeText(getBaseContext(), "สำเร็จ", Toast.LENGTH_SHORT).show();
            }
        });

        mBtconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String UserName = mEdtusername.getText().toString().trim();
                String Name = mEdtname.getText().toString().trim();
                String SurName = mEdtsurname.getText().toString().trim();
                String IDCardNumber = mEdtidcard.getText().toString().trim();
                String Tel = mEdttel.getText().toString().trim();
                String HouseNumber = mEdthouse.getText().toString().trim();
                String Province = mEdtprovince.getText().toString().trim();
                String District = mEdtdistrict.getText().toString().trim();
                String SubDistrict = mEdtsubdistrict.getText().toString().trim();
                String Postalcode = mEdtpostalcode.getText().toString().trim();
                String Password = mEdtpassword.getText().toString().trim();

                viewModel.register(UserName, Name, SurName, IDCardNumber, Tel, HouseNumber, Province, District, SubDistrict, Postalcode, Password);


            }
        });
    }
}