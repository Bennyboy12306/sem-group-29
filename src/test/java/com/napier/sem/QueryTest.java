package com.napier.sem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QueryTest {

    private static ResultSet mockResultSet;

    @BeforeAll
    static void init() {
        mockResultSet = mock(ResultSet.class);
    }

    @Test
    void testFormatResult() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("data1");
        when(mockResultSet.getString(2)).thenReturn("data2");

        String result = Query.formatResult(mockResultSet, 2);

        assertEquals(" | data1 | data2 | ", result, "Should return the correct result");
    }

    @Test
    void testFormatResultFail() throws SQLException {
        when(mockResultSet.getString(1)).thenReturn("data3");
        when(mockResultSet.getString(2)).thenReturn("data2");

        String result = Query.formatResult(mockResultSet, 2);

        assertEquals(" | data1 | data2 | ", result, "Should return the correct result");
    }
}