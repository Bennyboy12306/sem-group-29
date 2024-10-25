package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contains the logic for queries and formatting the query results.
 */
public class Query {

    /**
     * This method is used to run a query and handle exceptions.
     * TODO Change this to output each query to their own file instead of printing everything to console
     * @param connection the database connection.
     * @param query the query to run.
     * @param columns how many columns this query will return (for formatting)
     */
    public static void runQuery(Connection connection, String query, int columns, String name)
    {
        System.out.println(name);
        try
        {
            var statement = connection.prepareStatement(query);
            var result = statement.executeQuery();

            while (result.next()) {
                System.out.println(formatResult(result, columns));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method formats the result so that all columns from the result are shown.
     * @param result the query result.
     * @param columns how many columns the query result has.
     * @return the formatted text for 1 row of the result.
     * @throws SQLException if the result formatting has failed.
     */
    private static String formatResult(ResultSet result, int columns) throws SQLException {
        StringBuilder formatted_result = new StringBuilder(" | ");
        try {
            for (int i = 1; i <= columns; i++) {
                formatted_result.append(result.getString(i));
                formatted_result.append(" | ");
            }

            return formatted_result.toString();
        }catch (SQLException e)
        {
            throw new SQLException("Formatting Query Result Failed");
        }
    }
}