package com.napier.sem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QueryTest {

    private static ResultSet mockResultSet;


    // Basis for the unit tests

    @BeforeAll
    static void init() {
        mockResultSet = mock(ResultSet.class);
    }

    @Test
        // mockresultset test just to make sure they work
    void testFormatResult() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("data1");
        when(mockResultSet.getString(2)).thenReturn("data2");

        String result = Query.formatResult(mockResultSet, 2);

        assertEquals(" | data1 | data2 | ", result, "Should return the correct result");
    }

    /*--
    When testing after changing code please change the thenReturn to whatever values required
     */

    @Test
    void testFormatResultNull() throws SQLException {
        String result = Query.formatResult(null, 2);

        // Fix added for null
        assertNull(result, "Should return null");
    }

    @Test
    void testFormatResultEmpty() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("");
        when(mockResultSet.getString(2)).thenReturn("");

        String result = Query.formatResult(mockResultSet, 2);

        // Fix added for empty columns
        assertNull(result, "Should return null");
    }

}