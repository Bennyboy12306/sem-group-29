package com.napier.sem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueryTest {

    @Test
    void nullTest()
    {
      Query.runQuery(null, 0, null, false);
    }



    @Test
    void formatResult() {
    }
}