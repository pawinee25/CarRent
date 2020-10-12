package com.example.carrent

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class CarDetailActivity : BaseActivity() {

    private lateinit var viewModel: CarDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        val carId = intent.getIntExtra("carid",0)

        viewModel = ViewModelProvider(this).get(CarDetailViewModel::class.java)

        viewModel.responseProductDetail().observe {
            toast(it.carid.toString())

        }

        viewModel.requestCarDetail(carId)

    }
}
