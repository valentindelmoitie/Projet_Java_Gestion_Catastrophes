package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.Region;

import java.util.ArrayList;

public interface RegionDataAccess {
    public ArrayList<Region> getAllRegions() throws CommunicationException, ReadingException;
}
