package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
class QueryTest {

    // These require DB connections
    @Test
    void runQuery() {
    }

    @Test
    void formatResult() throws SQLException {
        // -- Test for null
        Query.formatResult(null, 2);
    }
}