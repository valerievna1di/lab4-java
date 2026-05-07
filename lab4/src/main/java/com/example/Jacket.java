package com.example;

public class Jacket extends Clothes {

    private boolean hood;

    public Jacket(String name, ClothesType type,
                  double price, String size,
                  boolean hood) {

        super(name, type, price, size);

        this.hood = hood;
    }

    @Override
    public String toString() {
        return "JACKET: "
                + super.toString()
                + " | hood=" + hood;
    }
}