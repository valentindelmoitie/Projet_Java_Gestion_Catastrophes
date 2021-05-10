package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.Region;

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
}
