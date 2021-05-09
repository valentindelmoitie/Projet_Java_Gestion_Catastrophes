package dataAccess;

import exception.AddDisasterException;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws ConnectionException, ReadingException;

    public int addDisaster(Disaster disaster) throws ConnectionException, AddDisasterException;
}
