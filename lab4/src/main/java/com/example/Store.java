package com.example;

import java.util.ArrayList;
import java.util.UUID;
import com.example.InvalidFieldValueException;
import com.example.ObjectNotFoundException;

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
    
    public Clothes searchByUuid(String uuidStr) {

        try {
            UUID uuid = UUID.fromString(uuidStr);

            for (Clothes c : clothesList) {
                if (c.getUuid().equals(uuid)) {
                    return c;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid UUID format!");
        }

        return null;
    }
    
    public boolean update(Clothes existing, Clothes updated) {

        for (int i = 0; i < clothesList.size(); i++) {

            if (clothesList.get(i).getUuid().equals(existing.getUuid())) {

                updated.setUuid(clothesList.get(i).getUuid());

                clothesList.set(i, updated);
                return true;
            }
        }

        throw new ObjectNotFoundException("Object not found for update!");
    }

    public boolean delete(Clothes existing) {

        return clothesList.removeIf(
            c -> c.getUuid().equals(existing.getUuid())
        );
    }
}