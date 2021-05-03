package dataAccess;

import java.util.*;
import java.sql.*;


public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection(){
    }

    public static Connection getInstance(){
        if(connection == null) {
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_project","root","premier");
            }
            catch(SQLException exception){ //SQLException ?
                //do something with exception.getMessage()
            }
        }
        return connection;
    }
}
