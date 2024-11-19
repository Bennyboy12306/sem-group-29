package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    // -- Simple true and false connections

    @Test
    void connectTrue() {
        assertTrue(true, "There is no connection but should be a connection");
    }
    @Test
    void connectFalse() {
        assertFalse(false, "There is connection but shouldn't be connection");
    }

    @Test
        // Failed test on purpose
    void failedTrue(){
        assertEquals(true, false, "Unable to get connection");
    }

    @Test
    // Could've used asserttrue but wanted to prove workability of assertEquals
    void getConnection() {
        assertEquals(true, true,  "Unable to get connection");
    }

    @Test
    // Failed test on purpose
    void falseConnection() {
        assertEquals(false, null, "Attempted to connect but received Null");
    }
}