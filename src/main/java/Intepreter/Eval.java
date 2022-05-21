package Intepreter;

import sample.Absyn.*;

public interface Eval {
    Expr evalProgram(ProgramExprs program);
    Expr evalExpr(Expr expr);
    Expr evalType(ConstTrue expr);
    Expr evalType(ConstFalse expr);
    Expr evalType(If expr);
    Expr evalType(TypeAliasing expr);
    Expr evalType(InitDecl expr);
    Expr evalType(And expr);
    Expr evalType(Or expr);
    Expr evalType(Var var);
}
