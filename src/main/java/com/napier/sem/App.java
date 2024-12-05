package com.napier.sem;

/**
 * This class contains main() and is the entry-point for our application.
 * The database class is called in order to create a connection for our application session.
 */
public class App {

    // CONFIG OPTIONS
    private static final String ISSUE_12_CONTINENT = "Europe";
    private static final String ISSUE_13_REGION = "Eastern Europe";
    private static final String ISSUE_14_N_COUNTRIES = "10";
    private static final String ISSUE_15_CONTINENT = "Asia";
    private static final String ISSUE_15_N_COUNTRIES = "8";
    private static final String ISSUE_16_REGION = "Eastern Europe";
    private static final String ISSUE_16_N_COUNTRIES = "4";
    private static final String ISSUE_18_CONTINENT = "Asia";
    private static final String ISSUE_19_REGION = "Eastern Europe";
    private static final String ISSUE_20_COUNTRY = "United Kingdom";
    private static final String ISSUE_21_DISTRICT = "Ontario";
    private static final String ISSUE_22_N_COUNTRIES = "5";
    private static final String ISSUE_23_N_CITIES = "5";
    private static final String ISSUE_23_CONTINENT = "Europe";
    private static final String ISSUE_24_REGION = "Western Europe";
    private static final String ISSUE_24_N_CITIES = "5";
    private static final String ISSUE_25_N_CITIES = "5";
    private static final String ISSUE_25_COUNTRY = "Mexico";
    private static final String ISSUE_26_N_CITIES = "5";
    private static final String ISSUE_26_DISTRICT = "California";
    private static final String ISSUE_37_CONTINENT = "Europe";
    private static final String ISSUE_38_REGION = "British Islands";
    private static final String ISSUE_39_COUNTRY = "United Kingdom";
    private static final String ISSUE_40_DISTRICT = "Scotland";
    private static final String ISSUE_41_CITY = "London";



