package business;

import dataAccess.DisasterDBAccess;
import dataAccess.DisasterDataAccess;
import exception.AddDisasterException;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;

import java.util.ArrayList;

public class DisasterManager {

    private DisasterDataAccess dao;

    public DisasterManager() {
        setDao(new DisasterDBAccess());
    }

    public void setDao(DisasterDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Disaster> getAllDisasters() throws ConnectionException, ReadingException{
        return dao.getAllDisasters();
    }

    public int addDisaster(Disaster disaster) throws ConnectionException, AddDisasterException {
        return dao.addDisaster(disaster);
    }
}
