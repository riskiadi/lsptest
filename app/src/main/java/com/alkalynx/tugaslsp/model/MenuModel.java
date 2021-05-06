package com.alkalynx.tugaslsp.model;

import android.graphics.drawable.Drawable;

public class MenuModel {

    String  id, foodName, foodPrice, image;

    public MenuModel() {
    }

    public MenuModel(String foodName, String foodPrice, String image, String id) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.image = image;
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
