package Intepreter;

import java.util.ArrayList;
import java.util.List;

import sample.Absyn.*;
import sample.PrettyPrinter;

public class TypeChecker {
    public class Variable{
        public String ident;
        public Type type;

        public Variable(String ident, Type type) {
            this.ident = ident;
            this.type = type;
        }
    }

    public Type typeOf(ArrayList<Variable> context, Expr expr) throws TypeException{
        if (expr instanceof ConstFalse) {
            return new BoolType();
        }

        if (expr instanceof ConstTrue) {
            return new BoolType();
        }

        if (expr instanceof If){
            var expr_type = typeCheck(context, ((If) expr).expr_, new BoolType());
            var typeOfThen = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_1).listexpr_);
            System.out.print("type of then: ");
            System.out.println(typeOfThen);

            return checkAndGetProgramType(context, ((ProgramExprs) ((If) expr).program_2).listexpr_, typeOfThen);
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

        if (expr instanceof Func){

            System.out.println("body:");
            PrettyPrinter.print(expr);

            var args = ((FuncArgs) ((Func) expr).fargs_);
            var body = ((ProgramExprs) ((Func) expr).program_).listexpr_;

            var funcType = ((Func) expr).type_;
            var newContext = context;
            for (Dec arg : args.listdec_){
                newContext.add(new Variable(((Declaration) arg).ident_, ((Declaration) arg).type_));
            }
            return checkAndGetProgramType(newContext, body, funcType);
        }

        return null;
    }

    private Type checkAndGetProgramType(ArrayList<Variable> context, List<Expr> body, Type expectedType) throws TypeException{
        var returnType = getReturnTypeOfProgram(context, body);
        var returnExpr = getReturnExpr(body);

        if (isSameType(expectedType, returnType)) {
            return returnType;
        }
        else {
            throw new TypeException(expectedType, returnType, returnExpr);
        }
    }

    private Type getReturnTypeOfProgram(ArrayList<Variable> context, List<Expr> body) throws TypeException{
        for (var expr : body) {

            if (expr instanceof Return) {
                return typeOf(context, ((Return) expr).expr_);
            }

            if (expr instanceof If){
                var thenType = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_1).listexpr_);
                var elseType = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_2).listexpr_);

                if (!isSameType(thenType, new VoidType()))
                    return thenType;
                if (!isSameType(elseType, new VoidType()))
                    return elseType;
            }
        }

        return new VoidType();
    }

    private Expr getReturnExpr(List<Expr> body) {
        for (var expr : body) {
            if (expr instanceof Return) {
                return expr;
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
