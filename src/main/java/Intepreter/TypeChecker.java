package Intepreter;

import sample.Absyn.*;
import sample.PrettyPrinter;

import java.util.List;

public class TypeChecker {

    public Type typeOf(Context context, GlobalContext globalContext, Expr expr) throws TypeException{

        if (expr instanceof EInt)
            return new IntType();
        if (expr instanceof EDouble)
            return new DoubleType();
        if (expr instanceof EStr)
            return new StringType();

        if (expr instanceof ConstFalse) {
            return new BoolType();
        }

        if (expr instanceof ConstTrue) {
            return new BoolType();
        }

        if (expr instanceof If){
            var exprType = typeCheck(context, globalContext, ((If) expr).expr_, new BoolType());
            var typeOfThen = getReturnTypeOfProgram(context, globalContext, ((ProgramExprs) ((If) expr).program_1).listexpr_);
            var typeOfElse = getReturnTypeOfProgram(context, globalContext, ((ProgramExprs) ((If) expr).program_2).listexpr_);

            return new VoidType();
        }

        if (expr instanceof ConstZero)
            return new IntType();
        if (expr instanceof Succ){
            typeCheck(context, globalContext, ((Succ) expr).expr_, new IntType());
            return new IntType();
        }
        if (expr instanceof Pred){
            typeCheck(context, globalContext, ((Pred) expr).expr_, new IntType());
            return new IntType();
        }
        if (expr instanceof IsZero){
            typeCheck(context, globalContext, ((IsZero) expr).expr_, new IntType());
            return new BoolType();
        }

        if (expr instanceof OnlyDecl){
            var ident = ((Declaration) ((OnlyDecl) expr).dec_).ident_;
            var type = ((Declaration) ((OnlyDecl) expr).dec_).type_;
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof OnlyGlDecl){
            var ident = ((GlDeclaration) ((OnlyGlDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((OnlyGlDecl) expr).gldec_).type_;
            globalContext.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof InitDecl){
            var ident = ((Declaration) ((InitDecl) expr).dec_).ident_;
            var type = ((Declaration) ((InitDecl) expr).dec_).type_;
            var decExpr = ((InitDecl) expr).expr_;

            if (decExpr instanceof NilKeyword)
                return type;

            var exprType = typeCheck(context, globalContext, decExpr, type);
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof InitGlDecl){
            var ident = ((GlDeclaration) ((InitGlDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((InitGlDecl) expr).gldec_).type_;
            var decExpr = ((InitGlDecl) expr).expr_;

            if (decExpr instanceof NilKeyword)
                return type;

            var exprType = typeCheck(context, globalContext, decExpr, type);
            globalContext.variables.add(new Variable(ident, type));
            return type;
        }


        if (expr instanceof VarTypeAnnotation){
            var ident = ((VarTypeAnnotation) expr).ident_;
            var decExpr = ((VarTypeAnnotation) expr).expr_;

            if (decExpr instanceof NilKeyword)
                throw new TypeException("Cannot infer type: variable initializer is nil");

            var exprType = typeOf(context,globalContext, decExpr);

            context.variables.add(new Variable(ident, exprType));
            return exprType;
        }

        if (expr instanceof GlVarTypeAnnotation){
            var ident = ((GlVarTypeAnnotation) expr).ident_;
            var decExpr = ((GlVarTypeAnnotation) expr).expr_;

            if (decExpr instanceof NilKeyword)
                throw new TypeException("Cannot infer type: variable initializer is nil");

            var exprType = typeOf(context, globalContext, decExpr);

            globalContext.variables.add(new Variable(ident, exprType));
            return exprType;
        }

        if (expr instanceof Var){
            var ident = ((Var) expr).ident_;
            var variable = getVariable(context, globalContext, ident);

            if (variable != null)
                return variable.type;
            else {
                undefinedVar(expr);
                return null;
            }
        }

        if (expr instanceof TableDecl){
            var ident = ((Declaration) ((TableDecl) expr).dec_).ident_;
            var type = ((Declaration) ((TableDecl) expr).dec_).type_;
            if (isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((TableDecl) expr).ident_1;
            var identVar_2 = ((TableDecl) expr).ident_2;

            var var_1 = getVariable(context, globalContext, identVar_1);
            var var_2 = getVariable(context, globalContext, identVar_2);

            if (var_1 == null || var_2 == null){
                undefinedVar(expr);
                return null;
            }

            context.tables.add(new Table(ident, type, var_1, var_2));
            return type;
        }

        if (expr instanceof GlTableDecl){
            var ident = ((GlDeclaration) ((GlTableDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((GlTableDecl) expr).gldec_).type_;
            if (isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((GlTableDecl) expr).ident_1;
            var identVar_2 = ((GlTableDecl) expr).ident_2;

            var var_1 = getVariable(context, globalContext, identVar_1);
            var var_2 = getVariable(context, globalContext, identVar_2);

            if (var_1 == null || var_2 == null){
                undefinedVar(expr);
                return null;
            }

            globalContext.tables.add(new Table(ident, type, var_1, var_2));
            return type;
        }

        if (expr instanceof InitTableDecl){
            var ident = ((Declaration) ((InitTableDecl) expr).dec_1).ident_;
            var type = ((Declaration) ((InitTableDecl) expr).dec_1).type_;
            if (isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((Declaration) ((InitTableDecl) expr).dec_2).ident_;
            var typeVar_1 = ((Declaration) ((InitTableDecl) expr).dec_2).type_;

            var identVar_2 = ((Declaration) ((InitTableDecl) expr).dec_3).ident_;
            var typeVar_2 = ((Declaration) ((InitTableDecl) expr).dec_3).type_;

            context.tables.add(new Table(ident, type, new Variable(identVar_1, typeVar_2),
                    new Variable(identVar_2, typeVar_2)));
            return type;
        }

        if (expr instanceof InitGlTableDecl){
            var ident = ((GlDeclaration) ((InitGlTableDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((InitGlTableDecl) expr).gldec_).type_;
            if (isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((Declaration) ((InitGlTableDecl) expr).dec_1).ident_;
            var typeVar_1 = ((Declaration) ((InitGlTableDecl) expr).dec_1).type_;

            var identVar_2 = ((Declaration) ((InitGlTableDecl) expr).dec_2).ident_;
            var typeVar_2 = ((Declaration) ((InitGlTableDecl) expr).dec_2).type_;

            globalContext.tables.add(new Table(ident, type, new Variable(identVar_1, typeVar_2),
                    new Variable(identVar_2, typeVar_2)));
            return type;
        }

        if (expr instanceof TableElementCall){
            var tableIdent = ((TableElementCall) expr).ident_1;

            var table =  getTable(context, globalContext, tableIdent);
            if (table == null){
                undefinedVar(expr);
                return null;
            }

            var varIdent = ((TableElementCall) expr).ident_2;
            var varType = getVarType(table, varIdent);

            if (varType != null)
                return varType;

            undefinedVar(expr);
            return null;
        }

        if (expr instanceof TableElementAssignment){
            var tableIdent = ((TableElementAssignment) expr).ident_1;

            var table =  getTable(context, globalContext, tableIdent);
            if (table == null){
                undefinedVar(expr);
                return null;
            }

            var varIdent = ((TableElementAssignment) expr).ident_2;
            var varType = getVarType(table, varIdent);

            if (varType == null){
                undefinedVar(expr);
                return null;
            }

            var tableExpr = ((TableElementAssignment) expr).expr_;
            var exprType = typeOf(context, globalContext, tableExpr);

            if (!isSameType(varType, exprType))
                throw new TypeException(varType, exprType, tableExpr);
            return new VoidType();
        }

        if (expr instanceof Assignment){
            var ident = ((Assignment) expr).ident_;
            var variable = getVariable(context, globalContext, ident);

            if (variable != null) {
                var exprType = typeCheck(context, globalContext, ((Assignment) expr).expr_, variable.type);
                return new VoidType();
            }else {
                undefinedVar(expr);
                return null;
            }
        }

        if (expr instanceof FuncCall){
            var function = context.functions.stream()
                    .filter(c -> ((FuncCall) expr).ident_.equals(c.ident))
                    .findAny()
                    .orElse(null);
            if (function != null){
                var funcCallArgs = ((Vars) ((FuncCall) expr).comaexprs_).listexpr_;
                for (int i = 0; i < function.args.listdec_.size(); i++){
                    var varType = typeOf(context, globalContext, funcCallArgs.get(i));
                    var argType = ((Declaration) function.args.listdec_.get(i)).type_;
                    if (!isSameType(varType, argType))
                        throw new TypeException(argType, varType, expr);
                }
                return function.type;
            } else {
                undefinedFunc(expr);
                return null;
            }
        }


        if (expr instanceof Func){
            var ident = ((Func) expr).ident_;
            var args = ((FuncArgs) ((Func) expr).fargs_);
            var body = ((ProgramExprs) ((Func) expr).program_).listexpr_;

            var funcType = ((Func) expr).type_;
            context.functions.add(new Function(ident, funcType, args));

            var newContext = new Context();
            for (Dec arg : args.listdec_){
                newContext.variables.add(new Variable(((Declaration) arg).ident_, ((Declaration) arg).type_));
            }
            return checkAndGetProgramType(newContext, globalContext, body, funcType);
        }

        if (expr instanceof FuncTypeAnnotation){
            var ident = ((FuncTypeAnnotation) expr).ident_;
            var args = ((FuncArgs) ((FuncTypeAnnotation) expr).fargs_);
            var body = ((ProgramExprs) ((FuncTypeAnnotation) expr).program_).listexpr_;

            var newContext = new Context();
            for (Dec arg : args.listdec_){
                newContext.variables.add(new Variable(((Declaration) arg).ident_, ((Declaration) arg).type_));
            }
            var funcType = getReturnTypeOfProgram(newContext, globalContext, body);
            context.functions.add(new Function(ident, funcType, args));

            return funcType;
        }

        if (expr instanceof Not){
            var boolExpr = typeCheck(context, globalContext, ((Not) expr).expr_, new BoolType());
            return boolExpr;
        }

        if (expr instanceof And){
            var boolExpr_1 = typeCheck(context, globalContext, ((And) expr).expr_1, new BoolType());
            var boolExpr_2 = typeCheck(context, globalContext, ((And) expr).expr_2, new BoolType());
            return boolExpr_1;
        }

        if (expr instanceof Or){
            var boolExpr_1 = typeCheck(context, globalContext, ((Or) expr).expr_1, new BoolType());
            var boolExpr_2 = typeCheck(context, globalContext, ((Or) expr).expr_2, new BoolType());
            return boolExpr_1;
        }

        return null;
    }

    private Type getVarType(Table table, String varIdent) {
        if (table.variable_1.ident.equals(varIdent))
            return table.variable_1.type;
        if (table.variable_2.ident.equals(varIdent))
            return table.variable_2.type;
        return null;
    }

    private Table getTable(Context context, GlobalContext globalContext, String tableIdent) {
        var table = context.tables.stream()
                .filter(c -> tableIdent.equals(c.ident))
                .findAny()
                .orElse(null);
        if (table == null)
            table = globalContext.tables.stream()
                    .filter(c -> tableIdent.equals(c.ident))
                    .findAny()
                    .orElse(null);
        return table;
    }

    private Variable getVariable(Context context, GlobalContext globalContext, String ident) {
        var variable = context.variables.stream()
                .filter(c -> ident.equals(c.ident))
                .findAny()
                .orElse(null);
        if (variable == null)
            variable = globalContext.variables.stream()
                    .filter(c -> ident.equals(c.ident))
                    .findAny()
                    .orElse(null);

        return variable;
    }

    private Type checkAndGetProgramType(Context context, GlobalContext globalContext, List<Expr> body, Type expectedType) throws TypeException{
        var returnType = getReturnTypeOfProgram(context, globalContext, body);
        var returnExpr = getReturnExpr(body);

        if (isSameType(expectedType, returnType)) {
            return returnType;
        }
        else {
            throw new TypeException(expectedType, returnType, returnExpr);
        }
    }

    private Type getReturnTypeOfProgram(Context context, GlobalContext globalContext, List<Expr> body) throws TypeException{
        Type returnType = null;
        for (var expr : body) {
            typeOf(context, globalContext, expr);

            if (expr instanceof Return) {
                var type = typeOf(context, globalContext, ((Return) expr).expr_);
                if (returnType == null)
                    returnType = type;
                else
                    if (!isSameType(returnType, type))
                        throw new TypeException(returnType, type, expr);
            }

            if (expr instanceof If){
                var thenType = getReturnTypeOfProgram(context, globalContext, ((ProgramExprs) ((If) expr).program_1).listexpr_);
                var elseType = getReturnTypeOfProgram(context, globalContext, ((ProgramExprs) ((If) expr).program_2).listexpr_);

                if (!isSameType(thenType, new VoidType()))
                    if (returnType == null)
                        returnType = thenType;
                    else
                        if (!isSameType(returnType, thenType))
                            throw new TypeException(returnType, thenType, getReturnExpr(((ProgramExprs) ((If) expr).program_1).listexpr_));

                if (!isSameType(elseType, new VoidType()))
                    if (returnType == null)
                        returnType = elseType;
                    else
                    if (!isSameType(returnType, elseType))
                        throw new TypeException(returnType, elseType, getReturnExpr(((ProgramExprs) ((If) expr).program_2).listexpr_));
            }
        }
        if (returnType != null)
            return returnType;
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

    private void undefinedFunc(Expr expr) {
        System.out.println("undefined function with unknown type \n");
        PrettyPrinter.print(expr);
    }

    public boolean isSameType(Type type1, Type type2) {
        return type1.getClass().equals(type2.getClass());
    }

    private Type typeCheck(Context context, GlobalContext globalContext, Expr expr, Type expected_type) throws TypeException{
        var actual_type = typeOf(context, globalContext, expr);
        if (isSameType(expected_type, actual_type)){
            return actual_type;
        }
        else {
            throw new TypeException(expected_type, actual_type, expr);
        }
    }
}
