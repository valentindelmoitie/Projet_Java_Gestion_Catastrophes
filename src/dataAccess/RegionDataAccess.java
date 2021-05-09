package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.Region;

import java.util.ArrayList;

public interface RegionDataAccess {
    public ArrayList<Region> getAllRegions() throws ConnectionException, ReadingException;
}
