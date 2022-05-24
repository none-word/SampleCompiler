package Intepreter;

import sample.Absyn.*;

import java.util.List;

public interface Eval {
    Expr evalProgram(ProgramExprs program);
/**--------------------------------------**/
    Expr evalExpr(Expr expr);
/**--------------------------------------**/
    Expr evalType(Import expr); // ToDo
    Expr evalType(Var expr);
    Expr evalType(ConstTrue expr);
    Expr evalType(ConstFalse expr);
    Expr evalType(If expr);
    List<Expr> evalType(Vars args);
/**--------------------------------------**/
    Expr evalType(FuncCall expr);
    List<Expr> evalType(FuncArgs args, List<Expr> exprs);
    Expr evalType(Func expr);
    Expr evalType(Return expr);
/**--------------------------------------**/
    Expr evalType(NilKeyword expr);
/**--------------------------------------**/
    Expr evalType(TypeAliasing expr); // ToDo
/**--------------------------------------**/
    Expr evalType(VarTypeAnnotation expr);
    Expr evalType(GlVarTypeAnnotation expr);
    Expr evalType(FuncTypeAnnotation expr);
/**--------------------------------------**/
    Expr evalType(VarTypeAscription expr);
    Expr evalType(GlVarTypeAscription expr);
    Expr evalType(FuncTypeAscription expr);
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
    Expr evalType(GlDeclaration dec);
    Expr evalType(OnlyDecl expr);
    Expr evalType(OnlyGlDecl expr);
    Expr evalType(InitDecl expr);
    Expr evalType(InitGlDecl expr);
/**--------------------------------------**/
    Expr evalType(TableDecl expr); // ToDo
    Expr evalType(GlTableDecl expr); // ToDo
    Expr evalType(InitTableDecl expr); // ToDo
    Expr evalType(InitGlTableDecl expr); // ToDo
    Expr evalType(TableElementCall expr); // ToDo
    Expr evalType(TableElementAssignment expr); // ToDo
/**--------------------------------------**/
    Expr evalType(Assignment expr);
}
