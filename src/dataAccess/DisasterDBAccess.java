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
               "select d.id, d.impacted_people, d.direct_casualties, d.indirect_casualties, d.type, d.description, d.date, d.is_natural, d.end_date, d.name,d.intensity, l.Region" +
               "from disaster d join impact_location l " +
               "on d.id = l.disaster";

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

           ResultSet data = preparedStatement.executeQuery();

           Disaster disaster;
           allDisasters = new ArrayList<>();

           while(data.next()) {
               // /!\ gregorian calendar pas encore bon.
               disaster = new Disaster(data.getInt("id"), data.getInt("impacted_people"), data.getInt("direct_casualties"), data.getInt("indirect_casualties"), data.getString("type"), data.getString("description"), data.getDate("date"), data.getBoolean("is_natural"), new ArrayList<Region>());

               if (!data.wasNull()) {
                   // /!\ à modifier !!
                   disaster.setEndDate(data.getDate("end_date"));
               }

               if (!data.wasNull()) {
                   disaster.setName(data.getString("name"));
               }

               if (!data.wasNull()) {
                   disaster.setIntensity(data.getInt("intensity"));
               }

               // Ajout des régions dans l'arrayList
               //...

               allDisasters.add(disaster);
           }


       } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
       }

       return allDisasters;
   }
}
