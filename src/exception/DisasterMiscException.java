package exception;

public class DisasterMiscException extends Exception{

    private String type;
    private Integer impactedPeople;
    private Integer minimumImpactedPeople;
    private Integer numberOfPeople;

    public DisasterMiscException(String type) {
        this.type = type;
    }

    public DisasterMiscException(Integer impactedPeople, Integer minimumImpactedPeople) {
        this.impactedPeople = impactedPeople;
        this.minimumImpactedPeople = minimumImpactedPeople;
    }

    public DisasterMiscException(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getMessage(){
        if(type != null)
            return type + " n'est pas un type valide de catastrophe";
        if(numberOfPeople != null)
            return numberOfPeople + " n'est pas valeur acceptée (doit être >= à 0)";
        if(impactedPeople != null & minimumImpactedPeople != null)
            return "Le nombre de personnes impactées (" + impactedPeople + ") ne peut pas inférieur" +
                    " au nombre de victimes directes et indirectes cumulées : (" + minimumImpactedPeople + ')';

        return "Une erreur est survenue lors de l'appel de l'exception\n" +
                "Message : Paramètres manquants lors de l'appel au constructeur de l'exception";
    }
}
