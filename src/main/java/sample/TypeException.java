package sample;

import sample.Absyn.Expr;
import sample.Absyn.Type;

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
        return "Type Error: expected " + expected_type.getClass().toString() + " but actual type is " + actual_type.getClass().toString() + " for expression " + expr.toString();
    }
}
