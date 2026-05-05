package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of clothes: ");
        int n = sc.nextInt();
        sc.nextLine();

        Clothes[] arr = new Clothes[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Type: ");
            String type = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            arr[i] = new Clothes(name, type, price);
        }

        System.out.println("\nRESULT:");
        for (Clothes c : arr) {
            System.out.println(c);
        }

        sc.close();
    }
}