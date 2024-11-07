import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import com.napier.sem.Database;


class AppTest
{

    static Database db;

    @BeforeAll
    static void init()
    {
        db = new Database();
        db.connect();
    }

    @Test
    void databaseTest()
    {
        assertNotEquals(null, Database.getConnection());
    }
}