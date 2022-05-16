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

        if (expr instanceof Func){
            var args = ((FuncArgs) ((Func) expr).fargs_);
            var body = ((ProgramExprs) ((Func) expr).program_).listexpr_;
            var funcType = ((Func) expr).type_;
            var newContext = context;
            for (Dec arg : args.listdec_){
                newContext.add(new Variable(((Declaration) arg).ident_, ((Declaration) arg).type_));
            }
            return checkAndGetFuncType(newContext, body, funcType);
        }

        return null;
    }

    private Type checkAndGetFuncType(ArrayList<Variable> context, List<Expr> body, Type funcType) throws TypeException{
        var returnType = getReturnType(context, body);
        var returnExpr = getReturnExpr(context, body);

        if (returnType == null){
            System.out.print("func type: ");
            System.out.println(funcType);
            System.out.print("Is same type: ");
            System.out.println(isSameType(funcType, new VoidType()));
            if (isSameType(funcType, new VoidType())) {
                System.out.println("heh");
                return new VoidType();
            }
            else
                throw new TypeException(funcType, new VoidType(), returnExpr);
        }
        else {
            if (!isSameType(returnType, funcType))
                throw new TypeException(funcType, returnType, returnExpr);
            else
                return returnType;
        }
    }

    private Type getReturnType(ArrayList<Variable> context, List<Expr> body) throws TypeException{
        Type exprType = null;
        for (var expr : body) {
            if (expr instanceof Return) {
                var type = typeOf(context, ((Return) expr).expr_);
                if (exprType == null)
                    exprType = type;
                else if (!isSameType(exprType, type))
                    throw new TypeException(exprType, type, expr);
            }
        }
        return exprType;
    }

    private Expr getReturnExpr(ArrayList<Variable> context, List<Expr> body) {
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
