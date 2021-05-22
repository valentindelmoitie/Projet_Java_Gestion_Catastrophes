package dataAccess.dbAccess;

import dataAccess.dataAccessInterfaces.DangerousSiteDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.DangerousSite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DangerousSiteDBAccess implements DangerousSiteDataAccess {

    public ArrayList<DangerousSite> getAllDangerousSites() throws CommunicationException, ReadingException {
        ArrayList<DangerousSite> allDangerousSites;
        Connection connection = SingletonConnection.getInstance();

        String sqlInstruction = "select * from dangerous_site;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            allDangerousSites = new ArrayList<>();
            while(data.next()){
                DangerousSite dangerousSite = new DangerousSite(data.getInt("id"),
                        data.getString("type"), data.getString("description"),
                        data.getString("manager"), data.getString("region"));
                allDangerousSites.add(dangerousSite);
            }

        } catch(SQLException exception){
            throw new ReadingException(exception.getMessage());
        }
        return allDangerousSites;
    }
}
