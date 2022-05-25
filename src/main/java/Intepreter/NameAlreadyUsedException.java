package Intepreter;

import sample.Absyn.Expr;
import sample.PrettyPrinter;

public class NameAlreadyUsedException extends Exception{
    private String message;

    public NameAlreadyUsedException(String name, Expr expr) {
        this.message = "The name " + name + " is already used for expression " + PrettyPrinter.print(expr);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
