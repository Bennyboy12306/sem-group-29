package com.napier.sem;

import org.junit.jupiter.api.*;

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
        String queryResult = Query.runTestQuery("Show TABLES;", 1);
        assertNotNull(queryResult);
    }
}