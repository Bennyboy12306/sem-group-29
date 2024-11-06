import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.napier.sem.Database;


class AppTest
{

    static Database database;

    @BeforeAll
    static void init()
    {
        database = new Database();

        database.connect();
    }

    @Test
    void databaseTest()
    {
        // This test is not run until database.connect(); finished, because this test is not in docker the database connection never succeeds
        // Potential solutions, somehow run this in docker or dynamically create a container that can be used directly from here
        assertNotEquals(null, Database.getConnection());
    }
}