package com.napier.sem;

import java.sql.SQLException;

/**
 * This class contains main() and is the entry-point for our application.
 * The database class is called in order to create a connection for our application session.
 */
public class App {

    public static void main(String[] args) {
        Database.connect();

        var connection = Database.getConnection();

        try {
            var statement = connection.prepareStatement("SHOW TABLES;");
            var result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Table name: " + result.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}