package com.example;

public class Pants extends Clothes {

    private String material;

    public Pants(String name, ClothesType type, double price, String size, String material) {
        super(name, type, price, size);
        this.material = material;
    }

    @Override
    public String toString() {
        return "PANTS: " + super.toString() + " | " + material;
    }
}