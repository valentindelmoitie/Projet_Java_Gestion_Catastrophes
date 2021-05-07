package business;

import dataAccess.DisasterDBAccess;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import java.util.ArrayList;

public class RegionManager {

    private DisasterDBAccess dao;

    public RegionManager() {
        setDao(new DisasterDBAccess());
    }

    public ArrayList<Region> getAllRegion() throws ConnectionException, ReadingException {
        return dao.getAllRegion();
    }

    public void setDao(DisasterDBAccess dao) {
        this.dao = dao;
    }
}
