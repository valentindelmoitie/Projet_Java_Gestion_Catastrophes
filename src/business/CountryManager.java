package business;

import dataAccess.dbAccess.CountryDBAccess;
import dataAccess.dataAccessInterfaces.CountryDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.Country;

import java.util.ArrayList;

public class CountryManager {

    private CountryDataAccess dao;

    public CountryManager(){
        setDao(new CountryDBAccess());
    }

    public ArrayList<Country> getAllCountries() throws CommunicationException, ReadingException{
        return dao.getAllCountries();
    }

    public ArrayList<Country> getCountriesImpactedBy(int disasterId) throws CommunicationException, ReadingException {
        return dao.getCountriesImpactedBy(disasterId);
    }

    public void setDao(CountryDataAccess dao) {
        this.dao = dao;
    }
}
