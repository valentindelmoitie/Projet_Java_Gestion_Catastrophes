package dataAccess;

import exception.*;
import model.DangerousSite;
import model.Disaster;
import model.DisasterOnDangerousSite;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public interface DisasterDataAccess {
    ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException;

    int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException;

    ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException;

    int modifyDisaster(Disaster disaster) throws CommunicationException, ModifyException;

    ArrayList<DisasterOnDangerousSite> getDangerousSitesByDisaster(DangerousSite dangerousSite) throws CommunicationException, ReadingException;
}

