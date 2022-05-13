package Intepreter;

import java.util.ArrayList;

import sample.Absyn.*;
import sample.PrettyPrinter;

public class TypeChecker {
    public class Variable{
        public String ident;
        public Type type;
    }

    public Type typeOf(ArrayList<Variable> context, Expr expr) throws TypeException{
        if (expr instanceof ConstFalse) {
            return new BoolType();
        }

        if (expr instanceof ConstTrue) {
            return new BoolType();
        }

        if (expr instanceof If){
            var expr_type = typeCheck(context, ((If) expr).expr_1, new BoolType());
            var typeOfResult = typeOf(context, ((If) expr).expr_2);
            return typeCheck(context, ((If) expr).expr_3, typeOfResult);
        }

        if (expr instanceof ConstZero)
            return new IntType();
        if (expr instanceof Succ){
            typeCheck(context, ((Succ) expr).expr_, new IntType());
            return new IntType();
        }
        if (expr instanceof Pred){
            typeCheck(context, ((Pred) expr).expr_, new IntType());
            return new IntType();
        }
        if (expr instanceof IsZero){
            typeCheck(context, ((IsZero) expr).expr_, new IntType());
            return new BoolType();
        }

        if (expr instanceof Var){
            var variable = context.stream()
                    .filter(c -> ((Var) expr).ident_.equals(c.ident))
                    .findAny()
                    .orElse(null);
            if (variable != null) {
                return variable.type;
            }else {
                undefinedVar(expr);
                return null;
            }
        }

        return null;
    }

    private void undefinedVar(Expr expr) {
        System.out.println("undefined variable with unknown type \n");
        PrettyPrinter.print(expr);
    }

    private boolean isSameType(Type type1, Type type2) {
        return type1.getClass().equals(type2.getClass());
    }

    private Type typeCheck(ArrayList<Variable> context, Expr expr, Type expected_type) throws TypeException{
        var actual_type = typeOf(context, expr);
        if (isSameType(expected_type, actual_type)){
            return actual_type;
        }
        else {
            throw new TypeException(expected_type, actual_type, expr);
        }
    }
}
