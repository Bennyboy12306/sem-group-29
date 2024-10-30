package com.napier.sem;

import java.util.Scanner;

/**
 * This class contains main() and is the entry-point for our application.
 * The database class is called in order to create a connection for our application session.
 */
public class App {

    public static void main(String[] args) {
        Database.connect();

        // Query Usage, Query.runQuery("<your query>", <expected columns from this query>, <name of query>).
        // To test run `docker-compose down --rmi all` in terminal, package the app, run the docker compose.
        // and expand the app section of the docker compose in the services tab to see the output.
        // It may take a few attempts to connect.

        var scanner = new Scanner(System.in);

        Query.runQuery("SHOW TABLES;", 1, "Test Query"); //Test Query

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC;", 2, "11-Countries-ordered-by-population"); // Report 1 (Issue #11)

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC;", 2, "17-Cities-ordered-by-population"); // Report 7 (Issue #17)

        Query.runQuery("SELECT SUM(population) as totalPopulation FROM country;", 1, "36-As a user, I want to view the population of the world.");
    }

}