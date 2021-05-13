package exception;

import model.Region;

import java.util.ArrayList;

public class DisasterMiscException extends Exception{

    private String userString;
    private String formFieldName;
    private Integer impactedPeople;
    private Integer minimumImpactedPeople;
    private Integer valueNotInRange;
    private ArrayList<Region> regions;

    public DisasterMiscException(String type, String formFieldName) {
        this.userString = type;
        this.formFieldName = formFieldName;
    }

    public DisasterMiscException(Integer impactedPeople, Integer minimumImpactedPeople) {
        this.impactedPeople = impactedPeople;
        this.minimumImpactedPeople = minimumImpactedPeople;
    }

    public DisasterMiscException(Integer minValue) {
        this.valueNotInRange = minValue;
    }

    public DisasterMiscException(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public String getMessage(){
        if(userString != null && formFieldName!= null)
            if(userString.isBlank())
                return "Une chaîne de caractère vide n'est pas une entrée valide pour " + formFieldName;
                else
                 return userString + " n'est pas une chaîne de caractère valide pour " + formFieldName;
        if(valueNotInRange != null)
            return valueNotInRange + " n'est pas valeur acceptée";
        if(impactedPeople != null & minimumImpactedPeople != null)
            return "Le nombre de personnes impactées (" + impactedPeople + ") ne peut pas être inférieur" +
                    " au nombre de victimes directes et indirectes cumulées : (" + minimumImpactedPeople + ')';
        if(regions != null)
            return "Il faut au moins ajouter une  région à la catastrophe";
        return "Une erreur est survenue lors de l'appel de l'exception\n" +
                "Message : Paramètres manquants lors de l'appel au constructeur de l'exception";
    }
}
