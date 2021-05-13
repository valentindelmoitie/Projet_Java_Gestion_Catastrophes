package exception;

public class ModifyException extends Exception {
    private String errorMessage;

    public ModifyException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return "Une erreur est survenue en tentant de modifier le désastre\nMessage d'erreur complet : " + errorMessage;
    }
}
