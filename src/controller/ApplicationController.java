package controller;

import business.*;
import exception.AddDisasterException;
import exception.CommunicationException;
import exception.DeleteDisasterException;
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

    public ArrayList<Disaster> getAllDisaster() throws CommunicationException, ReadingException {
        return disasterManager.getAllDisasters();
   }

    public ArrayList<Region> getAllRegion() throws CommunicationException, ReadingException{
        return regionManager.getAllRegions();
   }

    public int addDisaster(Disaster disaster) throws CommunicationException, AddDisasterException {
        return disasterManager.addDisaster(disaster);
   }

    public int deleteDisasters(ArrayList<Disaster> disasters) throws CommunicationException, DeleteDisasterException{
        return disasterManager.deleteDisasters(disasters);
    }

    public void setDisasterManager(DisasterManager disasterManager) {
        this.disasterManager = disasterManager;
    }

    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }



}
