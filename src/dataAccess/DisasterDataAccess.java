package dataAccess;

import exception.AddDisasterException;
import exception.CommunicationException;
import exception.DeleteDisasterException;
import exception.ReadingException;
import model.Disaster;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException;

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException;

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException;

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException;
}
