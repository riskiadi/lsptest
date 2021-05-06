package com.alkalynx.tugaslsp.model;

public class CustomerModel {
    String  id, name;
    MenuModel menuModel;
    double lat, lng;

    public CustomerModel() {
    }

    public CustomerModel(String id, String name, MenuModel menuModel, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.menuModel = menuModel;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
