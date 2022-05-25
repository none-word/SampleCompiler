package Intepreter;

import sample.Absyn.*;

import java.util.List;

public interface Eval {
    Expr evalProgram(ProgramExprs program);
/**--------------------------------------**/
    Expr evalExpr(Expr expr);
/**--------------------------------------**/
    void evalType(Import expr, ProgramExprs programExprs);
    Expr evalType(Var expr);
    Expr evalType(ConstTrue expr);
    Expr evalType(ConstFalse expr);
    Expr evalType(If expr);
    List<Expr> evalType(Vars args);
/**--------------------------------------**/
    Expr evalType(FuncCall expr);
    List<Expr> evalType(FuncArgs args, List<Expr> exprs);
    Expr evalType(Func expr);
    Expr evalType(TypeAlFunc expr); // ToDo
    Expr evalType(Return expr);
/**--------------------------------------**/
    Expr evalType(NilKeyword expr);
/**--------------------------------------**/
    Expr evalType(TypeAliasing expr);
/**--------------------------------------**/
    Expr evalType(VarTypeAnnotation expr);
    Expr evalType(GlVarTypeAnnotation expr);
    Expr evalType(FuncTypeAnnotation expr);
/**--------------------------------------**/
    Expr evalType(TypeAscription expr);
    Expr evalType(TypeAscWithTypeAl expr);
/**--------------------------------------**/
    Expr evalType(EInt expr);
    Expr evalType(EDouble expr);
    Expr evalType(EStr expr);
/**--------------------------------------**/
    Expr evalType(Not expr);
    Expr evalType(And expr);
    Expr evalType(Or expr);
/**--------------------------------------**/
    Expr evalType(Declaration dec);
    Expr evalType(TypeAlDecl dec);
    Expr evalType(GlDeclaration dec);
    Expr evalType(TypeAlGlDec dec); // ToDo
    Expr evalType(OnlyDecl expr);
    Expr evalType(OnlyGlDecl expr);
    Expr evalType(InitDecl expr);
    Expr evalType(InitGlDecl expr);
/**--------------------------------------**/
    Expr evalType(TableDecl expr);
    Expr evalType(GlTableDecl expr);
    Expr evalType(InitTableDecl expr);
    Expr evalType(InitGlTableDecl expr);
    Expr evalType(TableElementCall expr);
    Expr evalType(TableElementAssignment expr);
/**--------------------------------------**/
    Expr evalType(Assignment expr);
/**--------------------------------------**/
    Expr evalType(LetBinding expr); // ToDo
}
