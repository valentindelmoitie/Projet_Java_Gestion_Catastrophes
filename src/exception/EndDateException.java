package exception;

import java.util.GregorianCalendar;

public class EndDateException extends Exception{

    private GregorianCalendar endDate;
    private GregorianCalendar startDate;

    public EndDateException(GregorianCalendar endDate, GregorianCalendar startDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public String getMessage(){
        return "La date de fin doit être plus tardive ou égale à la date de début";
    }
}
