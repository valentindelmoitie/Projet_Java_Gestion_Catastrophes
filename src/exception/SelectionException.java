package exception;

import javax.swing.*;

public class SelectionException extends Exception {
    private Integer wrongSelectionType;
    public String noSelection;

    public SelectionException(int wrongSelectionType) {
        this.wrongSelectionType = wrongSelectionType;
    }

    public SelectionException(String noSelection) {
        this.noSelection = noSelection;
    }

    public String getMessage() {
        if (wrongSelectionType != null) {
            if (wrongSelectionType == ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) {
                return "Vous avez utilisé le type de sélection multiple alors que vous auriez dû utiliser le type de sélection unique.";
            }

            return "Vous avez utilisé le type de sélection le type de sélection unique alors que vous auriez du utiliser le type de sélection multiple.";
        }

        return noSelection;

    }
}
