package business;

import dataAccess.DisasterDBAccess;
import dataAccess.RegionDBAccess;
import dataAccess.RegionDataAccess;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import java.util.ArrayList;

public class RegionManager {

    private RegionDataAccess dao;

    public RegionManager() {
        setDao(new RegionDBAccess());
    }

    public ArrayList<Region> getAllRegions() throws ConnectionException, ReadingException {
        return dao.getAllRegions();
    }

    public void setDao(RegionDataAccess dao) {
        this.dao = dao;
    }
}
