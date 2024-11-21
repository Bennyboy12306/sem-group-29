package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppTest
{
    private static ResultSet mockResultSet;
  
    // Integration and unit Tests

    @BeforeAll
    static void init()
    {
        Database.connect(true);
        mockResultSet = mock(ResultSet.class);
    }

    //Integration Tests
    // Note due to the nature of how our database works, integration test will only succeed if run from git actions

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
        assertNotNull(Query.runQuery("Show TABLES;", 1, "Test Query", true));
    }

    //Unit Tests
    // Note some tests require Mockito

    /**
     * This test ensures that the print method is working correctly
     */
    @Test
    void printTest()
    {
        assertTrue(Query.printQueryDetails("Test", "SHOW TABLES"));
    }

    /**
     * This test ensures that the print method handles empty string being passed in
     */
    @Test
    void printEmptyTest()
    {
        assertFalse(Query.printQueryDetails("", ""));
    }

    /**
     * This test ensures that the print method handles null being passed in
     */
    @Test
    void printNullTest()
    {
        assertFalse(Query.printQueryDetails(null, null));
    }

    /**
     * This test checks that data is properly formatted into the correct number of rows
     * @throws SQLException when something is wrong with result set data
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
     * @throws SQLException when something is wrong with result set data
     */
    @Test
    void testFormatResultNull() throws SQLException {
        String result = Query.formatResult(null, 2);

        assertNull(result, "Should return null when result is null");
    }

    /**
     * This test checks that the formatting returns null when the result set contains empty columns
     * @throws SQLException when something is wrong with result set data
     */
    @Test
    void testFormatResultEmptyColumns() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("");
        when(mockResultSet.getString(2)).thenReturn("");

        String result = Query.formatResult(mockResultSet, 2);

        assertNull(result, "Should return null when there are empty columns");
    }
}