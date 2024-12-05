package com.napier.sem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTests
{

    // Integration Tests

    @BeforeAll
    static void init()
    {
        Database.connect(true);
    }

    //Integration Tests
    // Note due to the nature of how our database works, integration test will only succeed if run from git actions

    /**
     * This test checks if the database has been connected successfully
     */
    @Test
    void databaseTest()
    {
        assertNotNull(Database.getConnection(), "Could not connect to the database");
    }

    /**
     * This test checks that queries are being handled properly
     */
    @Test
    void queryTest()
    {
        assertNotNull(Query.runQuery("Show TABLES;", 1, "Test Query", true), "Could not perform query on the database");
    }
}