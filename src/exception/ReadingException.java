package exception;

public class ReadingException extends Exception {

    private String errorMessage;

    public ReadingException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getMessage(){
        return "Il y a eu une erreur lors de l'accès en lecture aux données\nMessage d'erreur complet : " + errorMessage;
    }
}
