package com.example;

public class Clothes {

    private String name;
    private String type;
    private double price;
    private String size;

    public Clothes(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

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