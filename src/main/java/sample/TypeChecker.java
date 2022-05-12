package sample;

import java.util.Dictionary;
import java.util.List;

import sample.Absyn.*;

public class TypeChecker {
    private Dictionary <String, String> symbolTable;
    private class Variable{
        public Var ident;
        public Type type;
    }

    public TypeChecker(Dictionary<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }



    public Type typeOf(List<Variable> context, Expr expr) throws TypeException{
        if (expr instanceof ConstFalse) {
            return new BoolType();
        }
        if (expr instanceof ConstTrue) {
            return new BoolType();
        }
        if (expr instanceof If){
            var expr_type = typeOf(context, ((If) expr).expr_1);
            if (expr_type instanceof BoolType){
                //check t2 and t3
            }
            else {
                throw new TypeException("Type Error: expected Bool but actual type is " + PrettyPrinter.print(expr_type) + "for expression" + PrettyPrinter.print(expr));
            }

        }
    }

    private Type checkTypeOfExprs(List<Variable> context, Program program) {
        for
    }
}
