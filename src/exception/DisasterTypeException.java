package exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DisasterTypeException extends Exception{
    private String type;

    public String getMessage(){
        return type + " n'est pas un type valide de catastrophe";
    }
}
