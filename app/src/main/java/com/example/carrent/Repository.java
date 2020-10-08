package com.example.carrent;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.adedom.library.ExecuteUpdate;
import com.example.carrent.Models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Repository {
    private static final String TAG = "Repository";

    private MutableLiveData<Objects> _responseregister = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsecheckusername = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsecheckidcardnumber = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responsetel = new MutableLiveData<>();
    private MutableLiveData<Boolean> _responselogin = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Product>> _responseProduct = new MutableLiveData<>();
    private MutableLiveData<Product> _responseProductDetail = new MutableLiveData<>();

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

    LiveData<Boolean> responselogin() {
        return _responselogin;
    }

    LiveData<ArrayList<Product>> responseProduct() {
        return _responseProduct;
    }

    LiveData<Product> responseProductDetail() {
        return _responseProductDetail;
    }

    void requestLogin(String username, String password) {
        String sql = "SELECT * FROM `user` WHERE UserName = '" + username + "' AND Password = '" + password + "'";
        Log.d(TAG, "requestLogin: " + sql);
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()) {
                                _responselogin.setValue(true);
                            } else {
                                _responselogin.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }


    void requestCheckUsername(String username) {
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

    void requestProduct() {
        String sql = "SELECT car.Car_ID, car.Engine, car.Type, car.Gear, car.Door, car.Price, car.Color, car.Images, car.NumberSeats, car.Register, brand.BrandName, model.ModelName " +
                "FROM car INNER  JOIN brand ON car.Brand_ID = brand.Brand_ID INNER JOIN model ON model.Brand_ID = brand.Brand_ID";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            ArrayList<Product> items = new ArrayList<Product>();
                            while (resultSet.next()) {
                                Product product = new Product(
                                        resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getDouble(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9),
                                        resultSet.getString(10),
                                        resultSet.getString(11),
                                        resultSet.getString(12)
                                );
                                items.add(product);
                            }

                            _responseProduct.setValue(items);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    void requestCarDetail(int carid) {
        String sql = "SELECT car.Car_ID, car.Engine, car.Type, car.Gear, car.Door, car.Price, car.Color, car.Images, car.NumberSeats, car.Register, brand.BrandName, model.ModelName " +
                "FROM car INNER JOIN brand ON car.Brand_ID = brand.Brand_ID INNER JOIN model ON model.Brand_ID = brand.Brand_ID WHERE Car_ID = '" + carid + "'";

        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            Product product = null;
                            if (resultSet.next()) {
                                product = new Product(
                                        resultSet.getInt(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getDouble(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9),
                                        resultSet.getString(10),
                                        resultSet.getString(11),
                                        resultSet.getString(12)
                                );
                            }
                            _responseProductDetail.setValue(product);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
