package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.*;

import java.sql.*;


import java.util.ArrayList;
import java.util.GregorianCalendar;

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
               //disaster = new Disaster(data.getInt("id"), data.getInt("impacted_people"), data.getInt("direct_casualties"), data.getInt("indirect_casualties"), data.getString("type"), data.getString("description"), new GregorianCalendar().setTime(data.getDate("date")), data.getBoolean("is_natural"), new ArrayList<Region>());
               //Disaster disaster = new Disaster(1, 200000, 50, 4000, "Nucléaire", "Accident nucléaire majeur", new GregorianCalendar(), false, new ArrayList<Region>());

           }


       } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
       }

       return allDisasters;
   }
}
