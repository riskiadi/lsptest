package com.alkalynx.tugaslsp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alkalynx.tugaslsp.MapsActivity;
import com.alkalynx.tugaslsp.R;
import com.alkalynx.tugaslsp.model.CustomerModel;
import com.alkalynx.tugaslsp.model.MenuModel;
import com.alkalynx.tugaslsp.utils.InitiateData;

import java.util.ArrayList;
import java.util.List;

import static com.alkalynx.tugaslsp.MapsActivity.TAG_LAT;
import static com.alkalynx.tugaslsp.MapsActivity.TAG_LNG;

public class CustomerAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<CustomerModel> items;

    public CustomerAdapter(Activity activity, List<CustomerModel> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.item_row_customer, null);

        TextView customerOrder = view.findViewById(R.id.customerOrder);
        TextView customerName = view.findViewById(R.id.customerName);
        ImageView foodImage = view.findViewById(R.id.foodImage);

        CustomerModel data = items.get(position);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), MapsActivity.class);
                intent.putExtra(TAG_LAT, data.getLat());
                intent.putExtra(TAG_LNG, data.getLng());
                activity.startActivity(intent);
            }
        });
        customerOrder.setText(data.getMenuModel().getFoodName());
        customerName.setText(data.getName());

        Context context = foodImage.getContext();
        int imgId = context.getResources().getIdentifier(data.getMenuModel().getImage(), "drawable", context.getPackageName());
        foodImage.setImageResource(imgId);

        return view;
    }

}
