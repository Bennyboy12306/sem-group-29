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

    /**
     * This test checks that queries are being handled properly
     */
    @Test
    void queryTest()
    {
        String queryResult = Query.runQuery("Show TABLES;", 1, "Test Query", true);
        assertNotNull(queryResult);
    }

    /**
     * This tests checks that all the city data has been loaded into the database
     */
    @Test
    void cityDataIntegrityTest()
    {
        String queryResult = Query.runQuery("SELECT COUNT(*) FROM city;", 1, "Test", true);
        assert(queryResult.contains("4079"));
    }

    /**
     * This tests checks that all the country data has been loaded into the database
     */
    @Test
    void countryDataIntegrityTest()
    {
        String queryResult = Query.runQuery("SELECT COUNT(*) FROM country;", 1, "Test", true);
        assert(queryResult.contains("239"));
    }

    /**
     * This tests checks that all the countrylanguage data has been loaded into the database
     */
    @Test
    void countryLanguageDataIntegrityTest()
    {
        String queryResult = Query.runQuery("SELECT COUNT(*) FROM countrylanguage;", 1, "Test", true);
        assert(queryResult.contains("984"));
    }

    //Continue to add tests as we develop the application
}