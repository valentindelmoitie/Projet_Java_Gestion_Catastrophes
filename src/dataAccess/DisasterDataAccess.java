package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException;

    public ArrayList<Region> getAllRegion() throws ConnectionException, ReadingException;
}
