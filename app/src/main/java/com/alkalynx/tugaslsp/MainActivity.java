package com.alkalynx.tugaslsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alkalynx.tugaslsp.adapter.HomeAdapter;
import com.alkalynx.tugaslsp.model.MenuModel;
import com.alkalynx.tugaslsp.utils.InitiateData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<MenuModel> itemList = new ArrayList<MenuModel>();
    HomeAdapter adapter;

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_PRICE = "price";
    public static final String TAG_IMAGE = "image";
    public static final String TAG_CUSTOMER_NAME = "customer_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.menu_list_view);
        adapter = new HomeAdapter(MainActivity.this, itemList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getId();
                final String name = itemList.get(position).getFoodName();
                final String price = itemList.get(position).getFoodPrice();
                final String image = itemList.get(position).getImage();
                final String customerName = "Rizki adi saputra";
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(TAG_ID, idx);
                intent.putExtra(TAG_NAME, name);
                intent.putExtra(TAG_PRICE, price);
                intent.putExtra(TAG_IMAGE, image);

                intent.putExtra(TAG_CUSTOMER_NAME, customerName);
                startActivity(intent);
            }
        });

        getAllData();

    }

    private void getAllData() {
        InitiateData initiateData = new InitiateData();
        itemList.addAll(initiateData.generate());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }
}