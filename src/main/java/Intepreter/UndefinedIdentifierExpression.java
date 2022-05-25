package Intepreter;

import sample.Absyn.Expr;
import sample.PrettyPrinter;

public class UndefinedIdentifierExpression extends Exception{
    private String message;

    public UndefinedIdentifierExpression(Expr expr) {
        this.message = "undefined identifier with unknown type : \n" + PrettyPrinter.print(expr);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
