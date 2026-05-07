package com.example;

public class Shirts extends Clothes {

    private boolean longSleeve;

    public Shirts(String name, ClothesType type, double price, String size, boolean longSleeve) {
        super(name, type, price, size);
        this.longSleeve = longSleeve;
    }

    public boolean isLongSleeve() {
        return longSleeve;
    }

    @Override
    public String toString() {
        return "SHIRT: " + super.toString() + " | longSleeve=" + longSleeve;
    }
}