package exception.unusedExceptionSave;

public class NumberOfPeopleException extends Exception{

    private Integer numberOfPeople;

    public NumberOfPeopleException(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getMessage(){
        return numberOfPeople + "n'est pas valeur acceptée (doit être au minimum égal à 0)";
    }
}
