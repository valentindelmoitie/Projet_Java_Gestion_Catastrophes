package business;

import dataAccess.RegionDBAccess;
import dataAccess.RegionDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.PopulationData;
import model.SearchByRegionAndTypes;

public class BusinessTaskManager {
    private RegionDataAccess dao;

    public BusinessTaskManager() {
        setDao(new RegionDBAccess());
    }

    public Double getPourcOfPopulationOfRegionImpactedByType(SearchByRegionAndTypes search) throws CommunicationException, ReadingException {
        PopulationData data =  dao.getPourcOfPopulationOfRegionImpactedByType(search);
        Double pourc = calculatePourc(data.getTotalPopulation(), data.getImpactedPeople());
        return pourc;
    }

    private Double calculatePourc(int totalPopulation, int concernedPopulation){
        System.out.println("population " + totalPopulation);
        System.out.println("concerned population " + concernedPopulation);

        if(totalPopulation == 0) return 0.0;
        return ((double)concernedPopulation / totalPopulation) * 100;
    }

    public void setDao(RegionDataAccess dao) {
    this.dao = dao;
    }
}
