package com.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(String propertiesPath) {

        try {

            Properties props = new Properties();
            props.load(new FileInputStream(propertiesPath));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            connection =
                    DriverManager.getConnection(url, user, password);

            System.out.println("Database connected");

        } catch (Exception e) {
            System.out.println("Database connection error: "
                    + e.getMessage());
        }
    }

    public void saveClothes(Clothes c) {

        String sql =
                "INSERT INTO clothes " +
                "(type, name, season_type, price, size, material, long_sleeve, hood, sole_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1,
                    c.getClass().getSimpleName());

            ps.setString(2,
                    c.getName());

            ps.setString(3,
                    c.getType().toString());

            ps.setDouble(4,
                    c.getPrice());

            ps.setString(5,
                    c.getSize());

            if (c instanceof Pants p) {

                ps.setString(6,
                        p.getMaterial());

            } else {
                ps.setNull(6,
                        java.sql.Types.VARCHAR);
            }

            if (c instanceof Shirts s) {

                ps.setBoolean(7,
                        s.isLongSleeve());

            } else {
                ps.setNull(7,
                        java.sql.Types.BOOLEAN);
            }

            if (c instanceof Jacket j) {

                ps.setBoolean(8,
                        j.isHood());

            } else {
                ps.setNull(8,
                        java.sql.Types.BOOLEAN);
            }

            if (c instanceof Shoes sh) {

                ps.setString(9,
                        sh.getSoleType());

            } else {
                ps.setNull(9,
                        java.sql.Types.VARCHAR);
            }

            ps.executeUpdate();

            System.out.println("Saved to database");

        } catch (SQLException e) {

            System.out.println("SQL error: "
                    + e.getMessage());
        }
    }
}