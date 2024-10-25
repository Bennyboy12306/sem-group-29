package com.napier.sem;

/**
 * This class contains main() and is the entry-point for our application.
 * The database class is called in order to create a connection for our application session.
 */
public class App {

    public static void main(String[] args) {
        Database.connect();

        var connection = Database.getConnection();

        // Query Usage, Query.run_query(connection, "<your query>", <expected columns from this query>).
        // To test run `docker-compose down --rmi all` in terminal, package the app, run the docker compose.
        // and expand the app section of the docker compose in the services tab to see the output.
        // It may take a few attempts to connect.

        Query.runQuery(connection, "SHOW TABLES;", 1); //Test Query

        Query.runQuery(connection, "SELECT name, population FROM country ORDER BY population DESC;", 2); // Report 1 (Issue #11)

    }

}