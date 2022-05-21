package Intepreter;

import sample.Absyn.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class EvalImpl implements Eval {
    private final VariableStorage variableStorage = new VariableStorage();

    @Override
    public Expr evalProgram(ProgramExprs program) {
        Object[] objects = program.listexpr_.stream()
                .map(this::evalExpr)
                .toArray();
        return (Expr) objects[objects.length - 1];
    }

    @Override
    public Expr evalExpr(Expr expr) {
        String type = expr.getClass().getSimpleName();
        switch (type) {
            case ("ConstTrue"):
                return evalType((ConstTrue) expr);
            case ("ConstFalse"):
                return evalType((ConstFalse) expr);
            case ("If"):
                return evalType((If) expr);
            case ("TypeAliasing"):
                return evalType((TypeAliasing) expr);
            case ("InitDecl"):
                return evalType((InitDecl) expr);
            case ("And"):
                return evalType((And) expr);
            case ("Or"):
                return evalType((Or) expr);
            case ("Var"):
                return evalType((Var) expr);
            default:
                return null;
        }
    }

    @Override
    public Expr evalType(ConstTrue expr) {
        return new ConstTrue();
    }

    @Override
    public Expr evalType(ConstFalse expr) {
        return new ConstFalse();
    }

    @Override
    public Expr evalType(If expr) {
        if (evalExpr(expr.expr_) instanceof ConstTrue) {
            return evalProgram((ProgramExprs) expr.program_1);
        } else {
            return evalProgram((ProgramExprs) expr.program_2);
        }
    }

    @Override
    public Expr evalType(TypeAliasing expr) {
        variableStorage.saveVariable(expr.ident_, expr.type_, null);
        return null;
    }

    @Override
    public Expr evalType(InitDecl expr) {
        Expr result = evalExpr(expr.expr_);
        Declaration declaration = (Declaration) expr.dec_;
        variableStorage.saveVariable(declaration.ident_, declaration.type_, result);
        return null;
    }

    @Override
    public Expr evalType(And expr) {
        if (evalExpr(expr.expr_1) instanceof ConstTrue &&
                        evalExpr(expr.expr_2) instanceof ConstTrue) {
            return new ConstTrue();
        } else {
            return new ConstFalse();
        }
    }

    @Override
    public Expr evalType(Or expr) {
        if (evalExpr(expr.expr_1) instanceof ConstTrue ||
                evalExpr(expr.expr_2) instanceof ConstTrue) {
            return new ConstTrue();
        } else {
            return new ConstFalse();
        }
    }

    @Override
    public Expr evalType(Var var) {
        return variableStorage.getVariable(var.ident_);
    }
}
