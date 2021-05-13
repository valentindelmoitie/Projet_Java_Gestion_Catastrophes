package dataAccess;

import exception.CommunicationException;
import exception.ReadingException;
import model.DangerousSite;

import java.util.ArrayList;

public interface DangerousSiteDataAccess {

    public ArrayList<DangerousSite> getAllDangerousSites() throws CommunicationException, ReadingException;
}
