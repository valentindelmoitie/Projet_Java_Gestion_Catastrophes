package business;

import dataAccess.dbAccess.RegionDBAccess;
import dataAccess.dataAccessInterfaces.RegionDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.PopulationData;
import model.SearchByRegionAndType;

public class BusinessTaskManager {
    private RegionDataAccess dao;

    public BusinessTaskManager() {
        setDao(new RegionDBAccess());
    }

    public Double getPercentageOfPopulationOfRegionImpactedByType(SearchByRegionAndType search) throws CommunicationException, ReadingException {
        PopulationData data =  dao.getPercentageOfPopulationOfRegionImpactedByType(search);
        return calculatePercentage(data.getTotalPopulation(), data.getImpactedPeople());
    }

    public Double calculatePercentage(int totalPopulation, int concernedPopulation){
        if(totalPopulation == 0) return 0.0;
        return ((double)concernedPopulation / totalPopulation) * 100;
    }

    public void setDao(RegionDataAccess dao) {
    this.dao = dao;
    }
}
