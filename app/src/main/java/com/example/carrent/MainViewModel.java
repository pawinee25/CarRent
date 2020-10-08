package com.example.carrent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.carrent.Models.Product;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private Repository repository = new Repository();

    LiveData<ArrayList<Product>> responseProduct() {
        return repository.responseProduct();
    }

    void requsetProduct() {
        repository.requestProduct();
    }
}
