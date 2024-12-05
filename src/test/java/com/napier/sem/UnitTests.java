package com.napier.sem;

import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitTests
{
    private static ResultSet mockResultSet;

    // Unit Tests
    // Note tests require Mockito

    @BeforeAll
    static void init() {
        mockResultSet = mock(ResultSet.class);
    }

    /**
     * This test ensures that the print method is working correctly
     */
    @Test
    void printTest()
    {
        assertTrue(Query.printQueryDetails("Test", "SHOW TABLES"), "Print failed");
    }

    /**
     * This test ensures that the print method handles empty string being passed in
     */
    @Test
    void printEmptyTest()
    {
        assertFalse(Query.printQueryDetails("", ""), "Printing empty query returned unexpected result");
    }

    /**
     * This test ensures that the print method handles null being passed in
     */
    @Test
    void printNullTest()
    {
        assertFalse(Query.printQueryDetails(null, null), "Passing in null to Print should return null");
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