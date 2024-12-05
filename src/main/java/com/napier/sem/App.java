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
    private static final String ISSUE_21_NAME_OF_DISTRICT = "Ontario";
    private static final String ISSUE_41_NAME_OF_CITY = "London";
    private static final String ISSUE_40_NAME_OF_DISTRICT = "Scotland";
    private static final String ISSUE_39_NAME_OF_COUNTRY = "United Kingdom";
    private static final String ISSUE_37_NAME_OF_CONTINENT = "Europe";
    private static final String ISSUE_38_NAME_OF_REGION = "British Islands";
    private static final String ISSUE_22_N_COUNTRIES = "5";
    private static final String ISSUE_26_N_CITIES = "5";
    private static final String ISSUE_26_DISTRICT = "California";
    private static final String ISSUE_25_N_CITIES = "5";
    private static final String ISSUE_25_COUNTRY = "Mexico";
    private static final String ISSUE_24_REGION = "Western Europe";
    private static final String ISSUE_24_N_CITIES = "5";
    private static final String ISSUE_23_N_CITIES = "5";
    private static final String ISSUE_23_CONTINENT = "Europe";
    private static final String ISSUE_32_N_CITIES = "5";

    public static void main(String[] args) {
        Database.connect(false);

        // Query Usage, Query.runQuery("<your query>", <expected columns from this query>, <name of query>, <is this a test query?>).
        // To test run `docker-compose down --rmi all` in terminal, package the app, run the docker compose.
        // and expand the app section of the docker compose in the services tab to see the output.
        // It may take a few attempts to connect.

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC;", 2, "11-Countries-ordered-by-population", false); // Report 1 (Issue #11)

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC;", 2, "17-Cities-ordered-by-population", false); // Report 7 (Issue #17)

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

        Query.runQuery("SELECT name, population FROM city WHERE district='" + ISSUE_21_NAME_OF_DISTRICT + "'ORDER BY population DESC;", 2, "21-As a user, I want to view all cities in a district organised by largest population to smallest.", false);

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC LIMIT " + ISSUE_22_N_COUNTRIES + ";", 2, "22-As a user, I want to view the top N populated cities in the world where N is provided by me.", false);

        Query.runQuery("SELECT name, population FROM city WHERE district='" + ISSUE_26_DISTRICT + "' ORDER BY population DESC LIMIT " + ISSUE_26_N_CITIES + ";", 2, "26-As a user, I want to view the top N populated cities in a district where N is provided by me.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE country.name='" + ISSUE_25_COUNTRY + "' ORDER BY population DESC LIMIT " + ISSUE_25_N_CITIES + ";", 2, "25-As a user, I want to view the top N populated cities in a country where N is provided by me.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE region='" + ISSUE_24_REGION + "' ORDER BY population DESC LIMIT " + ISSUE_24_N_CITIES + ";", 2, "24-As a user, I want to view the top N populated cities in a region where N is provided by me.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE continent='" + ISSUE_23_CONTINENT + "' ORDER BY population DESC LIMIT " + ISSUE_23_N_CITIES + ";", 2, "23-As a user, I want to view the top N populated cities in a continent where N is provided by me.", false);

        Query.runQuery("SELECT continent, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY continent;", 4, "33-As a user, I want to view the population of people, people living in cities, and people not living in cities in each continent.", false);

        Query.runQuery("SELECT country.name, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY country.name, country.population LIMIT 10;", 4, "35-As a user, I want to view the population of people, people living in cities, and people not living in cities in each country.", false);

        Query.runQuery("SELECT country.name, country.region, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY country.name, country.region LIMIT 10;", 4, "34-As a user, I want to view the population of people, people living in cities, and people not living in cities in each region.", false);

        Query.runQuery("SELECT country.name AS countryName, city.name AS cityName, city.population FROM country JOIN city ON Code=CountryCode WHERE city.ID = country.Capital ORDER BY city.population DESC;", 3, "27-As a user, I want to view all capital cities in the world organized by largest population to smallest.", false);

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE city.ID = country.Capital ORDER BY population DESC LIMIT " + ISSUE_32_N_CITIES + ";", 2, "32-As a user, I want to view the top N populated capital cities in a region where N is provided by me.", false);





    }

}