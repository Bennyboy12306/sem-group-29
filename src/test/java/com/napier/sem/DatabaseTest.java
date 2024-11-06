package com.napier.sem;

import org.junit.jupiter.api.Test;
import com.napier.sem.Database;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    public void validateConnection() {
        var connection = Database.getConnection();

        }
    }