package com.example;

import java.util.UUID;
import com.example.exceptions.InvalidFieldValueException;

public abstract class Clothes implements Comparable<Clothes>, Identifiable {

    protected String name;
    protected ClothesType type;
    protected double price;
    protected String size;
    private UUID uuid;

    public Clothes(String name, ClothesType type, double price, String size) {
        if (name == null || name.isEmpty()) {
            throw new InvalidFieldValueException("Name cannot be empty");
        }

        if (price <= 0) {
            throw new InvalidFieldValueException("Price must be positive");
        }

        if (size == null || size.isEmpty()) {
            throw new InvalidFieldValueException("Size cannot be empty");
        }

        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
        this.uuid = UUID.randomUUID();

    }
    
    public Clothes(Clothes other) {
        this.name = other.name;
        this.type = other.type;
        this.price = other.price;
        this.size = other.size;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ClothesType getType() { return type; }
    public void setType(ClothesType type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price! Price must be positive");
        }
        this.price = price;
    }
    
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    
    public UUID getUuid() { return uuid; } 
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    } 

    @Override
    public String toString() {
        return name + " | " + type + " | " + price + " | " + size + " | UUID= " + uuid;
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
    
    @Override
    public int compareTo(Clothes other) {
        return this.name.compareToIgnoreCase(other.name);
    }  
}