package exception;

public class ReadingException extends Exception {
    public ReadingException(String message) {
        super(message);
    }

    //Dire qu'il y a eu une erreur lors de la lecture + message => + clean code ? /!\ Pas de référence à bdd
}
