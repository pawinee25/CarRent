package com.example.carrent

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.library.Dru
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainViewModel

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

        val adt= CarAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        adt.onClick = {
//            toast(it.carid.toString())
            startActivity(Intent(baseContext, CarDetailActivity::class.java))
        }

        viewModel.responseProduct().observe {
            adt.setList(it)
        }
    }

//    override fun onResume() {
//        super.onRestart()
//        viewModel.requsetProduct();
//    }

    override fun onResume() {
        super.onResume()
        viewModel.requsetProduct();
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}