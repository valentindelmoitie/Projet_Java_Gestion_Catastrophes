package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.Country;
import model.Disaster;

import java.util.ArrayList;

public interface CountryDataAccess {

    public ArrayList<Country> getAllCountries() throws CommunicationException, ReadingException;

    ArrayList<Country> getCountriesImpactedBy(int disasterId) throws CommunicationException, ReadingException ;
}
