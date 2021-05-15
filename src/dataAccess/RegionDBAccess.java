package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.Country;
import model.PopulationData;
import model.Region;
import model.SearchByRegionAndType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegionDBAccess implements RegionDataAccess {
    public ArrayList<Region> getAllRegions() throws CommunicationException, ReadingException {
        ArrayList<Region> regions;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select * from region;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            regions = new ArrayList<>();

            while(data.next()){
                Region region = new Region(data.getInt("population"),
                        data.getString("name"),data.getBoolean("is_warzone"));
                regions.add(region);
            }

        } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
        return regions;
    }

    public PopulationData getPercentageOfPopulationOfRegionImpactedByType(SearchByRegionAndType search) throws CommunicationException, ReadingException {
        PopulationData popData = null;
        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select d.impacted_people, sum(r.population) from region r join impact_location l on r.name = l.region\n" +
                "join disaster d on l.disaster = d.id\n" +
                "where d.id in (\n" +
                "select d.id \n" +
                "from region r join impact_location l on r.name = l.region\n" +
                "join disaster d on l.disaster = d.id\n" +
                "where r.name = ? and d.type = ?);";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setString(1,search.getRegionName());
            preparedStatement.setString(2,search.getType());
            ResultSet data = preparedStatement.executeQuery();
            while(data.next()) {
                popData = new PopulationData(data.getInt(2),data.getInt(1));
            }

        }catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
        return popData;
    }

    public ArrayList<Region> getRegionsImpactedBy (int disasterId) throws CommunicationException, ReadingException {
        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction =
                "select r.name 'region_name', r.population, r.is_warzone, c.name 'country_name'\n" +
                "from disaster d, impact_location il, region r, location l , country c\n" +
                "where d.id = ? \n" +
                "and d.id = il.disaster\n" +
                "and il.region = r.name\n" +
                "and r.name = l.region\n" +
                "and l.country = c.name;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setInt(1, disasterId);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Region> regions = new ArrayList<>();

            while (data.next()) {
                Region region = new Region(data.getInt("population"), data.getString("region_name"), data.getBoolean("is_warzone"));
                region.setCountry(new Country(data.getString("country_name")));
                regions.add(region);
            }

            return regions;
        } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
    }
}
