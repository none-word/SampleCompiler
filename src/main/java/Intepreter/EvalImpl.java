package Intepreter;

import sample.Absyn.*;

import java.util.List;

public class EvalImpl implements Eval {
    private final VariableStorage variableStorage = new VariableStorage();
    private final FunctionStorage functionStorage = new FunctionStorage();
    private final StandardLibrary standardLibrary = new StandardLibraryImpl();

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
            case ("NilKeyword"):
                return evalType((NilKeyword) expr);
            case ("EInt"):
                return evalType((EInt) expr);
            case ("EDouble"):
                return evalType((EDouble) expr);
            case ("EStr"):
                return evalType((EStr) expr);
            case ("OnlyDecl"):
                return evalType((OnlyDecl) expr);
            case ("Assignment"):
                return evalType((Assignment) expr);
            case ("Func"):
                return evalType((Func) expr);
            case ("InitTableDecl"):
                return evalType((InitTableDecl) expr);
            case ("FuncCall"):
                return evalType((FuncCall) expr);
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
        return evalType((Declaration) expr.dec_, result);
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
    public Expr evalType(Var expr) {
        return variableStorage.getVariable(expr.ident_);
    }

    @Override
    public Expr evalType(NilKeyword expr) {
        return new NilKeyword();
    }

    @Override
    public Expr evalType(EInt expr) {
        return expr;
    }

    @Override
    public Expr evalType(EDouble expr) {
        return expr;
    }

    @Override
    public Expr evalType(EStr expr) {
        return expr;
    }

    @Override
    public Expr evalType(OnlyDecl expr) {
        return evalType((Declaration) expr.dec_);
    }

    @Override
    public Expr evalType(Declaration dec) {
        variableStorage.saveVariable(dec.ident_, dec.type_, null);
        return variableStorage.getVariable(dec.ident_);
    }

    @Override
    public Expr evalType(Declaration dec, Expr value) {
        variableStorage.saveVariable(dec.ident_, dec.type_, value);
        return variableStorage.getVariable(dec.ident_);
    }

    @Override
    public Expr evalType(Assignment expr) {
        Expr result = evalExpr(expr.expr_);
        variableStorage.updateVariable(expr.ident_, result);
        return variableStorage.getVariable(expr.ident_);
    }

    @Override
    public Expr evalType(Func expr) {
        functionStorage.saveFunction(expr.ident_, (FuncArgs) expr.fargs_, expr.type_, expr.program_);
        return expr;
    }

    @Override
    public Expr evalType(FuncArgs args) {
        return null;
    }

    @Override
    public Expr evalType(InitTableDecl args) {
        return null;
    }

    @Override
    public Expr evalType(FuncCall expr) {
        String funcName = expr.ident_;
        List<Expr> args = ((Vars) expr.comaexprs_).listexpr_;
        switch (funcName) {
            case ("add"):
                return standardLibrary.add(args.get(0), args.get(1));
            case ("sub"):
                return standardLibrary.sub(args.get(0), args.get(1));
            case ("mul"):
                return standardLibrary.mul(args.get(0), args.get(1));
            case ("div"):
                return standardLibrary.div(args.get(0), args.get(1));
            case ("neg"):
                return standardLibrary.neg(args.get(0));
            case ("exp"):
                return standardLibrary.exp(args.get(0), args.get(1));
            default:
                return null; // call user defined functions
        }
    }
}
