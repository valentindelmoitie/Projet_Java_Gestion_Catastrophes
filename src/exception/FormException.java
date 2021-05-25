package exception;

public class FormException extends Exception {
    private String errorMessage;

    public FormException(String error) {
        this.errorMessage = error;
    }

    public String getMessage() {
        return errorMessage;
    }
}
