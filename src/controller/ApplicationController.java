package controller;

import business.*;
import exception.ConnectionException;
import exception.ReadingException;
import model.Disaster;
import model.Region;

import java.util.ArrayList;

public class ApplicationController {

    // Lien entre interface et le reste
    // Redirige les requetes venant de view (objet book) vers les autres méthodes dans Business
    //Securité en plus mais rien cette année dans ce projet

    // BEaucoup de délégation ici (appel vers des méthodes business)

    private DisasterManager disasterManager;
    private RegionManager regionManager;

    public ApplicationController() {
        setDisasterManager(new DisasterManager());
        setRegionManager(new RegionManager());
    }

    public ArrayList<Disaster> getAllDisaster() throws ConnectionException, ReadingException {
        return disasterManager.getAllDisaster();
   }

   public ArrayList<Region> getAllRegion() throws ConnectionException, ReadingException{
        return regionManager.getAllRegion();
   }

    public void setDisasterManager(DisasterManager disasterManager) {
        this.disasterManager = disasterManager;
    }

    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }
}
