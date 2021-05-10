package exception;

public class AddDisasterException extends Exception{

    private String errorMessage;

    public AddDisasterException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return "Une erreur est survenue en tentant d'ajouter le désastre\nMessage d'erreur complet : "
                + errorMessage ;
    }
}
