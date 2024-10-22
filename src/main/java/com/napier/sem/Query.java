package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {

    public static void run_query(Connection connection, String query, int columns)
    {
        try {
            var statement = connection.prepareStatement(query);
            var result = statement.executeQuery();

            while (result.next()) {
                System.out.println(format_result(result, columns));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String format_result(ResultSet result, int columns) throws SQLException {
        StringBuilder formatted_result = new StringBuilder(" | ");

        for (int i = 1; i <= columns; i++)
        {
            formatted_result.append(result.getString(i));
            formatted_result.append(" | ");
        }

        return formatted_result.toString();
    }
}
