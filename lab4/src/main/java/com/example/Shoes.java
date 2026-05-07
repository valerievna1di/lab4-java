package com.example;

public class Shoes extends Clothes {

    private String soleType;

    public Shoes(String name, ClothesType type, double price, String size, String soleType) {
        super(name, type, price, size);
        this.soleType = soleType;
    }

    public String getSoleType() {
        return soleType;
    }

    @Override
    public String toString() {
        return "SHOES: " + super.toString() + " | soleType=" + soleType;
    }
}