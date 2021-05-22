package business;

import dataAccess.dbAccess.DisasterDBAccess;
import dataAccess.dataAccessInterfaces.DisasterDataAccess;
import exception.*;
import model.DangerousSite;
import model.Disaster;
import model.DisasterOnDangerousSite;
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

    public ArrayList<DisasterOnDangerousSite> getDangerousSitesByDisaster(DangerousSite dangerousSite) throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException{
        return dao.getDangerousSitesByDisaster(dangerousSite);
    }

    public void setDao(DisasterDataAccess dao) {
        this.dao = dao;
    }
}
