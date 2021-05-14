package business;

import dataAccess.RegionDBAccess;
import dataAccess.RegionDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.SearchByRegionAndTypes;

public class BusinessTaskManager {
    // Gestion tâche métier
    private RegionDataAccess dao;

    public BusinessTaskManager() {
        setDao(new RegionDBAccess());
    }


    public Double getPourcOfPopulationOfRegionImpactedByType(SearchByRegionAndTypes search) throws CommunicationException, ReadingException {
        return dao.getPourcOfPopulationOfRegionImpactedByType(search);
    }


    public void setDao(RegionDataAccess dao) {
    this.dao = dao;
    }
}
