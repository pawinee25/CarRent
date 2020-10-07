package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class RegisterViewModel extends ViewModel {

    private Repository repository = new Repository();

    LiveData<Objects> register(){
        return repository.register();
    }

    void register(String username, String name, String surname, String idcardnumber, String tel, String housenumber, String province, String district, String subdisrict, String postalcode, String password) {
        repository.register(username, name, surname, idcardnumber, tel, housenumber, province, district, subdisrict, postalcode, password);
    }
}
