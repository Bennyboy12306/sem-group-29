package com.napier.sem;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contains the logic for queries and formatting the query results.
 */
public class Query {

    /**
     * This method is used to run a query and handle exceptions.
     * TODO Change this to output each query to their own file instead of printing everything to console
     *
     * @param query   the query to run.
     * @param columns how many columns this query will return (for formatting)
     * @param name    the name of this query
     */
    public static String runQuery(String query, int columns, String name, boolean test) {
        if (!test) {
            printQueryDetails(name, query);
        }
        try {
            var connection = Database.getConnection();
            var statement = connection.prepareStatement(query);
            var result = statement.executeQuery();

            String resultString = "";


            while (result.next()) {
                if (test) {
                    resultString += (formatResult(result, columns));

                } else {
                    System.out.println(formatResult(result, columns));
                }

            }

            if (test) {
                return resultString;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Boolean printQueryDetails(String name, String query) {
        if (name == null || query == null || query.isEmpty() || name.isEmpty()) {
            return false;
        }

        System.out.println(" ");
        System.out.println("Running task: " + name);
        System.out.println("Query: " + query);
        System.out.println(" ");

        return true;
    }

    /**
     * This method formats the result so that all columns from the result are shown.
     *
     * @param result  the query result.
     * @param columns how many columns the query result has.
     * @return the formatted text for 1 row of the result.
     * @throws SQLException if the result formatting has failed.
     */
    public static String formatResult(ResultSet result, int columns) throws SQLException {
        StringBuilder formatted_result = new StringBuilder(" | ");
        try {
            for (int i = 1; i <= columns; i++) {

                if (result == null ){
                    return null;
                }

                String value = result.getString(i);

                if (value.isEmpty()) {
                    return null;
                }

                formatted_result.append(value);
                formatted_result.append(" | ");
            }
            return formatted_result.toString();
        } catch (SQLException e) {
            throw new SQLException("Formatting Query Result Failed");
        }
    }
}
