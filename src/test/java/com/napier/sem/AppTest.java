package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AppTest
{

    static Database db;

    @BeforeAll
    static void init()
    {
    }

    @Test
    void databaseTest()
    {
        Database.connect();
        assertNotEquals(null, Database.getConnection());
    }
}