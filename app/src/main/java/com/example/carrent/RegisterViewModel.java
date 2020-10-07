package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class RegisterViewModel extends ViewModel {

    private Repository repository = new Repository();

    private MutableLiveData<String> _responseToast = new MutableLiveData<>();

    LiveData<String> responseToast() {
        return _responseToast;

    }

    LiveData<Objects> responseregister() {
        return repository.responseregister();

    }

    LiveData<Boolean> responsecheckusername() {
        return repository.responsecheckusername();
    }

    LiveData<Boolean> responsecheckidcardnumber() {
        return repository.responsecheckidcardnumber();
    }

    LiveData<Boolean> responsetel() {
        return repository.responsetel();
    }

    void requesttel(String Tel) {
        repository.requesttel(Tel);
    }

    void requestcheckidcardnumber(String idcardnumber) {
        repository.requestcheckidcardnumber(idcardnumber);
    }

    void requestCheckUsername(String username) {
        repository.reuestCheckUsername(username);
    }

    void requestregister(String username, String name, String surname, String idcardnumber, String tel, String housenumber, String province, String district, String subdisrict, String postalcode, String password,String repassword) {

        if (username.isEmpty()) {
            _responseToast.setValue("username error");
            return;
        } else if (idcardnumber.isEmpty()) {
            _responseToast.setValue("ใส่เลข 13 หลัก");
            return;
        } else if (tel.isEmpty()){
            _responseToast.setValue("ใส่เลข 10 หลัก");
            return;
        } else if (idcardnumber.length() != 13){
            _responseToast.setValue("ใส่เลข 13 หลัก");
            return;
        } else if (tel.length() != 10){
            _responseToast.setValue("ใส่เบอร์โทร 10 หลัก");
            return;
        } else if (!password.equals(repassword)){
            _responseToast.setValue("รหัสผ่านไม่ตรงกัน");
            return;
        }

        repository.requesrregister(username, name, surname, idcardnumber, tel, housenumber, province, district, subdisrict, postalcode, password);
    }
}
