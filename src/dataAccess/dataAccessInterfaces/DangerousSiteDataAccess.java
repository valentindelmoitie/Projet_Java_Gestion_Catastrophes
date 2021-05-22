package dataAccess.dataAccessInterfaces;

import exception.CommunicationException;
import exception.ReadingException;
import model.DangerousSite;

import java.util.ArrayList;

public interface DangerousSiteDataAccess {

    ArrayList<DangerousSite> getAllDangerousSites() throws CommunicationException, ReadingException;
}
