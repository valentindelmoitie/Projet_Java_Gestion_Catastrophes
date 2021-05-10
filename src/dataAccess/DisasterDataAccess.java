package dataAccess;

import exception.AddDisasterException;
import exception.CommunicationException;
import exception.ReadingException;
import model.Disaster;

import java.util.ArrayList;

public interface DisasterDataAccess {
    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException;

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException;
}
