package business;

import dataAccess.RegionDBAccess;
import dataAccess.RegionDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.Region;

import java.util.ArrayList;

public class RegionManager {

    private RegionDataAccess dao;

    public RegionManager() {
        setDao(new RegionDBAccess());
    }

    public ArrayList<Region> getAllRegions() throws CommunicationException, ReadingException {
        return dao.getAllRegions();
    }

    public void setDao(RegionDataAccess dao) {
        this.dao = dao;
    }
}
