package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.adedom.library.ExecuteUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Repository {

    private MutableLiveData<Objects> _responseregister = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsecheckusername = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsecheckidcardnumber = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsetel = new MutableLiveData<>();


    LiveData<Objects> responseregister() {
        return _responseregister;
    }

    LiveData<Boolean> responsecheckusername() {
        return _responsecheckusername;
    }

    LiveData<Boolean> responsecheckidcardnumber() {
        return _responsecheckidcardnumber;
    }

    LiveData<Boolean> responsetel() {
        return _responsetel;
    }


    void reuestCheckUsername(String username) {
        String sql = "SELECT * FROM `user` WHERE UserName = '" + username + "'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()) {
                                _responsecheckusername.setValue(true);
                            } else {
                                _responsecheckusername.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    void requestcheckidcardnumber(String idcardnumber) {
        String sql = "SELECT * FROM `user` WHERE IDCardNumber = '" + idcardnumber + "'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()) {
                                _responsecheckidcardnumber.setValue(true);
                            } else {
                                _responsecheckidcardnumber.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    void requesttel(String tel) {
        String sql = "SELECT * FROM `user` WHERE Tel = '" + tel + "'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()) {
                                _responsetel.setValue(true);
                            } else {
                                _responsetel.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    void requesrregister(String username, String name, String surname, String idcardnumber, String tel, String housenumber, String province, String district, String subdisrict, String postalcode, String password) {
        String sql = "INSERT INTO `user`(`UserName`, `Name`, `SurName`, `IDCardNumber`, `Tel`, `HouseNumber`, `Province`, `District`, `SubDistrct`, `Postalcode`, `Password`) " +
                "VALUES ('" + username + "','" + name + "','" + surname + "','" + idcardnumber + "','" + tel + "','" + housenumber + "','" + province + "','" + district + "','" + subdisrict + "','" + postalcode + "','" + password + "')";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteUpdate() {
                    @Override
                    public void onComplete() {
                        _responseregister.setValue(null);
                    }
                });
    }
}
