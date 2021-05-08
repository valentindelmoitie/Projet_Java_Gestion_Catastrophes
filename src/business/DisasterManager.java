package business;

import dataAccess.DisasterDBAccess;
import dataAccess.DisasterDataAccess;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;

import java.util.ArrayList;

public class DisasterManager {
    //TACHE CRUD
    //VERIFICATION DONNEES FORMULAIRES CRUD ICI

    private DisasterDataAccess dao;

    public DisasterManager() {
        setDao(new DisasterDBAccess());
    }

    public void setDao(DisasterDBAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException{
        return dao.getAllDisaster();
    }
}
