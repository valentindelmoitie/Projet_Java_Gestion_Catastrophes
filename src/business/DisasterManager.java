package business;

import dataAccess.DisasterDBAccess;
import dataAccess.DisasterDataAccess;
import exception.*;
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

    public ArrayList<Disaster> getAllDisasters() throws CommunicationException, ReadingException, DisasterMiscException, EndDateException, StartDateException{
            return dao.getAllDisasters();
    }

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException {
        return dao.addDisaster(disaster);
    }

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException{
        return dao.deleteDisasters(disasters);
    }

    public int modifyDisaster(Disaster disaster) throws CommunicationException, ModifyException {
        return dao.modifyDisaster(disaster);
    }
}
