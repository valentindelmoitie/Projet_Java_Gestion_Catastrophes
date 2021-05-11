package exception;

public class DeleteDisasterException extends Exception{

    private String errorMessage;

    public DeleteDisasterException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return "Une erreur est survenue en tentant de supprimer le(s) désastre(s)\nMessage d'erreur complet :" + errorMessage;
    }
}
