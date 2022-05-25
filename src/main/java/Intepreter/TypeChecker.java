package Intepreter;

import sample.Absyn.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class TypeChecker {

    public Type typeOf(Context context, Expr expr) throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        addBultInFunctions(context);

        if (expr instanceof EInt)
            return new IntType();
        if (expr instanceof EDouble)
            return new DoubleType();
        if (expr instanceof EStr)
            return new StringType();

        if (expr instanceof ConstFalse)
            return new BoolType();
        if (expr instanceof ConstTrue)
            return new BoolType();

        if (expr instanceof If){
            var exprType = typeCheck(context, ((If) expr).expr_, new BoolType());
            var typeOfThen = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_1).listexpr_, null);
            var typeOfElse = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_2).listexpr_, null);

            return new VoidType();
        }
      
        if (expr instanceof TypeAliasing){
            var ident = ((TypeAlIdent) ((TypeAliasing) expr).typeal_).ident_;
            var type = ((TypeAliasing) expr).type_;
            checkName(context, ident, expr);
            context.aliasedTypes.add(new AliasedTypes(ident, type));
            return type;
        }

        if (expr instanceof OnlyDecl){
            String ident = null;
            Type type = null;

            var decl = ((OnlyDecl) expr).dec_;
            if (decl instanceof Declaration) {
                ident = ((Declaration) decl).ident_;
                type = ((Declaration) decl).type_;
            }
            if (decl instanceof TypeAlDecl){
                ident = ((TypeAlDecl) decl).ident_1;
                type = getRealType(context, ((TypeAlDecl) decl).ident_2);
            }

            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof OnlyGlDecl){
            String ident = null;
            Type type = null;

            var decl = ((OnlyGlDecl) expr).gldec_;
            if (decl instanceof GlDeclaration) {
                ident = ((GlDeclaration) decl).ident_;
                type = ((GlDeclaration) decl).type_;
            }
            if (decl instanceof TypeAlGlDec){
                ident = ((TypeAlGlDec) decl).ident_1;
                type = getRealType(context, ((TypeAlGlDec) decl).ident_2);
            }

            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof InitDecl){
            String ident = null;
            Type type = null;
            try {
                ident = ((Declaration) ((InitDecl) expr).dec_).ident_;
                type = ((Declaration) ((InitDecl) expr).dec_).type_;
            }catch (Exception e){
                ident = ((TypeAlDecl) ((InitDecl) expr).dec_).ident_1;
                type = getRealType(context, ((TypeAlDecl) ((InitDecl) expr).dec_).ident_2);
            }
            var decExpr = ((InitDecl) expr).expr_;

            if (decExpr instanceof NilKeyword)
                return type;

            var exprType = typeCheck(context, decExpr, type);
            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof InitGlDecl){
            String ident = null;
            Type type = null;
            try {
                ident = ((GlDeclaration) ((InitGlDecl) expr).gldec_).ident_;
                type = ((GlDeclaration) ((InitGlDecl) expr).gldec_).type_;
            }catch (Exception e){
                ident = ((TypeAlGlDec) ((InitGlDecl) expr).gldec_).ident_1;
                type = getRealType(context, ((TypeAlGlDec) ((InitGlDecl) expr).gldec_).ident_2);
            }
            var decExpr = ((InitGlDecl) expr).expr_;

            if (decExpr instanceof NilKeyword)
                return type;

            var exprType = typeCheck(context, decExpr, type);
            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, type));
            return type;
        }

        if (expr instanceof InitFuncDecl){
            var ident = ((InitFuncDecl) expr).ident_;
            var expression = ((InitFuncDecl) expr).expr_;

            var type = typeOf(context, expression);
            if (type instanceof FuncType) {
                checkName(context, ident, expr);
                checkName(context, ident, expr);
                context.functions.add(new Function(ident, ((FuncType) type).type_, ((FuncArgs) ((FuncType) type).fargs_)));
            }
            else
                throw new TypeException(new FuncType(null, null), type, expression);
        }

        if (expr instanceof VarTypeAnnotation){
            var ident = ((VarTypeAnnotation) expr).ident_;
            var decExpr = ((VarTypeAnnotation) expr).expr_;

            if (decExpr instanceof NilKeyword)
                throw new TypeException("Cannot infer type: variable initializer is nil");

            var exprType = typeOf(context, decExpr);

            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, exprType));
            return exprType;
        }

        if (expr instanceof GlVarTypeAnnotation){
            var ident = ((GlVarTypeAnnotation) expr).ident_;
            var decExpr = ((GlVarTypeAnnotation) expr).expr_;

            if (decExpr instanceof NilKeyword)
                throw new TypeException("Cannot infer type: variable initializer is nil");

            var exprType = typeOf(context, decExpr);

            checkName(context, ident, expr);
            context.variables.add(new Variable(ident, exprType));
            return exprType;
        }

        if (expr instanceof Var){
            var ident = ((Var) expr).ident_;
            var type = getType(context, ident);
            if (type == null)
                throw new UndefinedIdentifierExpression(expr);
            return type;
        }

        if (expr instanceof TableDecl){
            var ident = ((Declaration) ((TableDecl) expr).dec_).ident_;
            var type = ((Declaration) ((TableDecl) expr).dec_).type_;
            if (!isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((TableDecl) expr).ident_1;
            var identVar_2 = ((TableDecl) expr).ident_2;

            var var_1 = getVariable(context, identVar_1);
            var var_2 = getVariable(context, identVar_2);

            if (var_1 == null || var_2 == null)
                throw new UndefinedIdentifierExpression(expr);

            checkName(context, ident, expr);
            context.tables.add(new Table(ident, type, var_1, var_2));
            return type;
        }

        if (expr instanceof GlTableDecl){
            var ident = ((GlDeclaration) ((GlTableDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((GlTableDecl) expr).gldec_).type_;
            if (!isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((GlTableDecl) expr).ident_1;
            var identVar_2 = ((GlTableDecl) expr).ident_2;

            var var_1 = getVariable(context, identVar_1);
            var var_2 = getVariable(context, identVar_2);

            if (var_1 == null || var_2 == null)
                throw new UndefinedIdentifierExpression(expr);

            checkName(context, ident, expr);
            context.tables.add(new Table(ident, type, var_1, var_2));
            return type;
        }

        if (expr instanceof InitTableDecl){
            var ident = ((Declaration) ((InitTableDecl) expr).dec_1).ident_;
            var type = ((Declaration) ((InitTableDecl) expr).dec_1).type_;
            if (!isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((Declaration) ((InitTableDecl) expr).dec_2).ident_;
            var typeVar_1 = ((Declaration) ((InitTableDecl) expr).dec_2).type_;

            var identVar_2 = ((Declaration) ((InitTableDecl) expr).dec_3).ident_;
            var typeVar_2 = ((Declaration) ((InitTableDecl) expr).dec_3).type_;

            checkName(context, ident, expr);
            context.tables.add(new Table(ident, type, new Variable(identVar_1, typeVar_2),
                    new Variable(identVar_2, typeVar_2)));
            return type;
        }

        if (expr instanceof InitGlTableDecl){
            var ident = ((GlDeclaration) ((InitGlTableDecl) expr).gldec_).ident_;
            var type = ((GlDeclaration) ((InitGlTableDecl) expr).gldec_).type_;
            if (!isSameType(type, new TableType()))
                throw new TypeException(new TableType(), type, expr);

            var identVar_1 = ((Declaration) ((InitGlTableDecl) expr).dec_1).ident_;
            var typeVar_1 = ((Declaration) ((InitGlTableDecl) expr).dec_1).type_;

            var identVar_2 = ((Declaration) ((InitGlTableDecl) expr).dec_2).ident_;
            var typeVar_2 = ((Declaration) ((InitGlTableDecl) expr).dec_2).type_;

            checkName(context, ident, expr);
            context.tables.add(new Table(ident, type, new Variable(identVar_1, typeVar_2),
                    new Variable(identVar_2, typeVar_2)));
            return type;
        }

        if (expr instanceof TableElementCall){
            var tableIdent = ((TableElementCall) expr).ident_1;

            var table =  getTable(context, tableIdent);
            if (table == null)
                throw new UndefinedIdentifierExpression(expr);

            var varIdent = ((TableElementCall) expr).ident_2;
            var varType = getVarType(table, varIdent);

            if (varType != null)
                return varType;

            throw new UndefinedIdentifierExpression(expr);
        }

        if (expr instanceof TableElementAssignment){
            var tableIdent = ((TableElementAssignment) expr).ident_1;

            var table =  getTable(context, tableIdent);
            if (table == null)
                throw new UndefinedIdentifierExpression(expr);

            var varIdent = ((TableElementAssignment) expr).ident_2;
            var varType = getVarType(table, varIdent);

            if (varType == null)
                throw new UndefinedIdentifierExpression(expr);

            var tableExpr = ((TableElementAssignment) expr).expr_;
            var exprType = typeOf(context, tableExpr);

            if (!isSameType(varType, exprType))
                throw new TypeException(varType, exprType, tableExpr);
            return new VoidType();
        }

        if (expr instanceof Assignment){
            var ident = ((Assignment) expr).ident_;
            var type = getType(context, ident);
            if (type != null) {
                var exprType = typeCheck(context, ((Assignment) expr).expr_, type);
                return new VoidType();
            }
            else
                throw new UndefinedIdentifierExpression(expr);
        }

        if (expr instanceof FuncCall){
            var function = context.functions.stream()
                    .filter(c -> ((FuncCall) expr).ident_.equals(c.ident))
                    .findAny()
                    .orElse(null);
            if (function != null){
                var funcCallArgs = ((Vars) ((FuncCall) expr).comaexprs_).listexpr_;
                for (int i = 0; i < function.args.listdec_.size(); i++){
                    var varType = typeOf(context, funcCallArgs.get(i));
                    var argType = ((Declaration) function.args.listdec_.get(i)).type_;
                    if (!isSameType(varType, argType))
                        throw new TypeException(argType, varType, expr);
                }
                return function.returnType;
            } else
                throw new UndefinedIdentifierExpression(expr);
        }

        if (expr instanceof Func){
            var ident = ((Func) expr).ident_;
            var args = ((FuncArgs) ((Func) expr).fargs_);
            var body = ((ProgramExprs) ((Func) expr).program_).listexpr_;

            var funcType = ((Func) expr).type_;

            checkName(context, ident, expr);
            context.functions.add(new Function(ident, funcType, args));

            var newContext = new Context();
            newContext.variables = new ArrayList<>(context.variables);
            newContext.functions = new ArrayList<>(context.functions);
            newContext.tables = new ArrayList<>(context.tables);
            newContext.aliasedTypes = new ArrayList<>(context.aliasedTypes);
            addToContext(newContext, args.listdec_, expr);

            return checkAndGetReturnType(newContext, body, funcType, ident);
        }

        if (expr instanceof TypeAlFunc){
            var ident = ((TypeAlFunc) expr).ident_1;
            var args = ((FuncArgs) ((TypeAlFunc) expr).fargs_);
            var body = ((ProgramExprs) ((TypeAlFunc) expr).program_).listexpr_;

            var funcType = getRealType(context, ((TypeAlFunc) expr).ident_2);

            checkName(context, ident, expr);
            context.functions.add(new Function(ident, funcType, args));

            var newContext = new Context();
            newContext.variables = new ArrayList<>(context.variables);
            newContext.functions = new ArrayList<>(context.functions);
            newContext.tables = new ArrayList<>(context.tables);
            newContext.aliasedTypes = new ArrayList<>(context.aliasedTypes);
            addToContext(newContext, args.listdec_, expr);
            return checkAndGetReturnType(newContext, body, funcType, ident);
        }

        if (expr instanceof FuncTypeAnnotation){
            var ident = ((FuncTypeAnnotation) expr).ident_;
            var args = ((FuncArgs) ((FuncTypeAnnotation) expr).fargs_);
            var body = ((ProgramExprs) ((FuncTypeAnnotation) expr).program_).listexpr_;

            var newContext = new Context();
            newContext.variables = new ArrayList<>(context.variables);
            newContext.functions = new ArrayList<>(context.functions);
            newContext.tables = new ArrayList<>(context.tables);
            newContext.aliasedTypes = new ArrayList<>(context.aliasedTypes);
            addToContext(newContext, args.listdec_, expr);
            var funcType = getReturnTypeOfProgram(newContext, body, ident);
            checkName(context, ident, expr);
            context.functions.add(new Function(ident, funcType, args));

            return funcType;
        }

        if (expr instanceof LetBinding){
            var newContext = new Context();
            newContext.variables = new ArrayList<>();
            newContext.functions = new ArrayList<>(context.functions);
            newContext.tables = new ArrayList<>();
            newContext.aliasedTypes = new ArrayList<>(context.aliasedTypes);
            var fields = ((LBFields) ((LetBinding) expr).fields_).listfield_;
            for (var field : fields) {
                if (field instanceof LBField){
                    String fieldVarIdent = null;
                    Type fieldVarType = null;
                    var fieldExpr = ((LBField) field).expr_;
                    var fieldDec = ((LBField) field).dec_;
                    if (fieldDec instanceof Declaration){
                        fieldVarIdent = ((Declaration) fieldDec).ident_;
                        fieldVarType = ((Declaration) fieldDec).type_;
                        typeCheck(newContext, fieldExpr, fieldVarType);
                    }
                    if (fieldDec instanceof TypeAlDecl){
                        fieldVarIdent = ((TypeAlDecl) fieldDec).ident_1;
                        fieldVarType = getRealType(newContext, ((TypeAlDecl) fieldDec).ident_2);
                        typeCheck(newContext, fieldExpr, fieldVarType);
                    }

                    checkName(context, fieldVarIdent, expr);
                    newContext.variables.add(new Variable(fieldVarIdent, fieldVarType));
                }
                if (field instanceof TypeAnField){
                    var fieldVarIdent = ((TypeAnField) field).ident_;
                    var fieldVarExpr = ((TypeAnField) field).expr_;

                    if (fieldVarExpr instanceof NilKeyword)
                        throw new TypeException("Cannot infer type: variable initializer is nil");

                    var fieldVarType = typeOf(context, fieldVarExpr);

                    checkName(context, fieldVarIdent, expr);
                    newContext.variables.add(new Variable(fieldVarIdent, fieldVarType));
                }
            }
            return typeOf(newContext, ((LetBinding) expr).expr_);
        }

        if (expr instanceof Not){
            var boolExpr = typeCheck(context, ((Not) expr).expr_, new BoolType());
            return boolExpr;
        }

        if (expr instanceof And){
            var boolExpr_1 = typeCheck(context, ((And) expr).expr_1, new BoolType());
            var boolExpr_2 = typeCheck(context, ((And) expr).expr_2, new BoolType());
            return boolExpr_1;
        }

        if (expr instanceof Or){
            var boolExpr_1 = typeCheck(context, ((Or) expr).expr_1, new BoolType());
            var boolExpr_2 = typeCheck(context, ((Or) expr).expr_2, new BoolType());
            return boolExpr_1;
        }

        if (expr instanceof TypeAscription){
            var type = ((TypeAscription) expr).type_;
            var expression = ((TypeAscription) expr).expr_;

            return typeCheck(context, expression, type);
        }

        if (expr instanceof TypeAscWithTypeAl){
            var type = getRealType(context, ((TypeAscWithTypeAl) expr).ident_);
            var expression = ((TypeAscWithTypeAl) expr).expr_;

            return typeCheck(context, expression, type);
        }

        if (expr instanceof Return){
            return typeOf(context, ((Return) expr).expr_);
        }

        if (expr instanceof AnonymFunc){
            var funcArgs = ((AnonymFunc) expr).fargs_;
            var returnType = ((AnonymFunc) expr).type_;
            var body = ((ProgramExprs) ((AnonymFunc) expr).program_).listexpr_;

            checkAndGetReturnType(context, body, returnType, null);
            return new FuncType(funcArgs, returnType);
        }

        if (expr instanceof TypeAlAnonymFunc){
            var funcArgs = ((TypeAlAnonymFunc) expr).fargs_;
            var returnType = getRealType(context, ((TypeAlAnonymFunc) expr).ident_);
            var body = ((ProgramExprs) ((TypeAlAnonymFunc) expr).program_).listexpr_;

            checkAndGetReturnType(context, body, returnType, null);
            return new FuncType(funcArgs, returnType);
        }

        return null;
    }

    private void addToContext(Context newContext, ListDec args, Expr expr) throws TypeException, NameAlreadyUsedException {
        for (var arg : args) {
            if (arg instanceof Declaration) {
                var ident = ((Declaration) arg).ident_;
                var type = ((Declaration) arg).type_;
                if (type instanceof TableType)
                    throw new TypeException("Incorrect table declaration");
                if (type instanceof FuncType) {
                    checkName(newContext, ident, expr);
                    newContext.functions.add(new Function(ident, ((FuncType) type).type_, ((FuncArgs) ((FuncType) type).fargs_)));
                }
                else {
                    checkName(newContext, ident, expr);
                    newContext.variables.add(new Variable(ident, type));
                }
            }
            if (arg instanceof TypeAlDecl){
                var ident = ((TypeAlDecl) arg).ident_1;
                var type = getRealType(newContext, ((TypeAlDecl) arg).ident_2);
                if (type instanceof TableType)
                    throw new TypeException("Incorrect table declaration");
                if (type instanceof FuncType) {
                    checkName(newContext, ident, expr);
                    newContext.functions.add(new Function(ident, ((FuncType) type).type_, ((FuncArgs) ((FuncType) type).fargs_)));
                }
                else {
                    checkName(newContext, ident, expr);
                    newContext.variables.add(new Variable(ident, type));
                }
            }
        }
    }

    private void checkName(Context context, String ident, Expr expr) throws NameAlreadyUsedException {
        var type = getType(context, ident);
        if (type != null)
            throw new NameAlreadyUsedException(ident, expr);
    }

    private Type getType(Context context, String ident) {
        Variable variable = getVariable(context, ident);
        if (variable != null)
            return variable.type;

        Table table = getTable(context, ident);
        if (table != null)
            return table.type;

        Function function = getFunction(context, ident);
        if (function != null)
            return new FuncType(function.args, function.returnType);

        return null;
    }

    private Type getVarType(Table table, String varIdent) {
        if (table.variable_1.ident.equals(varIdent))
            return table.variable_1.type;
        if (table.variable_2.ident.equals(varIdent))
            return table.variable_2.type;
        return null;
    }

    private Table getTable(Context context, String ident) {
        var table = context.tables.stream()
                .filter(c -> ident.equals(c.ident))
                .findAny()
                .orElse(null);
        return table;
    }

    private Variable getVariable(Context context, String ident) {
        var variable = context.variables.stream()
                .filter(c -> ident.equals(c.ident))
                .findAny()
                .orElse(null);
        return variable;
    }

    private Function getFunction(Context context, String ident){
        var function = context.functions.stream()
                .filter(c -> ident.equals(c.ident))
                .findAny()
                .orElse(null);
        return function;
    }

    private Type checkAndGetReturnType(Context context, List<Expr> body, Type expectedType, String programIdent) throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        var returnType = getReturnTypeOfProgram(context, body, programIdent);
        var returnExpr = getReturnExpr(body);

        if (isSameType(expectedType, returnType)) {
            return returnType;
        }
        else {
            throw new TypeException(expectedType, returnType, returnExpr);
        }
    }

    private Type getReturnTypeOfProgram(Context context, List<Expr> body, String programIdent) throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        Type returnType = null;
        for (var expr : body) {
            if (programIdent != null && expr instanceof FuncCall)
                if (((FuncCall) expr).ident_.equals(programIdent))
                    continue;

            if (expr instanceof Return) {
                if (programIdent != null && ((Return) expr).expr_ instanceof FuncCall)
                    if (((FuncCall) ((Return) expr).expr_).ident_.equals(programIdent))
                        continue;
                var type = typeOf(context, ((Return) expr).expr_);
                if (returnType == null)
                    returnType = type;
                else
                    if (!isSameType(returnType, type))
                        throw new TypeException(returnType, type, expr);
            }
            else {

                if (expr instanceof If) {
                    var thenType = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_1).listexpr_, programIdent);
                    var elseType = getReturnTypeOfProgram(context, ((ProgramExprs) ((If) expr).program_2).listexpr_, programIdent);

                    if (!isSameType(thenType, new VoidType()))
                        if (returnType == null)
                            returnType = thenType;
                        else if (!isSameType(returnType, thenType))
                            throw new TypeException(returnType, thenType, getReturnExpr(((ProgramExprs) ((If) expr).program_1).listexpr_));

                    if (!isSameType(elseType, new VoidType()))
                        if (returnType == null)
                            returnType = elseType;
                        else if (!isSameType(returnType, elseType))
                            throw new TypeException(returnType, elseType, getReturnExpr(((ProgramExprs) ((If) expr).program_2).listexpr_));
                }
                else typeOf(context, expr);
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

    public boolean isSameType(Type type1, Type type2) {
        return type1.getClass().equals(type2.getClass());
    }

    public Type getRealType(Context context, String ident){
        var t = context.aliasedTypes.stream()
                .filter(c -> ident.equals(c.ident))
                .findAny()
                .orElse(null);
        if (t != null)
            return t.aliasedType;
        return null;
    }

    private Type typeCheck(Context context, Expr expr, Type expected_type) throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        var actual_type = typeOf(context, expr);
        if (isSameType(expected_type, actual_type)){
            return actual_type;
        }
        else {
            throw new TypeException(expected_type, actual_type, expr);
        }
    }

    private void addBultInFunctions(Context context) {
        ListDec intListDec = new ListDec();
        intListDec.addAll(Arrays.asList(new Declaration("a", new IntType()), new Declaration("b", new IntType())));
        context.functions.add(new Function("add", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("sub", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("mul", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("div", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("mod", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("exp", new IntType(), new FuncArgs(intListDec)));
        relationsOperations(context, intListDec);

        ListDec doubleListDec = new ListDec();
        doubleListDec.addAll(Arrays.asList(new Declaration("a", new DoubleType()), new Declaration("b", new DoubleType())));
        context.functions.add(new Function("add", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("sub", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("mul", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("div", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("mod", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("exp", new DoubleType(), new FuncArgs(doubleListDec)));
        relationsOperations(context, doubleListDec);

        ListDec oneDeclIntList = new ListDec();
        oneDeclIntList.add(new Declaration("a", new IntType()));
        context.functions.add(new Function("neg", new IntType(), new FuncArgs(oneDeclIntList)));

        ListDec oneDeclDoubleList = new ListDec();
        oneDeclDoubleList.add(new Declaration("a", new DoubleType()));
        context.functions.add(new Function("neg", new DoubleType(), new FuncArgs(oneDeclDoubleList)));

        ListDec printDecList = new ListDec();
        context.functions.add(new Function("print", new VoidType(), new FuncArgs(printDecList)));

        ListDec strListDec = new ListDec();
        strListDec.addAll(Arrays.asList(new Declaration("a", new StringType()), new Declaration("b", new StringType())));
        context.functions.add(new Function("add", new StringType(), new FuncArgs(strListDec)));
        relationsOperations(context, strListDec);
    }

    private void relationsOperations(Context context, ListDec listDec) {
        context.functions.add(new Function("greater", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("less", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("equal", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("gOrE", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("lOrE", new BoolType(), new FuncArgs(listDec)));
    }
}
