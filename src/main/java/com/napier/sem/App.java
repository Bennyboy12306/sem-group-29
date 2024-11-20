package com.napier.sem;

/**
 * This class contains main() and is the entry-point for our application.
 * The database class is called in order to create a connection for our application session.
 */
public class App {

    // CONFIG OPTIONS
    private static final String ISSUE_12_NAME_OF_CONTINENT = "Europe";
    private static final String ISSUE_13_NAME_OF_REGION = "Eastern Europe";
    private static final String ISSUE_14_N_COUNTRIES = "10";
    private static final String ISSUE_15_NAME_OF_CONTINENT = "Asia";
    private static final String ISSUE_15_N_COUNTRIES = "8";
    private static final String ISSUE_16_NAME_OF_REGION = "Eastern Europe";
    private static final String ISSUE_16_N_COUNTRIES = "4";
    private static final String ISSUE_18_NAME_OF_CONTINENT = "Asia";
    private static final String ISSUE_19_NAME_OF_REGION = "Eastern Europe";
    private static final String ISSUE_20_NAME_OF_COUNTRY = "United Kingdom";
    private static final String ISSUE_41_NAME_OF_CITY = "London";
    private static final String ISSUE_40_NAME_OF_DISTRICT = "Scotland";
    private static final String ISSUE_39_NAME_OF_COUNTRY = "United Kingdom";
    private static final String ISSUE_37_NAME_OF_CONTINENT = "Europe";
    private static final String ISSUE_38_NAME_OF_REGION = "British Islands";

    public static void main(String[] args) {
        Database.connect(false);

        // Query Usage, Query.runQuery("<your query>", <expected columns from this query>, <name of query>, <is this a test query?>).
        // To test run `docker-compose down --rmi all` in terminal, package the app, run the docker compose.
        // and expand the app section of the docker compose in the services tab to see the output.
        // It may take a few attempts to connect.

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC;", 2, "11-Countries-ordered-by-population", false);

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC;", 2, "17-Cities-ordered-by-population", false);

        Query.runQuery("SELECT SUM(population) as totalPopulation FROM country;", 1, "36-As a user, I want to view the population of the world.", false);

        Query.runQuery("SELECT population FROM city WHERE name='" + ISSUE_41_NAME_OF_CITY + "' LIMIT 1;", 1, "41-As a user, I want to view the population of a city.", false);

        Query.runQuery("SELECT SUM(population) FROM city WHERE district='" + ISSUE_40_NAME_OF_DISTRICT + "';", 1, "40-As a user, I want to view the population of a district.", false);

        Query.runQuery("SELECT population FROM country WHERE name='" + ISSUE_39_NAME_OF_COUNTRY + "';", 1, "39-As a user, I want to view the population of a country.", false);

        Query.runQuery("SELECT SUM(population) FROM country WHERE continent='" + ISSUE_37_NAME_OF_CONTINENT + "';", 1, "37-As a user, I want to view the population of a continent.", false);

        Query.runQuery("SELECT SUM(population) FROM country WHERE region='" + ISSUE_38_NAME_OF_REGION + "';", 1, "38-As a user, I want to view the population of a region." ,false);

        Query.runQuery("SELECT name, population FROM country WHERE continent='" + ISSUE_12_NAME_OF_CONTINENT + "' ORDER BY population DESC;", 2, "12-As a user, I want to view all countries in a continent organized by largest population to smallest.", false);

        Query.runQuery("SELECT name, population FROM country WHERE region='" + ISSUE_13_NAME_OF_REGION + "' ORDER BY population DESC;", 2, "13-As a user, I want to view all countries in a region organized by largest population to smallest", false);

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC LIMIT " + ISSUE_14_N_COUNTRIES + ";", 2, "14-As a user, I want to view the top N populated countries in the world where N is provided by me", false);

        Query.runQuery("SELECT name, population FROM country WHERE continent='" + ISSUE_15_NAME_OF_CONTINENT + "' ORDER BY population DESC LIMIT " + ISSUE_15_N_COUNTRIES + ";", 2, "15-As a user, I want to view the top N populated countries in a continent where N is provided by me", false);

        Query.runQuery("SELECT name, population FROM country WHERE region='" + ISSUE_16_NAME_OF_REGION + "' ORDER BY population DESC LIMIT " + ISSUE_16_N_COUNTRIES + ";", 2, "16-As a user, I want to view the top N populated countries in a region where N is provided by me", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE continent='" + ISSUE_18_NAME_OF_CONTINENT + "'ORDER BY population DESC;", 2, "18-As a user, I want to view all cities in a continent organised by largest population to smallest.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE region='" + ISSUE_19_NAME_OF_REGION + "'ORDER BY population DESC;", 2, "19-As a user, I want to view all cities in a region organised by largest population to smallest.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE country.name='" + ISSUE_20_NAME_OF_COUNTRY + "'ORDER BY population DESC;", 2, "20-As a user, I want to view all cities in a country organised by largest population to smallest.", false);
    }

}