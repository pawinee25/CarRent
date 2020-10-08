package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carrent.Models.Product;

public class CarDetailViewModel extends ViewModel {

    private Repository repository = new Repository();

    LiveData<Product> responseProductDetail() {
        return repository.responseProductDetail();
    }

    void requestCarDetail(int carid) {
        repository.requestCarDetail(carid);
    }
}
