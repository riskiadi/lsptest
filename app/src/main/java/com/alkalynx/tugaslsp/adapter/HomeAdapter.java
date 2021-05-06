package com.alkalynx.tugaslsp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alkalynx.tugaslsp.R;
import com.alkalynx.tugaslsp.model.MenuModel;

import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<MenuModel> items;

    public HomeAdapter(Activity activity, List<MenuModel> items) {
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
        if(inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = inflater.inflate(R.layout.item_row_menu, null);

        TextView id = view.findViewById(R.id.foodId);
        ImageView image = view.findViewById(R.id.foodImage);
        TextView name = view.findViewById(R.id.foodName);
        TextView price =  view.findViewById(R.id.foodPrice);

        MenuModel data = items.get(position);
        id.setText(data.getId());
        Context context = image.getContext();
        int imgId = context.getResources().getIdentifier(data.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imgId);
        name.setText(data.getFoodName());
        price.setText("Rp. " + data.getFoodPrice());

        return view;
    }
}
