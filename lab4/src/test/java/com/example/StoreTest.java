package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    @Test
    void shouldAddObject() {

        Store store = new Store();

        Pants pants = new Pants("Nike", ClothesType.SUMMER, 100, "M", "cotton");

        store.addNewClothes(pants, 1);

        assertTrue(store.getAll().contains(pants));
    }

    @Test
    void shouldDeleteObject() {

        Store store = new Store();

        Pants pants = new Pants("Nike", ClothesType.SUMMER, 100, "M", "cotton");

        store.addNewClothes(pants, 1);

        boolean result = store.delete(pants);

        assertTrue(result);
    }

    @Test
    void shouldThrowInvalidFieldValueException() {

        assertThrows(
                InvalidFieldValueException.class,

                () -> {
                    new Pants( "", ClothesType.SUMMER, 100, "M", "cotton");
                }
        );
    }
}