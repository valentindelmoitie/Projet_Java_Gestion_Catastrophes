package business;

import dataAccess.DisasterDBAccess;
import dataAccess.DisasterDataAccess;
import exception.*;
import model.Disaster;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public class DisasterSearchManager {

    DisasterDataAccess dao;

    public DisasterSearchManager() {
        setDao(new DisasterDBAccess());
    }

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException {
            return dao.getDisastersByCountryBetweenDates(searchParams);
    }

    public void setDao(DisasterDataAccess dao) {
        this.dao = dao;
    }
}
