package business;

import dataAccess.CountryDBAccess;
import dataAccess.CountryDataAccess;
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

    public void setDao(CountryDataAccess dao) {
        this.dao = dao;
    }
}