package com.alkalynx.tugaslsp.utils;

import com.alkalynx.tugaslsp.model.MenuModel;

import java.util.ArrayList;

public class InitiateData {
    public ArrayList<MenuModel> generate(){
        ArrayList<MenuModel> initMenu = new ArrayList<MenuModel>();
        initMenu.add(new MenuModel("Begel", "24000","begel","1"));
        initMenu.add(new MenuModel("Brioche", "39000","brioche","2"));
        initMenu.add(new MenuModel("Challah", "10000","challah","3"));
        initMenu.add(new MenuModel("Ciabatta", "14000","ciabatta","4"));
        initMenu.add(new MenuModel("Cupcake", "99000","cupcake","5"));
        return initMenu;
    }
}
