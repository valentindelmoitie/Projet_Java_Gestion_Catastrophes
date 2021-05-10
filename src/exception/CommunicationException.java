package exception;

public class CommunicationException extends Exception {

    private String errorMessage;

    public CommunicationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return "Il y a une erreur lors de l'initialisation des communications avec le stockage des données\n" +
                "Message d'erreur complet : " + errorMessage;
    }
}
