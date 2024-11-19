package com.napier.sem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class AppTest
{

    // Integration and unit Test

    // Note due to the nature of how our database works, integration test will only succeed if run from git actions

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

    /**
     * This test checks that queries are being handled properly
     */
    @Test
    void queryTest()
    {
        String queryResult = Query.runQuery("Show TABLES;", 1, "Test Query", true);
        assertNotNull(queryResult);
    }

    @Test
    void nullTest()
    {
        String queryResult = Query.runQuery(null, 1, null, true);
        assertNotEquals(queryResult, Query.runQuery("Show TABLES;", 1, "Test Query", true), "Shouldn't be null");
    }

    //Continue to add tests as we develop the application
}