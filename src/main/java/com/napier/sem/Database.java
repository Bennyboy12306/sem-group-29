package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * This class is used to connect to the SQL database, and to provide a connection to all parts of our application.
 */
public class Database {

    private static Connection connection;

    public static void connect(boolean test) {
        // Ensure the SQL driver is present
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            return;
        }

        // Try once when connect() is called, and repeat 10 times waiting 10 seconds between tries until a connection can be established.
        for (int i = 0; i < 10; i++) {
            System.out.println("Attempting to establish a database connection...");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + (test ? "localhost" : "db") + ":3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "password");
                System.out.println("Database connection established successfully.");
                break;
            } catch (SQLException e) {
                System.out.println("Connection attempt unsuccessful: " + e.getMessage());

                System.out.println("Trying again in 10 seconds...");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(10));
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}