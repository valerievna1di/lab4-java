package com.example;

import java.util.List;

public class Wardrobe {

    private List<Clothes> clothesList;

    public Wardrobe(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }

    public void showAll() {
        System.out.println("=== Wardrobe ===");

        for (Clothes c : clothesList) {
            System.out.println(c);
        }
    }
}