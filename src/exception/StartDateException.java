package exception;

public class StartDateException extends Exception{

    public String getMessage(){
        return "La date de début ne peut pas être supérieure à la date du jour.";
    }
}
