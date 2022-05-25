package Intepreter;

import sample.Absyn.Expr;
import sample.PrettyPrinter;

public class NameAlreadyUsedException extends Exception{
    private String message;

    public NameAlreadyUsedException(String name, Expr expr) {
        this.message = "Cannot use name " + name + " in expression " + PrettyPrinter.print(expr) + " because it was already used.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
