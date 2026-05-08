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

    private TextField priceField = new TextField();
    private TextField sizeField = new TextField();

    private TextField materialField = new TextField();
    private TextField longSleeveField = new TextField();
    private TextField hoodField = new TextField();
    private TextField soleTypeField = new TextField();

    private TextField uuidField = new TextField();

    @Override
    public void start(Stage stage) {
        typeBox.getItems().addAll("PANTS", "SHIRTS", "JACKET", "SHOES");

        Button addBtn = new Button("Add");
        Button searchBtn = new Button("Search UUID");

        TextArea output = new TextArea();

        // ДОДАТИ ОБ'ЄКТ
        addBtn.setOnAction(e -> {

            String name = nameField.getText();
            String type = typeBox.getValue();
            String size = sizeField.getText();
            double price = 0;
            try {
                price = Double.parseDouble(priceField.getText());
            } catch (Exception ex) {
                output.appendText("Invalid price!\n");
                return;
            }            

            Clothes c;

            switch (type) {

                case "PANTS":
                    String material = materialField.getText();
                    c = new Pants(name, ClothesType.valueOf(type), price, size, material);
                    break;

                case "SHIRTS":
                    boolean longSleeve = Boolean.parseBoolean(longSleeveField.getText());
                    c = new Shirts(name, ClothesType.valueOf(type), price, size, longSleeve);
                    break;

                case "JACKET":
                    boolean hood = Boolean.parseBoolean(hoodField.getText());
                    c = new Jacket(name, ClothesType.valueOf(type), price, size, hood);
                    break;

                case "SHOES":
                    String soleType = soleTypeField.getText();
                    c = new Shoes(name, ClothesType.valueOf(type), price, size, soleType);
                    break;

                default:
                    output.appendText("Unknown type!\n");
                    return;
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
                new Label("Type"), typeBox,
                new Label("Price"), priceField,
                new Label("Size"), sizeField,

                new Label("Material (PANTS)"), materialField,
                new Label("Long Sleeve (SHIRTS)"), longSleeveField,
                new Label("Hood (JACKET)"), hoodField,
                new Label("Sole Type (SHOES)"), soleTypeField,

                addBtn,

                new Label("UUID"),
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