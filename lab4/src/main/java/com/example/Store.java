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

    public void searchByName(String name) {

        boolean found = false;

        for (Clothes c : clothesList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c + " | qty: " + getQuantity(c));
                found = true;
            }
        }

        if (!found) System.out.println("Nothing found");
    }

    public void searchByType(ClothesType type) {

        boolean found = false;

        for (Clothes c : clothesList) {
            if (c.getType() == type) {
                System.out.println(c + " | qty: " + getQuantity(c));
                found = true;
            }
        }

        if (!found) System.out.println("Nothing found");
    }

    public void searchByPrice(double min, double max) {

        boolean found = false;

        for (Clothes c : clothesList) {
            if (c.getPrice() >= min && c.getPrice() <= max) {
                System.out.println(c + " | qty: " + getQuantity(c));
                found = true;
            }
        }

        if (!found) System.out.println("Nothing found");
    }
}    