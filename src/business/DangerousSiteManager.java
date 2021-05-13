package business;

import dataAccess.DangerousSiteDBAccess;
import dataAccess.DangerousSiteDataAccess;
import exception.CommunicationException;
import exception.ReadingException;
import model.DangerousSite;

import java.util.ArrayList;

public class DangerousSiteManager implements DangerousSiteDataAccess {

    private DangerousSiteDataAccess dao;

    public DangerousSiteManager() {
        setDao(new DangerousSiteDBAccess());
    }

    public ArrayList<DangerousSite> getAllDangerousSites() throws CommunicationException, ReadingException{
        return dao.getAllDangerousSites();
    }

    public void setDao(DangerousSiteDataAccess dao) {
        this.dao = dao;
    }
}
