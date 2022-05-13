package Intepreter;

import java.util.Dictionary;
import java.util.List;

import sample.Absyn.*;

public class TypeChecker {

    public TypeChecker(Dictionary<String, String> symbolTable) {
    }

    public Type typeOf(List<Var> context, Expr expr) throws TypeException{
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
            typeCheck(context, expr, new IntType());
            return new IntType();
        }
        if (expr instanceof Pred){
            typeCheck(context, expr, new IntType());
            return new IntType();
        }
        if (expr instanceof IsZero){
            typeCheck(context, expr, new IntType());
            return new BoolType();
        }

        if (expr instanceof Var){

        }

        return null;
    }

    private boolean isSameType(Type type1, Type type2) {
        return type1.getClass().equals(type1.getClass());
    }

    private Type typeCheck(List<Var> context, Expr expr, Type expected_type) throws TypeException{
        var actual_type = typeOf(context, expr);
        if (isSameType(expected_type, actual_type)){
            return actual_type;
        }
        else {
            throw new TypeException(expected_type, actual_type, expr);
        }
    }
}
