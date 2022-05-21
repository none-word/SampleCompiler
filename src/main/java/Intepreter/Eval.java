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
    Expr evalType(Declaration dec);
    Expr evalType(Declaration dec, Expr value);
    Expr evalType(Assignment expr);
    Expr evalType(Func expr);
    Expr evalType(FuncArgs args);
    Expr evalType(InitTableDecl args);
    Expr evalType(FuncCall expr);
}
