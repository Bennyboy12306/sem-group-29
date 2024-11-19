package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppTest
{
    private static ResultSet mockResultSet;

    // Integration and unit Test

    // Note due to the nature of how our database works, integration test will only succeed if run from git actions

    @BeforeAll
    static void init()
    {
        Database.connect(true);
        mockResultSet = mock(ResultSet.class);
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
        Query.runQuery("Show TABLES;", 1, "Test Query", true);
    }

    /**
     * This test checks that data is properly formatted into the correct number of rows
     * @throws SQLException
     */
    @Test
    void testFormatResult() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("data1");
        when(mockResultSet.getString(2)).thenReturn("data2");

        String result = Query.formatResult(mockResultSet, 2);

        assertEquals(" | data1 | data2 | ", result, "Should return the correct result");
    }

    /**
     * This test checks that the formatting returns null when the result set is null
     * @throws SQLException
     */
    @Test
    void testFormatResultNull() throws SQLException {
        String result = Query.formatResult(null, 2);

        assertNull(result, "Should return null when result is null");
    }

    /**
     * This test checks that the program returns null when the result set contains empty columns
     * @throws SQLException
     */
    @Test
    void testFormatResultEmptyColumns() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("");
        when(mockResultSet.getString(2)).thenReturn("");

        String result = Query.formatResult(mockResultSet, 2);

        assertNull(result, "Should return null when there are empty columns");
    }
}