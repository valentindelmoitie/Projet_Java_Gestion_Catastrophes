package exception;

public class StartDateException extends Exception{

    public String getMessage(){
        return "La date de début ne peut pas être supérieur à la date du jour";
    }
}
