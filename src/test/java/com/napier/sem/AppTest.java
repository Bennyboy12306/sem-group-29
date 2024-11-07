package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AppTest
{

    @BeforeAll
    static void init()
    {
    }

    @Test
    void databaseTest()
    {
        // This test is not run until database.connect(); finished, because this test is not in docker the database connection never succeeds
        // Potential solutions, somehow run this in docker or dynamically create a container that can be used directly from here
        Database.connect();
        assertNotEquals(null, Database.getConnection());
    }
}