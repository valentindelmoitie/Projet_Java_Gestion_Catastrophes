package exception;

import java.util.GregorianCalendar;

public class EndDateException extends Exception{

    public String getMessage(){
        return "La date de fin doit être plus tardive ou égale à la date de début.";
    }
}
