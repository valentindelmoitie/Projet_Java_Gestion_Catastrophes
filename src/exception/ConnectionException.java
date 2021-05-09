package exception;

public class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }

    // Dire qu'il y a eu une erreur lors de la connection + renvoyer le message => Plus clean code ?
}
