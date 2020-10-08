package com.example.carrent

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        viewModel.responseregister().observe {
            edt_username.setText("")
            edt_name.setText("")
            edt_surname.setText("")
            edt_idcard.setText("")
            edt_tel.setText("")
            edt_house.setText("")
            edt_province.setText("")
            edt_district.setText("")
            edt_subdistrict.setText("")
            edt_postalcode.setText("")
            edt_password.setText("")
            edt_repassword.setText("")
            toast("สำเร็จ")
        }
        viewModel.responsecheckusername().observe {
            val iDCardNumber = edt_idcard.getContents()
            if (it) {
                toast("ชื่อซ้ำ")
            } else {
                viewModel.requestcheckidcardnumber(iDCardNumber)
            }
        }
        viewModel.responsetel().observe {
            val tel = edt_tel.getContents()
            if (it) {
                toast("เบอร์ซ้ำ")
            } else {
                viewModel.requesttel(tel)
            }
        }
        viewModel.responsecheckidcardnumber().observe {
            val userName = edt_username.getContents()
            val name = edt_name.getContents()
            val surName = edt_surname.getContents()
            val iDCardNumber = edt_idcard.getContents()
            val tel = edt_tel.getContents()
            val houseNumber = edt_house.getContents()
            val province = edt_province.getContents()
            val district = edt_district.getContents()
            val subDistrict = edt_subdistrict.getContents()
            val postalcode = edt_postalcode.getContents()
            val password = edt_password.getContents()
            val repassword = edt_repassword.getContents()
            if (it) {
                toast("IDCardNumber repeat")
            } else {
                viewModel.requestregister(userName, name, surName, iDCardNumber, tel, houseNumber, province, district, subDistrict, postalcode, password, repassword)
            }
        }

        bt_confirm.setOnClickListener {
            val userName = edt_username.getContents()
            viewModel.requestCheckUsername(userName)
        }

        viewModel.responseToast().observe {
            toast(it)
        }
    }

}