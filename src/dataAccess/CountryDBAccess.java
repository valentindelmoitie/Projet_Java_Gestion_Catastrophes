package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.Country;
import model.Disaster;
import model.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess {

    public ArrayList<Country> getAllCountries() throws CommunicationException, ReadingException {
        ArrayList<Country> countries;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select * from country;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            countries = new ArrayList<>();

            while(data.next()){
                Country country = new Country(data.getString("name"), data.getBoolean("is_underdeveloped"),data.getBoolean("is_in_war"));
                countries.add(country);
            }

        } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
        return countries;
    }

    public ArrayList<Country> getCountriesImpactedBy(int disasterId) throws CommunicationException, ReadingException {
        ArrayList<Country> countries;

        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction =
                "select distinct c.name\n" +
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

            countries = new ArrayList<>();

            while(data.next()) {
                Country country = new Country(data.getString("name"));
                countries.add(country);
            }

            return countries;
        } catch (SQLException exception) {
            throw new ReadingException(exception.getMessage());
        }
    }
}

