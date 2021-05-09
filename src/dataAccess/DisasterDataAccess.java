package dataAccess;

import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws ConnectionException, ReadingException;
}
