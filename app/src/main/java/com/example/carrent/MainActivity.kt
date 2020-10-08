package com.example.carrent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adedom.library.Dru
import com.example.carrent.Models.Product
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainViewModel
    private val items: ArrayList<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        
        if (ConnectDB.getConnection() == null) {
            Dru.failed(baseContext)
        } else {
            Dru.completed(baseContext)
        }

        bt_in.setOnClickListener { startActivity(Intent(baseContext, InproductActivity::class.java)) }
        
        viewModel.responseProduct().observe { 
            it.forEach {
                Log.d(TAG, "onCreate: ${it.brandname}")
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.requsetProduct();
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}