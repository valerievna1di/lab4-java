package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
            System.out.println("4. Show sorted objects");
            System.out.println("5. Exit");
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
                System.out.println("1. Pants");
                System.out.println("2. Shirts");
                System.out.println("3. Jacket");
                System.out.println("4. Shoes");
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

                        System.out.print("Material: ");
                        String material = scanner.nextLine();

                        Pants pants =
                                new Pants(name, type,
                                        price, size, material);

                        store.addNewClothes(pants, 1);

                        System.out.println("Pants created!");
                    }

                    else if (objectChoice == 2) {

                        System.out.print("Long sleeve (true/false): ");
                        boolean longSleeve =
                                Boolean.parseBoolean(scanner.nextLine());

                        Shirts shirt =
                                new Shirts(name, type,
                                        price, size, longSleeve);

                        store.addNewClothes(shirt, 1);

                        System.out.println("Shirt created!");
                    }

                    else if (objectChoice == 3) {

                        System.out.print("Has hood (true/false): ");
                        boolean hood =
                                Boolean.parseBoolean(scanner.nextLine());

                        Jacket jacket =
                                new Jacket(name, type,
                                        price, size, hood);

                        store.addNewClothes(jacket, 1);

                        System.out.println("Jacket created!");
                    }

                    else if (objectChoice == 4) {

                        System.out.print("Sole type: ");
                        String soleType = scanner.nextLine();

                        Shoes shoes =
                                new Shoes(name, type,
                                        price, size, soleType);

                        store.addNewClothes(shoes, 1);

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
            
            // СОРТУВАННЯ
            else if (choice == 4) {

                if (store.getAll().isEmpty()) {
                    System.out.println("No objects to sort");
                }

                else {

                    System.out.println("\n--- SORT MENU ---");
                    System.out.println("1. Sort by name");
                    System.out.println("2. Sort by price");
                    System.out.println("3. Sort by size");
                    System.out.println("0. Back");

                    int sortChoice;

                    try {
                        sortChoice = Integer.parseInt(scanner.nextLine());
                    }

                    catch (Exception e) {
                        System.out.println("Invalid input!");
                        continue;
                    }

                    if (sortChoice == 0) {
                        continue;
                    }

                    ArrayList<Clothes> sortedList = new ArrayList<>(store.getAll());
                    
                    if (sortChoice == 1) {

                        Collections.sort(sortedList, new java.util.Comparator<Clothes>() {

                            @Override
                            public int compare(Clothes o1, Clothes o2) {

                                return o1.getName().
                                        compareToIgnoreCase(o2.getName());
                            }
                        });
                    }

                    else if (sortChoice == 2) {

                        Collections.sort(sortedList, new java.util.Comparator<Clothes>() {

                            @Override
                            public int compare(Clothes o1, Clothes o2) {

                                return Double.compare( o1.getPrice(), o2.getPrice());
                            }
                        });
                    }
                    
                    else if (sortChoice == 3) {

                        Collections.sort(sortedList, new java.util.Comparator<Clothes>() {

                            @Override
                            public int compare(Clothes o1, Clothes o2) {

                                return getSizeValue(o1.getSize()) - getSizeValue(o2.getSize());
                            }
                        });
                    }

                    else {
                        System.out.println("Invalid option!");
                        continue;
                    }

                    System.out.println("\n--- SORTED OBJECTS ---");

                    for (Clothes c : sortedList) {
                        System.out.println(c);
                    }                    
                }    
            }            
            
            // ВИХІД
            else if (choice == 5) {

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
    
    static int getSizeValue(String size) {

        if (size.equalsIgnoreCase("XS")) {
            return 1;
        }

        else if (size.equalsIgnoreCase("S")) {
            return 2;
        }

        else if (size.equalsIgnoreCase("M")) {
            return 3;
        }

        else if (size.equalsIgnoreCase("L")) {
            return 4;
        }

        else if (size.equalsIgnoreCase("XL")) {
            return 5;
        }

        try {
            return Integer.parseInt(size);
        }

        catch (Exception e) {
            return 0;
        }
    }       
}