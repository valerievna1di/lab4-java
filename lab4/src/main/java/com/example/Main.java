package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Clothes[] clothes = new Clothes[100];
        int count = 0;

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
                    clothes[count++] = c;

                    System.out.println("Object created successfully!");

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

                if (count == 0) {
                    System.out.println("No objects created yet");
                } else {
                    System.out.println("\n--- CLOTHES LIST ---");
                    for (int i = 0; i < count; i++) {
                        System.out.println(clothes[i]);
                    }
             
                }

                System.out.println("Total clothes created: " + Clothes.getCount());

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