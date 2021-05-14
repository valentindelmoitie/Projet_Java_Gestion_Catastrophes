package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.PopulationData;
import model.Region;
import model.SearchByRegionAndType;

import java.util.ArrayList;

public interface RegionDataAccess {
    public ArrayList<Region> getAllRegions() throws CommunicationException, ReadingException;

    public PopulationData getPourcOfPopulationOfRegionImpactedByType(SearchByRegionAndType search) throws CommunicationException, ReadingException;

    public ArrayList<Region> getRegionsImpactedBy (int disasterId) throws CommunicationException, ReadingException;

}
