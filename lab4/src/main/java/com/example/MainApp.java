package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Store store = new Store();
    
    private TextField nameField = new TextField();
    private ComboBox<String> typeBox = new ComboBox<>();
    private ComboBox<String> categoryBox = new ComboBox<>();

    private TextField priceField = new TextField();
    private TextField sizeField = new TextField();

    private TextField materialField = new TextField();
    private TextField longSleeveField = new TextField();
    private TextField hoodField = new TextField();
    private TextField soleTypeField = new TextField();

    private TextField uuidField = new TextField();

    @Override
    public void start(Stage stage) {
        categoryBox.getItems().addAll("PANTS", "SHIRTS", "JACKET", "SHOES");
        typeBox.getItems().addAll("SUMMER", "WINTER", "AUTUMN", "SPRING");

        Button addBtn = new Button("Add");
        Button searchBtn = new Button("Search UUID");

        TextArea output = new TextArea();

        // ДОДАТИ ОБ'ЄКТ
        addBtn.setOnAction(e -> {

            if (nameField.getText().isEmpty()
                    || priceField.getText().isEmpty()
                    || sizeField.getText().isEmpty()
                    || categoryBox.getValue() == null
                    || typeBox.getValue() == null) {

                output.appendText("Fill all required fields!\n");
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceField.getText());
                if (price <= 0) {
                    output.appendText("Price must be > 0\n");
                    return;
                }
            } catch (NumberFormatException ex) {
                output.appendText("Invalid price format!\n");
                return;
            }

            String name = nameField.getText();
            String size = sizeField.getText();

            ClothesType type = ClothesType.valueOf(typeBox.getValue());

            Clothes c;

            switch (categoryBox.getValue()) {

                case "PANTS" -> {
                    c = new Pants(name, type, price, size, materialField.getText());
                }

                case "SHIRTS" -> {
                    boolean longSleeve = Boolean.parseBoolean(longSleeveField.getText());
                    c = new Shirts(name, type, price, size, longSleeve);
                }

                case "JACKET" -> {
                    boolean hood = Boolean.parseBoolean(hoodField.getText());
                    c = new Jacket(name, type, price, size, hood);
                }

                case "SHOES" -> {
                    c = new Shoes(name, type, price, size, soleTypeField.getText());
                }

                default -> {
                    output.appendText("Unknown category!\n");
                    return;
                }
            }

            store.addNewClothes(c, 1);
            output.appendText("Added: " + c + "\n");
        });

        // ПОШУК
        searchBtn.setOnAction(e -> {
            Clothes result = store.searchByUuid(uuidField.getText());

            if (result != null) {
                output.appendText("Found: " + result + "\n");
            } else {
                output.appendText("Not found\n");
            }
        });

        VBox root = new VBox(
                new Label("Name"), nameField,

                new Label("Category (PANTS/SHIRTS/JACKET/SHOES)"), categoryBox,
                new Label("Season (ClothesType)"), typeBox,

                new Label("Price"), priceField,
                new Label("Size"), sizeField,

                new Label("Material (PANTS)"), materialField,
                new Label("Long Sleeve (SHIRTS true/false)"), longSleeveField,
                new Label("Hood (JACKET true/false)"), hoodField,
                new Label("Sole Type (SHOES)"), soleTypeField,

                addBtn,

                new Label("UUID Search"),
                uuidField,
                searchBtn,

                output
        );

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Clothes Store");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}