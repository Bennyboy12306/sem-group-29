package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


class AppTest
{

    // Note due to the nature of how our database works, test will only succeed if run from git actions

    @BeforeAll
    static void init()
    {
        Database.connect(true);
    }

    /**
     * This test checks if the database has been connected successfully
     */
    @Test
    void databaseTest()
    {
        assertNotNull(Database.getConnection());
    }

    @Test
    void queryTest()
    {
        try
        {
            var connection = Database.getConnection();
            var statement = connection.prepareStatement("SHOW TABLES;");
            var result = statement.executeQuery();
            assertNotEquals( "", Query.formatResult(result, 1));
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}