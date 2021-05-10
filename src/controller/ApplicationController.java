package controller;

import business.*;
import exception.AddDisasterException;
import exception.CommunicationException;
import exception.DeleteDisasterException;
import exception.ReadingException;
import model.Country;
import model.Disaster;
import model.Region;
import model.SearchDisasterByCountryAndDates;

import java.util.ArrayList;

public class ApplicationController {

    private DisasterManager disasterManager;
    private RegionManager regionManager;
    private CountryManager countryManager;
    private DisasterSearchManager disasterSearchManager;

    public ApplicationController() {
        setDisasterManager(new DisasterManager());
        setRegionManager(new RegionManager());
        setCountryManager(new CountryManager());
        setDisasterSearchManager(new DisasterSearchManager());
    }

    public ArrayList<Disaster> getAllDisaster() throws CommunicationException, ReadingException {
        return disasterManager.getAllDisasters();
   }

    public ArrayList<Region> getAllRegion() throws CommunicationException, ReadingException{
        return regionManager.getAllRegions();
   }

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException {
        return disasterManager.addDisaster(disaster);
   }

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException{
        return disasterManager.deleteDisasters(disasters);
    }

    public ArrayList<Country> getAllCountries() throws CommunicationException, ReadingException{
        return countryManager.getAllCountries();
    }

    public ArrayList<Disaster> getDisastersByCountryBetweenDates(SearchDisasterByCountryAndDates searchParams) throws CommunicationException, ReadingException{
        return disasterSearchManager.getDisastersByCountryBetweenDates(searchParams);
    }

    public void setDisasterManager(DisasterManager disasterManager) {
        this.disasterManager = disasterManager;
    }

    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    public void setCountryManager(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    public void setDisasterSearchManager(DisasterSearchManager disasterSearchManager) {
        this.disasterSearchManager = disasterSearchManager;
    }
}
