package exception;

import javax.swing.*;

public class SelectionException extends Exception {
    private int wrongSelectionType;
    public SelectionException(int wrongSelectionType) {
        this.wrongSelectionType = wrongSelectionType;
    }

    public String getMessage() {
        if (wrongSelectionType == ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) {
            return "Vous avez utilisé le type de sélection multiple alors que vous auriez du utiliser le type de sélection unique";
        }
        else
            return "Vous avez utilisé le type de sélection le type de sélection unique alors que vous auriez du utiliser le type de sélection multiple";
    }
}
