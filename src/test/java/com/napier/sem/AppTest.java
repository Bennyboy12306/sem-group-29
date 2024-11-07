package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class AppTest
{

    static Database db;

    @BeforeAll
    static void init()
    {
        db = new Database();
        db.connect();
    }

    @Test
    void databaseTest()
    {
        assertNotEquals(null, Database.getConnection());
    }
}