package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Clothes> list = new ArrayList<>();

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Create Clothes");
            System.out.println("2. Create Pants");
            System.out.println("3. Create Shirts");
            System.out.println("4. Show all objects");
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

            // CLOTHES
            if (choice == 1) {

                try {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Type (SUMMER/WINTER/AUTUMN/SPRING): ");
                    ClothesType type = ClothesType.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Size: ");
                    String size = scanner.nextLine();

                    Clothes c = new Clothes(name, type, price, size);
                    list.add(c);

                    System.out.println("Clothes created!");

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // PANTS
            else if (choice == 2) {

                try {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Type (SUMMER/WINTER/AUTUMN/SPRING): ");
                    ClothesType type = ClothesType.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Size: ");
                    String size = scanner.nextLine();

                    System.out.print("Material: ");
                    String material = scanner.nextLine();

                    Clothes p = new Pants(name, type, price, size, material);
                    list.add(p);

                    System.out.println("Pants created!");

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // SHIRTS
            else if (choice == 3) {

                try {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Type (SUMMER/WINTER/AUTUMN/SPRING): ");
                    ClothesType type = ClothesType.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Size: ");
                    String size = scanner.nextLine();

                    System.out.print("Long sleeve (true/false): ");
                    boolean longSleeve = Boolean.parseBoolean(scanner.nextLine());

                    Clothes s = new Shirts(name, type, price, size, longSleeve);
                    list.add(s);

                    System.out.println("Shirt created!");

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // ВИВІД ОБ’ЄКТІВ (POLYMORPHISM)
            else if (choice == 4) {

                if (list.isEmpty()) {
                    System.out.println("No objects yet");
                } else {
                    System.out.println("\n--- CLOTHES LIST ---");

                    for (Clothes c : list) {
                        System.out.println(c); // поліморфізм
                    }
                }
            }

            // ВИХІД
            else if (choice == 5) {
                System.out.println("Program finished");
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