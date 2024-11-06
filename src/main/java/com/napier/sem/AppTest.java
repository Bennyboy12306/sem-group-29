package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void validateConnection() {
        boolean isConnected = Database.connect();
        assertTrue(isConnected, "Database connection should be established.");

        Connection connection = Database.getConnection();
        assertNotNull(connection, "Connection object should not be null.");
    }
}
