package Intepreter;

import sample.Absyn.Expr;
import sample.Absyn.Type;
import sample.PrettyPrinter;

public class TypeException extends Exception{
    private String message;

    public TypeException(Type expected_type, Type actual_type, Expr expr) {
        this.message = "Type Error: expected " + PrettyPrinter.print(expected_type) + " but actual type is " + PrettyPrinter.print(actual_type) + " for expression " + PrettyPrinter.print(expr);
    }

    public TypeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
