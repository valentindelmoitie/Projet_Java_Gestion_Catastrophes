package dataAccess;

import exception.AddDisasterException;
import exception.ConnectionException;
import exception.ReadingException;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DisasterDBAccess implements  DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws ConnectionException, ReadingException {
        ArrayList<Disaster> allDisasters;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction =
                "select d.id, d.impacted_people, d.direct_casualties, d.indirect_casualties, d.type, " +
                        "d.description, d.date, d.is_natural, d.end_date, d.name,d.intensity, l.Region " +
                        "from disaster d join impact_location l " +
                        "on d.id = l.disaster";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            allDisasters = new ArrayList<>();

            while (data.next()) {
                // MODIFIER EN GREGORIAN CALENDAR
                Disaster disaster = null;
                int disasterId = data.getInt("id");

                if (allDisasters.size() == 0 || disasterId != allDisasters.get(allDisasters.size() - 1).getId()) {

                    GregorianCalendar date = new GregorianCalendar();
                    date.setTime(data.getDate("date"));
                    disaster = new Disaster(disasterId, data.getInt("impacted_people"),
                            data.getInt("direct_casualties"), data.getInt("indirect_casualties"),
                            data.getString("type"), data.getString("description"), date,
                            data.getBoolean("is_natural"), new ArrayList<Region>());

                    Date endDateSQL = data.getDate("end_date");
                    if (!data.wasNull()) {
                        GregorianCalendar endDateGregorian = new GregorianCalendar();
                        endDateGregorian.setTime(endDateSQL);
                        disaster.setEndDate(endDateGregorian);
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
                } else {
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

    public int addDisaster(Disaster disaster)  throws ConnectionException, AddDisasterException {
        Connection connection = SingletonConnection.getInstance();

        String sqlInstructionDisaster = "insert into disaster (`type`,`description`,`date`, impacted_people," +
                "direct_casualties,indirect_casualties,is_natural, id) values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstructionDisaster);

            preparedStatement.setString(1,disaster.getType());
            preparedStatement.setString(2,disaster.getDescription());
            java.sql.Date sqlDate = new Date(disaster.getDate().getTimeInMillis());
            preparedStatement.setDate(3,sqlDate);
            preparedStatement.setInt(4,disaster.getImpactedPeople());
            preparedStatement.setInt(5,disaster.getDirectCasualties());
            preparedStatement.setInt(6,disaster.getIndirectCasualties());
            preparedStatement.setBoolean(7, disaster.getNatural());
            preparedStatement.setInt(8, disaster.getId());

            int nbInsert = preparedStatement.executeUpdate();

            if(disaster.getName() != null){
                String sqlStatement = "update disaster set name = ? where id = ?";
                PreparedStatement statement = connection.prepareStatement(sqlStatement);
                statement.setString(1,disaster.getName());
                statement.setInt(2,disaster.getId());
                statement.executeUpdate();
            }

            if(disaster.getIntensity() != null){
                String sqlStatement = "update disaster set intensity = ? where id = ?";
                PreparedStatement statement = connection.prepareStatement(sqlStatement);
                statement.setInt(1,disaster.getIntensity());
                statement.setInt(2,disaster.getId());
                statement.executeUpdate();
            }

            if(disaster.getEndDate() != null){
                String sqlStatement = "update disaster set end_Date = ? where id = ?";
                PreparedStatement statement = connection.prepareStatement(sqlStatement);
                java.sql.Date sqlEndDate = new Date(disaster.getEndDate().getTimeInMillis());
                statement.setDate(1, sqlEndDate);
                statement.setInt(2,disaster.getId());
                statement.executeUpdate();
            }
            return nbInsert;
        }catch (SQLException exception){
            throw new AddDisasterException(exception.getMessage());
        }
    }
}
