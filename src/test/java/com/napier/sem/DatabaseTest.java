package com.napier.sem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    // -- Simple true and false connections
    // -- Ideally DatabaseTests should be integrated - And they have been in AppTest
    // -- Added fake statements to showcase how failed tests would look

    @Test
    void connectTrue() {
        // -- Tests for connection
        assertTrue(true, "There is no connection but should be a connection");
    }
    @Test
    void connectFalse() {
        // -- Tests for wrong connection
        assertFalse(false, "There is a connection but shouldn't be connection");
    }

    @Test
        // -- Standard failed connection
    void failedTrue(){
        assertEquals(true, false, "Unable to get connection");
    }

    @Test
        // -- Standard successful connection
    void getConnection() {
        assertEquals(true, true,  "Unable to get connection");
    }

    @Test
        // -- Connection is Null
        // -- This does not test for failed connections
    void falseConnection() {
        assertEquals(false, null, "Attempted to connect but received Null");
    }
}