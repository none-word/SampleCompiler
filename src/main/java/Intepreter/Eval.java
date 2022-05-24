package Intepreter;

import sample.Absyn.*;

import java.util.List;

public interface Eval {
    Expr evalProgram(ProgramExprs program);
    Expr evalExpr(Expr expr);
    Expr evalType(ConstTrue expr);
    Expr evalType(ConstFalse expr);
    Expr evalType(If expr);
    Expr evalType(TypeAliasing expr);
    Expr evalType(InitDecl expr);
    Expr evalType(InitGlDecl expr);
    Expr evalType(And expr);
    Expr evalType(Or expr);
    Expr evalType(Not expr);
    Expr evalType(Var expr);
    Expr evalType(NilKeyword expr);
    Expr evalType(EInt expr);
    Expr evalType(EDouble expr);
    Expr evalType(EStr expr);
    Expr evalType(OnlyDecl expr);
    Expr evalType(OnlyGlDecl expr);
    Expr evalType(Declaration dec);
    Expr evalType(Declaration dec, Expr value);
    Expr evalType(GlDeclaration dec);
    Expr evalType(GlDeclaration dec, Expr value);
    Expr evalType(Assignment expr);
    Expr evalType(Func expr);
    List<Expr> evalType(FuncArgs args, List<Expr> exprs);
    List<Expr> evalType(Vars args);
    Expr evalType(InitTableDecl args);
    Expr evalType(FuncCall expr);
    Expr evalType(Return expr);
    Expr evalType(VarTypeAscription expr);
    Expr evalType(GlVarTypeAscription expr);
    Expr evalType(FuncTypeAscription expr);
}
