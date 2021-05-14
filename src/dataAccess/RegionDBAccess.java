package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
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

    public PopulationData getPourcOfPopulationOfRegionImpactedByType(SearchByRegionAndType search) throws CommunicationException, ReadingException {
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
}
