package controller;

import business.*;
import exception.AddDisasterException;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import java.util.ArrayList;

public class ApplicationController {

    private DisasterManager disasterManager;
    private RegionManager regionManager;

    public ApplicationController() {
        setDisasterManager(new DisasterManager());
        setRegionManager(new RegionManager());
    }

    public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException {
        return disasterManager.getAllDisasters();
   }

   public ArrayList<Region> getAllRegion() throws ConnectionException, ReadingException{
        return regionManager.getAllRegions();
   }

   public int addDisaster(Disaster disaster) throws ConnectionException, AddDisasterException {
        return disasterManager.addDisaster(disaster);
   }

    public void setDisasterManager(DisasterManager disasterManager) {
        this.disasterManager = disasterManager;
    }

    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }
}
