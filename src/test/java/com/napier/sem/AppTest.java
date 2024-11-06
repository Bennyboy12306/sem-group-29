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
        boolean isConnected = Database.connect();
        assertTrue(isConnected, "Database connection should be established.");

        Connection connection = Database.getConnection();
        assertNotNull(connection, "Connection object should not be null.");

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

    @Test
    public void generalTests() {
        Connection connection = Database.getConnection();
        assertNotNull(connection, "Connection object should not be null.");

        // 1. Validate location
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name FROM city;");
            while (resultSet.next()) {
                assertNotNull(resultSet.getString("name"), "Location should not be null.");
            }
        } catch (SQLException e) {
            fail("SQLException occurred while validating location: " + e.getMessage());
        }

        // 2. Validate population of location
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT population FROM city;");
            while (resultSet.next()) {
                assertTrue(resultSet.getInt("population") > 0, "Population should be greater than 0.");
            }
        } catch (SQLException e) {
            fail("SQLException occurred while validating population: " + e.getMessage());
        }

        // 3. Validate query order: 1 - Country, 2 - Continent, 3 - Region
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name, population FROM ("
                    + "SELECT 'Country' AS name, SUM(population) AS population FROM country "
                    + "UNION "
                    + "SELECT 'Continent' AS name, SUM(population) AS population FROM country GROUP BY continent "
                    + "UNION "
                    + "SELECT 'Region' AS name, SUM(population) AS population FROM country GROUP BY region "
                    + ") AS combined ORDER BY population DESC;");
            if (resultSet.next()) {
                assertEquals("Country", resultSet.getString("name"), "First entry should be 'Country'.");
            }
            if (resultSet.next()) {
                assertEquals("Continent", resultSet.getString("name"), "Second entry should be 'Continent'.");
            }
            if (resultSet.next()) {
                assertEquals("Region", resultSet.getString("name"), "Third entry should be 'Region'.");
            }
        } catch (SQLException e) {
            fail("SQLException occurred while validating query order: " + e.getMessage());
        }

        // 4. Calculate in population order: largest to smallest
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name, population FROM country ORDER BY population DESC;");
            int previousPopulation = Integer.MAX_VALUE;
            while (resultSet.next()) {
                int currentPopulation = resultSet.getInt("population");
                assertTrue(previousPopulation >= currentPopulation, "Population should be in descending order.");
                previousPopulation = currentPopulation;
            }
        } catch (SQLException e) {
            fail("SQLException occurred while validating population order: " + e.getMessage());
        }

        // 5. Print calculation (demonstration just to make sure it is visually correct in the command prompt)
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT name, population FROM country ORDER BY population DESC;");
            System.out.println("Country populations in descending order:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + ": " + resultSet.getInt("population"));
            }
        } catch (SQLException e) {
            fail("SQLException occurred while printing calculation: " + e.getMessage());
        }
    }
    @Test
    public void userInput(){
        // To be done later
    }
}