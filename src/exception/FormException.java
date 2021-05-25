package exception;

public class FormException extends Exception {
    private String error;

    public FormException(String error) {
        this.error = error;
    }

    public String getMessage() {
        return error;
    }
}
