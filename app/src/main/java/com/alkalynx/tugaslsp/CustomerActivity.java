package com.alkalynx.tugaslsp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.alkalynx.tugaslsp.adapter.CustomerAdapter;
import com.alkalynx.tugaslsp.helper.DbHelper;
import com.alkalynx.tugaslsp.model.CustomerModel;
import com.alkalynx.tugaslsp.model.MenuModel;
import com.alkalynx.tugaslsp.utils.InitiateData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {

    ListView listView;
    List<CustomerModel> itemList = new ArrayList<CustomerModel>();
    CustomerAdapter adapter;
    DbHelper SQLite = new DbHelper(this);
    ArrayList<MenuModel> menuDum = new ArrayList<>();

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_MENU = "menu";
    public static final String TAG_LAT = "lat";
    public static final String TAG_LNG = "lng";

    public static final String TAG_FOOD_NAME = "food_name";
    public static final String TAG_FOOD_PRICE = "food_price";
    public static final String TAG_FOOD_IMAGE = "food_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        menuDum.addAll(new InitiateData().generate());

        listView = findViewById(R.id.customer_list_view);
        SQLite = new DbHelper(getApplicationContext());

        adapter = new CustomerAdapter(CustomerActivity.this, itemList);
        listView.setAdapter(adapter);

        getAllData();

    }

    private void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i<row.size();i++){

            String id = row.get(i).get(TAG_ID);
            String name = row.get(i).get(TAG_NAME);
            int menu = Integer.parseInt(row.get(i).get(TAG_MENU));
            double lat = Double.parseDouble(row.get(i).get(TAG_LAT));
            double lng = Double.parseDouble(row.get(i).get(TAG_LNG));

            CustomerModel customer = new CustomerModel();

            customer.setId(id);
            customer.setName(name);

            Log.d("array", String.valueOf(menu) );

            customer.setMenuModel(new MenuModel(menuDum.get(menu-1).getFoodName(), menuDum.get(menu-1).getFoodPrice(), menuDum.get(menu-1).getImage(), menuDum.get(menu-1).getId()));
            customer.setLat(lat);
            customer.setLng(lng);

            Log.d("posisi", "latitdue:" + lat + "long:" + lng);


            itemList.add(customer);
        }
        adapter.notifyDataSetChanged();
    }

}