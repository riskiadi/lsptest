package com.alkalynx.tugaslsp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alkalynx.tugaslsp.helper.DbHelper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class OrderActivity extends AppCompatActivity {

    DbHelper SQLite = new DbHelper(this);

    String id, foodName, foodPrice, image, customerName;

    ImageView menuImage;
    TextView foodNameTxt, foodPriceTxt;
    Button orderBtn;

    String lat, lng;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // GET CURRENT LOCATION
        FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    lat = Double.toString(location.getLatitude());
                    lng = Double.toString(location.getLongitude());
                }
            }
        });

        getSupportActionBar().setTitle("Order Food");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        menuImage = findViewById(R.id.menuImage);
        foodNameTxt = findViewById(R.id.foodNameTxt);
        foodPriceTxt = findViewById(R.id.foodPriceTxt);
        orderBtn = findViewById(R.id.orderBtn);

        id = getIntent().getStringExtra(MainActivity.TAG_ID);
        foodName = getIntent().getStringExtra(MainActivity.TAG_NAME);
        foodPrice = getIntent().getStringExtra(MainActivity.TAG_PRICE);
        image = getIntent().getStringExtra(MainActivity.TAG_IMAGE);

        customerName = getIntent().getStringExtra(MainActivity.TAG_CUSTOMER_NAME);

        Context context = menuImage.getContext();
        int imgId = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
        menuImage.setImageResource(imgId);
        foodNameTxt.setText(foodName);
        foodPriceTxt.setText("Rp. " + foodPrice);

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLite.insert(customerName, id, lat, lng);
                SQLite.getAllData();
            }
        });


    }


    @Override
    public void onBackPressed() {
        finish();
    }


}