package com.example;

public class Clothes {

    private String name;
    private ClothesType type;
    private double price;
    private String size;
    private static int count = 0;

    public Clothes(String name, String type, double price, String size) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        if (size == null || size.isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty");
        }

        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
        
        count++;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name + " | " + type + " | " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clothes)) return false;

        Clothes c = (Clothes) obj;

        return name.equals(c.name)
                && type.equals(c.type)
                && price == c.price;
    }
}