    public static void main(String[] args) {
        Database.connect(false);

        // Query Usage, Query.runQuery("<your query>", <expected columns from this query>, <name of query>, <is this a test query?>).
        // To test run `docker-compose down --rmi all` in terminal, package the app, run the docker compose.
        // and expand the app section of the docker compose in the services tab to see the output.
        // It may take a few attempts to connect.

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC;", 2, "11-Countries-ordered-by-population", false); // 1

        Query.runQuery("SELECT name, population FROM country WHERE continent='" + ISSUE_12_CONTINENT + "' ORDER BY population DESC;", 2, "12-As a user, I want to view all countries in a continent organized by largest population to smallest.", false); // 2

        Query.runQuery("SELECT name, population FROM country WHERE region='" + ISSUE_13_REGION + "' ORDER BY population DESC;", 2, "13-As a user, I want to view all countries in a region organized by largest population to smallest", false); // 3

        Query.runQuery("SELECT name, population FROM country ORDER BY population DESC LIMIT " + ISSUE_14_N_COUNTRIES + ";", 2, "14-As a user, I want to view the top N populated countries in the world where N is provided by me", false); // 4

        Query.runQuery("SELECT name, population FROM country WHERE continent='" + ISSUE_15_CONTINENT + "' ORDER BY population DESC LIMIT " + ISSUE_15_N_COUNTRIES + ";", 2, "15-As a user, I want to view the top N populated countries in a continent where N is provided by me", false); // 5

        Query.runQuery("SELECT name, population FROM country WHERE region='" + ISSUE_16_REGION + "' ORDER BY population DESC LIMIT " + ISSUE_16_N_COUNTRIES + ";", 2, "16-As a user, I want to view the top N populated countries in a region where N is provided by me", false); // 6

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC;", 2, "17-Cities-ordered-by-population", false); // 7

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE continent='" + ISSUE_18_CONTINENT + "'ORDER BY population DESC;", 2, "18-As a user, I want to view all cities in a continent organised by largest population to smallest.", false); // 8

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE region='" + ISSUE_19_REGION + "'ORDER BY population DESC;", 2, "19-As a user, I want to view all cities in a region organised by largest population to smallest.", false); // 9

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE country.name='" + ISSUE_20_COUNTRY + "'ORDER BY population DESC;", 2, "20-As a user, I want to view all cities in a country organised by largest population to smallest.", false); // 10

        Query.runQuery("SELECT name, population FROM city WHERE district='" + ISSUE_21_DISTRICT + "'ORDER BY population DESC;", 2, "21-As a user, I want to view all cities in a district organised by largest population to smallest.", false); // 11

        Query.runQuery("SELECT name, population FROM city ORDER BY population DESC LIMIT " + ISSUE_22_N_COUNTRIES + ";", 2, "22-As a user, I want to view the top N populated cities in the world where N is provided by me.", false); // 12

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE continent='" + ISSUE_23_CONTINENT + "' ORDER BY population DESC LIMIT " + ISSUE_23_N_CITIES + ";", 2, "23-As a user, I want to view the top N populated cities in a continent where N is provided by me.", false); // 13

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE region='" + ISSUE_24_REGION + "' ORDER BY population DESC LIMIT " + ISSUE_24_N_CITIES + ";", 2, "24-As a user, I want to view the top N populated cities in a region where N is provided by me.", false); // 14

        Query.runQuery("SELECT city.name, city.population FROM country JOIN city ON Code=CountryCode WHERE country.name='" + ISSUE_25_COUNTRY + "' ORDER BY population DESC LIMIT " + ISSUE_25_N_CITIES + ";", 2, "25-As a user, I want to view the top N populated cities in a country where N is provided by me.", false); // 15

        Query.runQuery("SELECT name, population FROM city WHERE district='" + ISSUE_26_DISTRICT + "' ORDER BY population DESC LIMIT " + ISSUE_26_N_CITIES + ";", 2, "26-As a user, I want to view the top N populated cities in a district where N is provided by me.", false); // 16

        Query.runQuery("SELECT continent, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY continent;", 4, "33-As a user, I want to view the population of people, people living in cities, and people not living in cities in each continent.", false); // 17

        Query.runQuery("SELECT country.name, country.region, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY country.name, country.region LIMIT 10;", 4, "34-As a user, I want to view the population of people, people living in cities, and people not living in cities in each region.", false); // 18

        Query.runQuery("SELECT country.name, SUM(country.population) AS totalPop, SUM(city.population) AS inCities, SUM(country.population) - SUM(city.population) AS notInCities FROM country JOIN city ON Code=CountryCode GROUP BY country.name, country.population LIMIT 10;", 4, "35-As a user, I want to view the population of people, people living in cities, and people not living in cities in each country.", false); // 19

        Query.runQuery("SELECT SUM(population) as totalPopulation FROM country;", 1, "36-As a user, I want to view the population of the world.", false); // 20

        Query.runQuery("SELECT SUM(population) FROM country WHERE continent='" + ISSUE_37_CONTINENT + "';", 1, "37-As a user, I want to view the population of a continent.", false); // 21

        Query.runQuery("SELECT SUM(population) FROM country WHERE region='" + ISSUE_38_REGION + "';", 1, "38-As a user, I want to view the population of a region." ,false); // 22

        Query.runQuery("SELECT population FROM country WHERE name='" + ISSUE_39_COUNTRY + "';", 1, "39-As a user, I want to view the population of a country.", false); // 23

        Query.runQuery("SELECT SUM(population) FROM city WHERE district='" + ISSUE_40_DISTRICT + "';", 1, "40-As a user, I want to view the population of a district.", false); // 24

        Query.runQuery("SELECT population FROM city WHERE name='" + ISSUE_41_CITY + "' LIMIT 1;", 1, "41-As a user, I want to view the population of a city.", false); // 25
    }

}