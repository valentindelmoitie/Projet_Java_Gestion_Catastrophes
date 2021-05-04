package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.*;

import java.sql.*;


import java.util.ArrayList;

public class DisasterDBAccess {
   public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException {
       ArrayList<Disaster> allDisasters;

       Connection connection = SingletonConnection.getInstance();

       String sqlInstruction =
               "SELECT d.*, l.region\n" +
               "FROM disaster d\n" +
               "JOIN impact_location l\n" +
               "ON (d.id = l.disaster)"; // StringBuilder ??

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

           ResultSet data = preparedStatement.executeQuery();

           Disaster disaster;
           allDisasters = new ArrayList<>();

           while(data.next()) {
                disaster = new Disaster(data.getInt("id"), );
           }


       } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
       }


       ResultSet data = preparedStatement.executeQuery();
   }
}
