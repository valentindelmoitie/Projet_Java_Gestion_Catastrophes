package dataAccess;

import exception.*;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DisasterDBAccess implements  DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException {
        ArrayList<Disaster> allDisasters;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction =
                "select d.id, d.impacted_people, d.direct_casualties, d.indirect_casualties, d.type, " +
                        "d.description, d.date, d.is_natural, d.end_date, d.name,d.intensity, l.Region " +
                        "from disaster d join impact_location l " +
                        "on d.id = l.disaster order by id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            allDisasters = new ArrayList<>();

            while (data.next()) {
                // MODIFIER EN GREGORIAN CALENDAR
                Disaster disaster = null;
                int disasterId = data.getInt("id");

                if (allDisasters.size() == 0 || disasterId != allDisasters.get(allDisasters.size() - 1).getId()) {

                    Date dateSQL = data.getDate("date");
                    GregorianCalendar dateGregorian = new GregorianCalendar();
                    dateGregorian.setTime(dateSQL);
                    //dateGregorian.add(Calendar.MONTH, 1);

                    ArrayList<Region> regions = new ArrayList<>();
                    regions.add(new Region(data.getString("region")));

                    disaster = new Disaster(disasterId, data.getInt("impacted_people"),
                            data.getInt("direct_casualties"), data.getInt("indirect_casualties"),
                            data.getString("type"), data.getString("description"), dateGregorian,
                            data.getBoolean("is_natural"), regions);

                    Date endDateSQL = data.getDate("end_date");
                    if (!data.wasNull()) {
                        GregorianCalendar endDateGregorian = new GregorianCalendar();
                        endDateGregorian.setTime(endDateSQL);
                        //endDateGregorian.add(Calendar.MONTH, 1);
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

    public int addDisaster(Disaster disaster)  throws CommunicationException, AddDisasterException {
        Connection connection = SingletonConnection.getInstance();

        String sqlInstructionDisaster = "insert into disaster (`type`,`description`,`date`, impacted_people,"
                + "direct_casualties,indirect_casualties,is_natural, id) values(?, ?, ?, ?, ?, ?, ?, ?);";

        String sqlImpactLocation = "insert into impact_location (disaster, region) values(?, ?);";

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

            preparedStatement = connection.prepareStatement(sqlImpactLocation);
            preparedStatement.setInt(1,disaster.getId());
            for (Region region : disaster.getRegions()) {
                preparedStatement.setString(2, region.getName());
                preparedStatement.executeUpdate();
            }


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

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException {

        Connection connection = SingletonConnection.getInstance();

        String sqlInstructionImpactLocation = "delete from impact_location where disaster = ?;";
        String sqlInstructionDanger = "delete from danger where disaster = ?;";
        String sqlInstructionHelp = "delete from help where disaster = ?;";
        String sqlInstructionDisaster = "delete from disaster where id = ?;";
        int nbDeletion = 0;
        try{
            for(Disaster disaster : disasters) {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInstructionImpactLocation);
                preparedStatement.setInt(1, disaster.getId());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(sqlInstructionDanger);
                preparedStatement.setInt(1, disaster.getId());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(sqlInstructionHelp);
                preparedStatement.setInt(1, disaster.getId());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(sqlInstructionDisaster);
                preparedStatement.setInt(1,disaster.getId());
                nbDeletion += preparedStatement.executeUpdate();
            }
            return nbDeletion;
        }catch(SQLException exception){
            throw new DeleteDisasterException(exception.getMessage());
        }
    }

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException {
        ArrayList<Disaster> disasters;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select distinct d.id, d.impacted_people, d.direct_casualties, d.indirect_casualties, " +
                "d.type, d.description, d.date, d.is_natural, d.end_date, d.name,d.intensity, l.region " +
                "from disaster d " +
                "join impact_location i on d.id =  i.disaster " +
                "join region r on i.region = r.name " +
                "join location l on r.name = l.region " +
                "where d.date between ? and ? and l.country = ? order by id;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            java.sql.Date sqlStartDate = new Date(searchParams.getStartDate().getTimeInMillis());
            java.sql.Date sqlEndDate = new Date(searchParams.getEndDate().getTimeInMillis());
            preparedStatement.setDate(1,sqlStartDate);
            preparedStatement.setDate(2,sqlEndDate);
            preparedStatement.setString(3,searchParams.getCountry().getName());

            ResultSet data = preparedStatement.executeQuery();

            disasters = new ArrayList<>();

            while (data.next()) {

                Disaster disaster = null;
                int disasterId = data.getInt("id");

                if (disasters.size() == 0 || disasterId != disasters.get(disasters.size() - 1).getId()) {


                    GregorianCalendar date = new GregorianCalendar();
                    date.setTime(data.getDate("date"));

                    ArrayList<Region> regions = new ArrayList<>();
                    regions.add(new Region(data.getString("region")));

                    disaster = new Disaster(disasterId, data.getInt("impacted_people"),
                            data.getInt("direct_casualties"), data.getInt("indirect_casualties"),
                            data.getString("type"), data.getString("description"), date,
                            data.getBoolean("is_natural"), regions);

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

                    //disaster.addRegion(new Region(data.getString("region")));
                } else {
                    disasters.get(disasters.size() - 1).addRegion(new Region(data.getString("region")));
                }

                if (disaster != null)
                    disasters.add(disaster);
            }

        } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
        return disasters;
    }

    public ArrayList<DisasterOnDangerousSite> getDangerousSitesByDisaster(DangerousSite dangerousSite) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException{
        ArrayList<DisasterOnDangerousSite> disasters;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select di.*, r.name, r.population, r.is_warzone\n" +
                "from disaster di join danger da  on di.id = da.disaster\n" +
                "join dangerous_site ds on da.dangerous_site = ds.id\n" +
                "join region r on r.name = ds.region\n" +
                "where ds.id = ? and ds.type = ? and ds.region = ? order by di.id;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, dangerousSite.getId());
            preparedStatement.setString(2, dangerousSite.getType());
            preparedStatement.setString(3,dangerousSite.getRegion());

            ResultSet data = preparedStatement.executeQuery();
            disasters = new ArrayList<>();

            while (data.next()){
                DisasterOnDangerousSite disaster;

                GregorianCalendar date = new GregorianCalendar();
                date.setTime(data.getDate("date"));

                disaster = new DisasterOnDangerousSite(data.getInt("id"),data.getString("type"),date, data.getInt("impacted_people"),
                        data.getInt("direct_casualties"), data.getInt("indirect_casualties"),
                        data.getBoolean("is_natural"), new Region(data.getInt("population"),data.getString("name"),data.getBoolean("is_warzone")));

                Integer intensity = data.getInt("intensity");
                if (!data.wasNull()) {
                    disaster.setIntensity(intensity);
                }
                disasters.add(disaster);
            }

        }catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
        return disasters;
    }


    public void modifyDisaster(Disaster disaster) throws CommunicationException { // Il faut remonter une ModifyException
        Connection connection = SingletonConnection.getInstance();

        String sqlInstructionImpactLocation =
                "update disaster" +
                " set name =  ?, type = ?, description = ?, date = ?, end_date = ?, intensity = ?, impacted_people = ?, direct_casualties = ?," +
                " indirect_casualties = ?, is_natural = ?" +
                " where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstructionImpactLocation);
            preparedStatement.setString(1, disaster.getName());
            preparedStatement.setString(2,disaster.getType());
            preparedStatement.setString(3, disaster.getDescription());

            java.sql.Date sqlDate = new java.sql.Date(disaster.getDate().getTimeInMillis());
            preparedStatement.setDate(4, sqlDate);
            java.sql.Date sqlEndDate = new java.sql.Date(disaster.getEndDate().getTimeInMillis());
            preparedStatement.setDate(5, sqlEndDate);

            preparedStatement.setInt(6, disaster.getIntensity());
            preparedStatement.setInt(7, disaster.getImpactedPeople());
            preparedStatement.setInt(8, disaster.getDirectCasualties());
            preparedStatement.setInt(9, disaster.getIndirectCasualties());
            preparedStatement.setBoolean(10, disaster.getNatural());
            preparedStatement.setInt(11, disaster.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage(); //Throw new ModifyException ici
        }
    }
}
