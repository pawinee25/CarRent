package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteUpdate;

import java.util.Objects;

public class Repository {

    private MutableLiveData<Objects> _register = new MutableLiveData<>();

    LiveData<Objects> register(){
        return _register;
    }

    void register(String username, String name, String surname, String idcardnumber, String tel, String housenumber, String province, String district, String subdisrict, String postalcode, String password) {
        String sql = "INSERT INTO `user`(`UserName`, `Name`, `SurName`, `IDCardNumber`, `Tel`, `HouseNumber`, `Province`, `District`, `SubDistrct`, `Postalcode`, `Password`) " +
                "VALUES ('" + username + "','" + name + "','" + surname + "','" + idcardnumber + "','" + tel + "','" + housenumber + "','" + province + "','" + district + "','" + subdisrict + "','" + postalcode + "','" + password + "')";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteUpdate() {
                    @Override
                    public void onComplete() {
                        _register.setValue(null);
                    }
                });


    }
}
