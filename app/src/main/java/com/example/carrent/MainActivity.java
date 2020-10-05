package com.example.carrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adedom.library.Adapter;
import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.example.carrent.Models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button mBtIn;
    private ArrayList<Product> items;
    private RecyclerView mRecyclerViem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ConnectDB.getConnection() == null) {
            Dru.failed(getBaseContext());
        } else {
            Dru.completed(getBaseContext());
        }
        mBtIn = (Button) findViewById(R.id.bt_in);
        mRecyclerViem = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerViem.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));


        mBtIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), InproductActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        frtchProduct();
    }

    private void frtchProduct() {
        String sql = "SELECT c.* , b.Name FROM car c INNER JOIN brand b ON c.Brand_ID = b.Brand_ID";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            items = new ArrayList<Product>();
                            while (resultSet.next()) {
                                Product product = new Product(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getDouble(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getInt(6),
                                        resultSet.getString(7),
                                        resultSet.getString(8),
                                        resultSet.getString(9)
                                );
                                items.add(product);

                            }

                            mRecyclerViem.setAdapter(new ProductAdapter());

//                                   Log.d(TAG, "OnComplete: "+ items);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {
        @NonNull
        @Override
        public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_product, parent, false);
            return new ProductHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
            Product product = items.get(position);
            holder.tvName.setText(product.getName());
            holder.tvPrice.setText(product.getPrice() + " ");
            holder.tvEngine.setText(product.getEngine() + " ");
            Dru.loadImageCircle(holder.ivImage, "https://www.android.com/static/2016/img/share/andy-sm.png");
            Log.d(TAG, "onBindViewHolder: " + "[" + ConnectDB.BASE_IMAGE + product.getImages() + "]");
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class ProductHolder extends RecyclerView.ViewHolder {
        private final ImageView ivImage;
        private final TextView tvName;
        private final TextView tvPrice;
        private final TextView tvEngine;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvEngine = (TextView) itemView.findViewById(R.id.tv_engine);

        }
    }
}