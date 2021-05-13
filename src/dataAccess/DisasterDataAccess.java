package dataAccess;

import exception.*;
import model.Disaster;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException;

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException;

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    public void modifyDisaster(Disaster disaster) throws CommunicationException, ModifyException;
}

