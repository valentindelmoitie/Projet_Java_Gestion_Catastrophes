package dataAccess.dataAccessInterfaces;

import exception.CommunicationException;
import exception.ReadingException;
import model.PopulationData;
import model.Region;
import model.SearchByRegionAndType;

import java.util.ArrayList;

public interface RegionDataAccess {
    ArrayList<Region> getAllRegions() throws CommunicationException, ReadingException;

    PopulationData getPercentageOfPopulationOfRegionImpactedByType(SearchByRegionAndType search) throws CommunicationException, ReadingException;

    ArrayList<Region> getRegionsImpactedBy (int disasterId) throws CommunicationException, ReadingException;
}
