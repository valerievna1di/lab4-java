package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Clothes> list = FileService.loadFromFile("input.txt");

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

                        list.add(c);

                        System.out.println("Clothes created!");
                    }

                    else if (objectChoice == 2) {

                        System.out.print("Material: ");
                        String material = scanner.nextLine();

                        Pants pants =
                                new Pants(name, type,
                                        price, size, material);

                        list.add(pants);

                        System.out.println("Pants created!");
                    }

                    else if (objectChoice == 3) {

                        System.out.print("Long sleeve (true/false): ");
                        boolean longSleeve =
                                Boolean.parseBoolean(scanner.nextLine());

                        Shirts shirt =
                                new Shirts(name, type,
                                        price, size, longSleeve);

                        list.add(shirt);

                        System.out.println("Shirt created!");
                    }

                    else if (objectChoice == 4) {

                        System.out.print("Has hood (true/false): ");
                        boolean hood =
                                Boolean.parseBoolean(scanner.nextLine());

                        Jacket jacket =
                                new Jacket(name, type,
                                        price, size, hood);

                        list.add(jacket);

                        System.out.println("Jacket created!");
                    }

                    else if (objectChoice == 5) {

                        System.out.print("Sole type: ");
                        String soleType = scanner.nextLine();

                        Shoes shoes =
                                new Shoes(name, type,
                                        price, size, soleType);

                        list.add(shoes);

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

                if (list.isEmpty()) {
                    System.out.println("No objects created yet");
                } else {
                    System.out.println("Objects count: " + list.size());
                    System.out.println("\n--- ALL OBJECTS ---");

                    for (Clothes c : list) {
                        System.out.println(c); // поліморфізм
                    }
                }
            }

            // МЕНЮ ПОШУКУ
            if (choice == 3) {

                System.out.println("\n--- SEARCH MENU ---");
                System.out.println("1. By name");
                System.out.println("2. By type");
                System.out.println("3. By price range");
                System.out.println("0. Back");
                
                if (searchChoice == 1) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    searchByName(list, name);
                }
            }            
            
            // ВИХІД
            else if (choice == 4) {

                FileService.saveToFile(list, "input.txt");

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
    
    static void searchByName(ArrayList<Clothes> list, String name) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Nothing found");
        }
    }
    
}