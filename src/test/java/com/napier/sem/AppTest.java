package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void preRequisiteValidation() {
        // Validate that connection to the database is possible
        boolean isConnected = Database.connect();
        assertTrue(isConnected, "Database connection should be established.");

        Connection connection = Database.getConnection();
        assertNotNull(connection, "Connection object should not be null.");

        // Validate that the required tables exist
        String[] requiredTables = {"city", "country", "countrylanguage"};
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SHOW TABLES;");
            Set<String> tables = new HashSet<>();
            while (resultSet.next()) {
                tables.add(resultSet.getString(1));
            }

            for (String requiredTable : requiredTables) {
                assertTrue(tables.contains(requiredTable), "Table '" + requiredTable + "' should exist in the database.");
            }
        } catch (SQLException e) {
            fail("SQLException occurred while checking tables: " + e.getMessage());
        }
    }
}