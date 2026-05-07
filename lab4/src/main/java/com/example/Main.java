package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Clothes> list = new ArrayList<>();

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Create new object");
            System.out.println("2. Show all objects");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            String input = scanner.nextLine();
            int choice;

            // перевірка введення меню
            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number");
                continue;
            }

            // СТВОРЕННЯ ОБ’ЄКТА
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

                    System.out.println("Object created successfully!");
                    
                    // copy constructor demo
                    System.out.print("Create copy? (yes/no): ");
                    String ans = scanner.nextLine();

                    if (ans.equalsIgnoreCase("yes")) {
                        Clothes copy = new Clothes(c);

                        System.out.println("Original: " + c);
                        System.out.println("Copy: " + copy);
                        System.out.println("Are they same object? " + (c == copy));
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Price must be a number!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Unexpected error!");
                }

            }

            // ВИВІД ОБ’ЄКТІВ
            else if (choice == 2) {

                if (list.isEmpty()) {
                    System.out.println("No objects created yet");
                } else {
                    System.out.println("\n--- CLOTHES LIST ---");
                    for (Clothes c : list) {
                        System.out.println(c);
                    }
             
                }

            }

            // ВИХІД
            else if (choice == 3) {
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