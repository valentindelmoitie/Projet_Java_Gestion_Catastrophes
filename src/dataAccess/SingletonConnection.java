package dataAccess;

import exception.ConnectionException;

import java.util.*;
import java.sql.*;


public class SingletonConnection {
    private static Connection uniqueConnection;

    private SingletonConnection() throws SQLException {

    }

    public static Connection getInstance() throws ConnectionException {
        if(uniqueConnection == null) {
            try {
                uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_disasters_project","root","premier");
            }
            catch (SQLException exception) {
                throw new ConnectionException(exception.getMessage());
            }

        }

        return uniqueConnection;
    }
}
