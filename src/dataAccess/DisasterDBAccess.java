package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.*;

import java.sql.*;


import java.util.ArrayList;
import java.util.GregorianCalendar;

// Attention à retirer les static et mettre en place le DAO.
public class DisasterDBAccess {
   public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException {
       ArrayList<Disaster> allDisasters;

       Connection connection = SingletonConnection.getInstance();

       String sqlInstruction =
               "select d.id, d.impacted_people, d.direct_casualties, d.indirect_casualties, d.type, d.description, d.date, d.is_natural, d.end_date, d.name,d.intensity, l.Region " +
               "from disaster d join impact_location l " +
               "on d.id = l.disaster";

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

           ResultSet data = preparedStatement.executeQuery();

           allDisasters = new ArrayList<>();

           while(data.next()) {
               // MODIFIER EN GREGORIAN CALENDAR
               Disaster disaster = null;
               int disasterId = data.getInt("id");

               if (allDisasters.size() == 0 || disasterId != allDisasters.get(allDisasters.size() - 1).getId()) {
                   disaster = new Disaster(disasterId, data.getInt("impacted_people"), data.getInt("direct_casualties"), data.getInt("indirect_casualties"), data.getString("type"), data.getString("description"), data.getDate("date"), data.getBoolean("is_natural"), new ArrayList<Region>());

                   Date endDate = data.getDate("end_date");
                   if (!data.wasNull()) {
                       disaster.setEndDate(endDate);
                   }

                   String name = data.getString("name");
                   if (!data.wasNull()) {
                       disaster.setName(name);
                   }

                   Integer intensity = data.getInt("intensity");
                   if (!data.wasNull()) {
                       disaster.setIntensity(intensity);
                   }

                   disaster.addRegion(new Region(data.getString("region")));
               }
               else {
                   allDisasters.get(allDisasters.size() - 1).addRegion(new Region(data.getString("region")));
               }

               if (disaster != null)
                   allDisasters.add(disaster);
           }


       } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
       }

       return allDisasters;
   }
}
