package com.example.carrent

import android.view.View
import com.example.carrent.Models.Product
import kotlinx.android.synthetic.main.item_list_product.view.*

class CarAdapter : BaseRecyclerView<Product>() {
    override fun getLayout(): Int =R.layout.item_list_product

    override fun View.onBindViewHolder(data: Product) {
        tv_price.text = data.price.toString()
        tv_brandname.text = data.brandname
        tv_color.text = data.color
        tv_engine.text = data.engine
        iv_image.setImageCircle(data.images)
    }
}