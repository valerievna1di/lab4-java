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
    
    public void addNewClothes(Clothes cl, int quantity) {

        for (int i = 0; i < clothesList.size(); i++) {

            if (clothesList.get(i).equals(cl)) {
                quantities.set(i, quantities.get(i) + quantity);
                return;
            }
        }

        clothesList.add(cl);
        quantities.add(quantity);
    }    
}