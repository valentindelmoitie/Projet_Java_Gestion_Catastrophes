package dataAccess;

import exception.*;
import model.DangerousSite;
import model.Disaster;
import model.DisasterOnDangerousSite;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException;

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException;

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    public int modifyDisaster(Disaster disaster) throws CommunicationException, ModifyException;

    public ArrayList<DisasterOnDangerousSite> getDangerousSitesByDisaster(DangerousSite dangerousSite) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

}

