package exception.unusedExceptionSave;

public class ImpactedPeopleException extends Exception{

    private Integer impactedPeople;
    private Integer minimumImpactedPeople;

    public ImpactedPeopleException(Integer impactedPeople, Integer directCasualties, Integer indirectCasualties) {
        this.impactedPeople = impactedPeople;
        this.minimumImpactedPeople = directCasualties + indirectCasualties;
    }

    public String getMessage(){
        return "Le nombre de personnes impactées (" + impactedPeople +
                ") ne peut pas inférieur au nombre de victimes directes et indirectes cumulées : (" +
                minimumImpactedPeople + ")";
    }
}
