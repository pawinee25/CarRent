package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adedom.library.Dru;

import java.util.Objects;

public class LoginViewModel extends ViewModel {

    private Repository repository = new Repository();
    private MutableLiveData<String> _responseToast = new MutableLiveData<>();

    LiveData<Boolean> responselogin() {
        return repository.responselogin();
    }
    LiveData<String> responseToast() {
        return _responseToast;

    }

    void requestLogin(String username, String password) {
        if (username.isEmpty()){
            _responseToast.setValue("ห้ามว่าง1");
            return;
        } else if (password.isEmpty()){
            _responseToast.setValue("ห้ามว่าง2");
            return;
        }
        repository.requestLogin(username, password);
    }
}
