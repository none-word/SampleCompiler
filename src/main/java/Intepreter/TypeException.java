package Intepreter;

import sample.Absyn.Expr;
import sample.Absyn.Type;
import sample.PrettyPrinter;

public class TypeException extends Exception{
    private Type expected_type;
    private Type actual_type;
    private Expr expr;

    public TypeException(Type expected_type, Type actual_type, Expr expr) {
        this.expected_type = expected_type;
        this.actual_type = actual_type;
        this.expr = expr;
    }

    @Override
    public String getMessage() {
        return "Type Error: expected " + PrettyPrinter.print(expected_type) + " but actual type is " + PrettyPrinter.print(actual_type) + " for expression " + PrettyPrinter.print(expr);
    }
}
