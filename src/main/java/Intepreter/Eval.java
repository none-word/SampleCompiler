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
    Expr evalType(Var expr);
    Expr evalType(NilKeyword expr);
    Expr evalType(EInt expr);
    Expr evalType(OnlyDecl expr);
    Expr evalType(Declaration expr);
    Expr evalType(Declaration expr, Expr value);
    Expr evalType(Assignment expr);
}
