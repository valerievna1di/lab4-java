package com.example;

import java.util.ArrayList;

public class Store {

    private ArrayList<Clothes> clothesList = new ArrayList<>();

    private ArrayList<Integer> quantities = new ArrayList<>();
    
    public ArrayList<Clothes> getAll() {
        return clothesList;
    }

    public int getQuantity(Clothes c) {
        return quantities.get(clothesList.indexOf(c));
    }
}