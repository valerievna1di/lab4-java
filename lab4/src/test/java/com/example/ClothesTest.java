package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Clothes;

class ClothesTest {

    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("", "summer", -10, "M");
        });
    }

    @Test
    void testInvalidSetter() {
        Clothes c = new Clothes("shirt", "summer", 100, "M");

        assertThrows(IllegalArgumentException.class, () -> {
            c.setPrice(-5);
        });
    }
}