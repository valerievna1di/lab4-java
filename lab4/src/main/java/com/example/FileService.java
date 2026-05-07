package com.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {

    public static ArrayList<Clothes> loadFromFile(String fileName) {

        ArrayList<Clothes> list = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fileName))) {

            while (sc.hasNextLine()) {

                String[] parts = sc.nextLine().split(";");
                
                if (parts.length < 5) continue;
                
                String type = parts[0];

                switch (type) {

                    case "CLOTHES":
                        list.add(new Clothes(parts[1],
                                ClothesType.valueOf(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4]));
                        break;

                    case "PANTS":
                        if (parts.length < 6) continue;
                    
                        list.add(new Pants(parts[1],
                                ClothesType.valueOf(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4],
                                parts[5]));
                        break;

                    case "SHIRTS":
                        if (parts.length < 6) continue;
                    
                        list.add(new Shirts(parts[1],
                                ClothesType.valueOf(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4],
                                Boolean.parseBoolean(parts[5])));
                        break;

                    case "JACKET":
                        if (parts.length < 6) continue;
                    
                        list.add(new Jacket(parts[1],
                                ClothesType.valueOf(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4],
                                Boolean.parseBoolean(parts[5])));
                        break;

                    case "SHOES":
                        if (parts.length < 6) continue;
                    
                        list.add(new Shoes(parts[1],
                                ClothesType.valueOf(parts[2]),
                                Double.parseDouble(parts[3]),
                                parts[4],
                                parts[5]));
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }

    public static void saveToFile(ArrayList<Clothes> list, String fileName) {

        try (FileWriter writer = new FileWriter(fileName)) {

            for (Clothes c : list) {

                if (c instanceof Pants p) {
                    writer.write("PANTS;" + p.getName() + ";" + p.getType() + ";" + p.getPrice() + ";" + p.getSize() + ";" + p.getMaterial() + "\n");
                }

                else if (c instanceof Shirts s) {
                    writer.write("SHIRTS;" + s.getName() + ";" + s.getType() + ";" + s.getPrice() + ";" + s.getSize() + ";" + s.isLongSleeve() + "\n");
                }

                else if (c instanceof Jacket j) {
                    writer.write("JACKET;" + j.getName() + ";" + j.getType() + ";" + j.getPrice() + ";" + j.getSize() + ";" + j.isHood() + "\n");
                }

                else if (c instanceof Shoes sh) {
                    writer.write("SHOES;" + sh.getName() + ";" + sh.getType() + ";" + sh.getPrice() + ";" + sh.getSize() + ";" + sh.getSoleType() + "\n");
                }

                else {
                    writer.write("CLOTHES;" + c.getName() + ";" + c.getType() + ";" + c.getPrice() + ";" + c.getSize() + "\n");
                }
            }

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}