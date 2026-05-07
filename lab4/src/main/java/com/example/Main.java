package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Config file not found");
            return;
        }

        DatabaseManager db = new DatabaseManager(args[0]);        

        Store store = new Store();

        ArrayList<Clothes> temp =
                FileService.loadFromFile("input.txt");

        for (Clothes c : temp) {
            store.addNewClothes(c, 1);
        }

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Create new object");
            System.out.println("2. Show all objects");
            System.out.println("3. Search objects");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;

            // перевірка введення меню
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number");
                continue;
            }

            // СТВОРЕННЯ ОБ'ЄКТУ
            if (choice == 1) {

                System.out.println("\nChoose object type:");
                System.out.println("1. Clothes");
                System.out.println("2. Pants");
                System.out.println("3. Shirts");
                System.out.println("4. Jacket");
                System.out.println("5. Shoes");
                System.out.println("0. Back");

                int objectChoice;

                try {
                    objectChoice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }

                if (objectChoice == 0) {
                    continue;
                }

                try {

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Type (SUMMER/WINTER/AUTUMN/SPRING): ");
                    ClothesType type =
                            ClothesType.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Price: ");
                    double price =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print("Size: ");
                    String size = scanner.nextLine();

                    if (objectChoice == 1) {

                        Clothes c =
                                new Clothes(name, type, price, size);

                        store.addNewClothes(c, 1);

                        db.saveClothes(c);

                        System.out.println("Clothes created!");
                    }

                    else if (objectChoice == 2) {

                        System.out.print("Material: ");
                        String material = scanner.nextLine();

                        Pants pants =
                                new Pants(name, type,
                                        price, size, material);

                        store.addNewClothes(pants, 1);

                        db.saveClothes(pants);

                        System.out.println("Pants created!");
                    }

                    else if (objectChoice == 3) {

                        System.out.print("Long sleeve (true/false): ");
                        boolean longSleeve =
                                Boolean.parseBoolean(scanner.nextLine());

                        Shirts shirt =
                                new Shirts(name, type,
                                        price, size, longSleeve);

                        store.addNewClothes(shirt, 1);

                        db.saveClothes(shirt);

                        System.out.println("Shirt created!");
                    }

                    else if (objectChoice == 4) {

                        System.out.print("Has hood (true/false): ");
                        boolean hood =
                                Boolean.parseBoolean(scanner.nextLine());

                        Jacket jacket =
                                new Jacket(name, type,
                                        price, size, hood);

                        store.addNewClothes(jacket, 1);

                        db.saveClothes(jacket);

                        System.out.println("Jacket created!");
                    }

                    else if (objectChoice == 5) {

                        System.out.print("Sole type: ");
                        String soleType = scanner.nextLine();

                        Shoes shoes =
                                new Shoes(name, type,
                                        price, size, soleType);

                        store.addNewClothes(shoes, 1);

                        db.saveClothes(shoes);

                        System.out.println("Shoes created!");
                    }

                    else {
                        System.out.println("Invalid object type!");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                catch (Exception e) {
                    System.out.println("Unexpected error!");
                }
            }

            // ПОКАЗАТИ ВСІ ОБ'ЄКТИ
            else if (choice == 2) {

                if (store.getAll().isEmpty()) {
                    System.out.println("No objects created yet");
                } else {
                    System.out.println("Objects count: " + store.getAll().size());
                    System.out.println("\n--- ALL OBJECTS ---");

                    for (Clothes c : store.getAll()) {
                        System.out.println(c + " | qty: " + store.getQuantity(c));
                    }
                }
            }

            // МЕНЮ ПОШУКУ
            else if (choice == 3) {

                System.out.println("\n--- SEARCH MENU ---");
                System.out.println("1. By name");
                System.out.println("2. By type");
                System.out.println("3. By price range");
                System.out.println("0. Back");

                int searchChoice;

                try {
                    searchChoice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }

                if (searchChoice == 0) {
                    continue;
                }

                try {

                    if (searchChoice == 1) {

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        store.searchByName(name);
                    }

                    else if (searchChoice == 2) {

                        System.out.print("Enter type (SUMMER/WINTER/AUTUMN/SPRING): ");
                        ClothesType type =
                                ClothesType.valueOf(scanner.nextLine().toUpperCase());

                        store.searchByType(type);
                    }

                    else if (searchChoice == 3) {

                        System.out.print("Min price: ");
                        double min = Double.parseDouble(scanner.nextLine());

                        System.out.print("Max price: ");
                        double max = Double.parseDouble(scanner.nextLine());

                        store.searchByPrice(min, max);
                    }

                    else {
                        System.out.println("Invalid option!");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                catch (Exception e) {
                    System.out.println("Unexpected error!");
                }
            }            
            
            // ВИХІД
            else if (choice == 4) {

                FileService.saveToFile(store.getAll(), "input.txt");

                System.out.println("Data saved to file. Program finished");
                break;
            }

            // НЕПРАВИЛЬНИЙ ВИБІР
            else {
                System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
    
}