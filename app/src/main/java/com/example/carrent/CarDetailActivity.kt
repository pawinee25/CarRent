package com.example.carrent

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_car_detail.*

class CarDetailActivity : BaseActivity() {

    private lateinit var viewModel: CarDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        val carId = intent.getIntExtra("carid", 0)

        viewModel = ViewModelProvider(this).get(CarDetailViewModel::class.java)

        viewModel.responseProductDetail().observe {
            iv_image.setImageCircle(it.images)
            tv_brandname.text = it.brandname
            tv_modelname.text = it.modelname
            tv_register.text = it.register
            tv_engine.text = it.engine
            tv_color.text = it.color
            tv_type.text = it.type
            tv_gear.text = it.gear
            tv_door.text = it.door
            tv_numberseats.text = it.numberseats
            tv_price.text = it.price.toString()
            toast(it.toString())

        }

        viewModel.requestCarDetail(carId)

    }
}
