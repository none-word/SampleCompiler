package Intepreter;

import Intepreter.Storage.FunctionStorage;
import Intepreter.Storage.TableStorage;
import Intepreter.Storage.TypeStorage;
import Intepreter.Storage.VariableStorage;
import sample.Absyn.*;
import sample.PrettyPrinter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EvalImpl implements Eval {
    private final VariableStorage variableStorage = new VariableStorage();
    private final FunctionStorage functionStorage = new FunctionStorage();
    private final StandardLibrary standardLibrary = new StandardLibraryImpl();
    private final TypeStorage typeStorage = new TypeStorage();
    private final TableStorage tableStorage = new TableStorage();

    @Override
    public Expr evalProgram(ProgramExprs program) {
        for (Expr expr : program.listexpr_) {
            String type = expr.getClass().getSimpleName();
            if (type.equals("Return")) {
                return evalExpr(expr);
            }
            if (type.equals("Import")) {
                evalType((Import) expr, program);
                return null;
            }
            var result = evalExpr(expr);
            if (type.equals("If") && result != null) {
                return result;
            }
        }
        return null;
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalExpr(Expr expr) {
        String type = expr.getClass().getSimpleName();
        switch (type) {
            case ("Var"):
                return evalType((Var) expr);
            case ("ConstTrue"):
                return evalType((ConstTrue) expr);
            case ("ConstFalse"):
                return evalType((ConstFalse) expr);
            case ("If"):
                return evalType((If) expr);
            /*---------------------------------**/
            case ("FuncCall"):
                return evalType((FuncCall) expr);
            case ("Func"):
                return evalType((Func) expr);
            case ("TypeAlFunc"):
                return evalType((TypeAlFunc) expr);
            case ("AnonymFunc"):
                return evalType((AnonymFunc) expr);
            case ("TypeAlAnonymFunc"):
                return evalType((TypeAlAnonymFunc) expr);
            case ("Return"):
                return evalType((Return) expr);
            /*---------------------------------**/
            case ("NilKeyword"):
                return evalType((NilKeyword) expr);
            /*---------------------------------**/
            case ("TypeAliasing"):
                return evalType((TypeAliasing) expr);
            /*---------------------------------**/
            case ("VarTypeAnnotation"):
                return evalType((VarTypeAnnotation) expr);
            case ("GlVarTypeAnnotation"):
                return evalType((GlVarTypeAnnotation) expr);
            case ("FuncTypeAnnotation"):
                return evalType((FuncTypeAnnotation) expr);
            /*---------------------------------**/
            case ("TypeAscription"):
                return evalType((TypeAscription) expr);
            case ("TypeAscWithTypeAl"):
                return evalType((TypeAscWithTypeAl) expr);
            /*---------------------------------**/
            case ("EInt"):
                return evalType((EInt) expr);
            case ("EDouble"):
                return evalType((EDouble) expr);
            case ("EStr"):
                return evalType((EStr) expr);
            /*---------------------------------**/
            case ("Not"):
                return evalType((Not) expr);
            case ("And"):
                return evalType((And) expr);
            case ("Or"):
                return evalType((Or) expr);
            /*---------------------------------**/
            case ("OnlyDecl"):
                return evalType((OnlyDecl) expr);
            case ("OnlyGlDecl"):
                return evalType((OnlyGlDecl) expr);
            case ("InitDecl"):
                return evalType((InitDecl) expr);
            case ("InitGlDecl"):
                return evalType((InitGlDecl) expr);
            /*---------------------------------**/
            case ("TableDecl"):
                return evalType((TableDecl) expr);
            case ("GlTableDecl"):
                return evalType((GlTableDecl) expr);
            case ("InitTableDecl"):
                return evalType((InitTableDecl) expr);
            case ("InitGlTableDecl"):
                return evalType((InitGlTableDecl) expr);
            case ("InitFuncDecl"):
                return evalType((InitFuncDecl) expr);
            case ("TableElementCall"):
                return evalType((TableElementCall) expr);
            case ("TableElementAssignment"):
                return evalType((TableElementAssignment) expr);
            /*---------------------------------**/
            case ("Assignment"):
                return evalType((Assignment) expr);
            /*---------------------------------**/
            case ("LetBinding"):
                return evalType((LetBinding) expr);
            /*---------------------------------**/
            default:
                return null;
        }
    }

/**------------------------------------------------------------**/

    @Override
    public void evalType(Import expr, ProgramExprs programExprs) {
        Idents idts = (Idents) expr.idts_;
        programExprs.listexpr_.removeFirst();
        idts.listident_.forEach(ident -> {
            var currentPath = System.getProperty("user.dir");
            var path = currentPath + Paths.get("/src/main/java/Examples/" + ident + ".smpl");
            ProgramExprs importProgram = null;
            try {
                importProgram = Interpreter.readFile(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assert importProgram != null;
            programExprs.listexpr_.addAll(0, importProgram.listexpr_);
        });
        Interpreter.runProgram(programExprs);
    }

    @Override
    public Expr evalType(Var expr) {
        return variableStorage.getVariable(expr.ident_);
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
    public List<Expr> evalType(Vars args) {
        return args.listexpr_.stream().map(this::evalExpr).collect(Collectors.toList());
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(FuncCall expr) {
        String funcName = expr.ident_;
        List<Expr> args = ((Vars) expr.comaexprs_).listexpr_;
        switch (funcName) {
            case ("add"):
            case ("add_d"):
                return standardLibrary.add(args.get(0), args.get(1), this);
            case ("sub"):
            case ("sub_d"):
                return standardLibrary.sub(args.get(0), args.get(1), this);
            case ("mul"):
            case ("mul_d"):
                return standardLibrary.mul(args.get(0), args.get(1), this);
            case ("div"):
            case ("div_d"):
                return standardLibrary.div(args.get(0), args.get(1), this);
            case ("mod"):
            case ("mod_d"):
                return standardLibrary.mod(args.get(0), args.get(1), this);
            case ("neg"):
            case ("neg_d"):
                return standardLibrary.neg(args.get(0), this);
            case ("exponentiation"):
            case ("exponentiation_d"):
                return standardLibrary.exp(args.get(0), args.get(1), this);
            case ("greater"):
            case ("greater_d"):
                return standardLibrary.greater(args.get(0), args.get(1), this);
            case ("less"):
            case ("less_d"):
                return standardLibrary.less(args.get(0), args.get(1), this);
            case ("equal"):
            case ("equal_d"):
                return standardLibrary.equal(args.get(0), args.get(1), this);
            case ("gOrE"):
            case ("gOrE_d"):
                return standardLibrary.gOrE(args.get(0), args.get(1), this);
            case ("lOrE"):
            case ("lOrE_d"):
                return standardLibrary.lOrE(args.get(0), args.get(1), this);
            case ("print"):
                evalType((Vars) expr.comaexprs_).forEach(e -> System.out.print(PrettyPrinter.print(e)));
                System.out.println();
                return null;
            default:
                return funcCall(expr);
        }
    }

    private Expr funcCall(FuncCall call) {
        Eval eval = new EvalImpl();
        try {
            FuncArgs funcArgs = functionStorage.getArguments(call.ident_);
            List<Expr> args = evalType((Vars) call.comaexprs_);
            List<Expr> declarations = eval.evalType(funcArgs, args);
            declarations.forEach(initDec -> eval.evalType((InitDecl) initDec));
            Program program = functionStorage.getFunction(call.ident_);
            return eval.evalProgram((ProgramExprs) program);
        } catch (Exception e) {
            AnonymFunc anonymFunc = (AnonymFunc) variableStorage.getVariable(call.ident_);
            FuncArgs funcArgs = (FuncArgs) anonymFunc.fargs_;
            List<Expr> args = evalType((Vars) call.comaexprs_);
            List<Expr> declarations = eval.evalType(funcArgs, args);
            declarations.forEach(initDec -> eval.evalType((InitDecl) initDec));
            Program program = anonymFunc.program_;
            return eval.evalProgram((ProgramExprs) program);
        }
    }

    @Override
    public List<Expr> evalType(FuncArgs args, List<Expr> exprs) {
        List<Expr> result = new ArrayList<>();
        ListDec declarations = args.listdec_;
        for (int i = 0; i < args.listdec_.size(); i++) {
            result.add(new InitDecl(declarations.get(i), exprs.get(i)));
        }
        return result;
    }

    @Override
    public Expr evalType(Func expr) {
        functionStorage.saveFunction(expr.ident_, (FuncArgs) expr.fargs_, expr.type_, expr.program_);
        return expr;
    }

    @Override
    public Expr evalType(TypeAlFunc expr) {
        functionStorage.saveFunction(expr.ident_1, (FuncArgs) expr.fargs_, typeStorage.getType(expr.ident_2), expr.program_);
        return expr;
    }

    @Override
    public Expr evalType(AnonymFunc expr) {
        return expr;
    }

    @Override
    public Expr evalType(TypeAlAnonymFunc expr) {
        return expr;
    }

    @Override
    public Expr evalType(Return expr) {
        return evalExpr(expr.expr_);
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(NilKeyword expr) {
        return new NilKeyword();
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(TypeAliasing expr) {
        typeStorage.saveType(((TypeAlIdent) expr.typeal_).ident_, expr.type_);
        return null;
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(VarTypeAnnotation expr) {
        var typeChecker = new TypeChecker();
        Context context = new Context();
        try {
            Type type = typeChecker.typeOf(context, expr);
            evalType(new InitDecl(
                    new Declaration(expr.ident_, type),
                    expr.expr_
            ));
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Expr evalType(GlVarTypeAnnotation expr) {
        var typeChecker = new TypeChecker();
        Context context = new Context();
        try {
            Type type = typeChecker.typeOf(context, expr);
            evalType(new InitGlDecl(
                    new GlDeclaration(expr.ident_, type),
                    expr.expr_
            ));
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Expr evalType(FuncTypeAnnotation expr) {
        var typeChecker = new TypeChecker();
        Context context = new Context();
        try {
            Type type = typeChecker.typeOf(context, expr);
            evalType(new Func(
                    expr.ident_,
                    expr.fargs_,
                    type,
                    expr.program_
            ));
            return null;
        } catch (Exception e) {
            return null;
        }
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(TypeAscription expr) {
        return evalExpr(expr.expr_);
    }

    @Override
    public Expr evalType(TypeAscWithTypeAl expr) {
        return evalExpr(expr.expr_);
    }

/**------------------------------------------------------------**/

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

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(Not expr) {
        if (evalExpr(expr.expr_) instanceof ConstTrue) {
            return new ConstFalse();
        } else {
            return new ConstTrue();
        }
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

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(Declaration dec) {
        variableStorage.saveVariable(dec.ident_, dec.type_, null);
        return variableStorage.getVariable(dec.ident_);
    }

    @Override
    public Expr evalType(TypeAlDecl dec) {
        variableStorage.saveVariable(dec.ident_1, typeStorage.getType(dec.ident_2), null);
        return variableStorage.getVariable(dec.ident_1);
    }

    @Override
    public Expr evalType(GlDeclaration dec) {
        variableStorage.saveGlobalVariable(dec.ident_, dec.type_, null);
        return variableStorage.getVariable(dec.ident_);
    }

    @Override
    public Expr evalType(TypeAlGlDec dec) {
        variableStorage.saveGlobalVariable(dec.ident_1, typeStorage.getType(dec.ident_2), null);
        return variableStorage.getVariable(dec.ident_1);
    }

    @Override
    public Expr evalType(OnlyDecl expr) {
        String type = expr.getClass().getSimpleName();
        if (type.equals("Declaration")) {
            return evalType((Declaration) expr.dec_);
        } else {
            return evalType((TypeAlDecl) expr.dec_);
        }
    }

    @Override
    public Expr evalType(OnlyGlDecl expr) {
        String type = expr.getClass().getSimpleName();
        if (type.equals("GlDeclaration")) {
            return evalType((GlDeclaration) expr.gldec_);
        } else {
            return evalType((TypeAlGlDec) expr.gldec_);
        }
    }

    @Override
    public Expr evalType(InitDecl expr) {
        Expr result = evalExpr(expr.expr_);
        String type = expr.dec_.getClass().getSimpleName();
        String ident;
        if (type.equals("Declaration")) {
            Declaration dec = (Declaration) expr.dec_;
            variableStorage.saveVariable(dec.ident_, dec.type_, result);
            ident = dec.ident_;
        } else {
            TypeAlDecl typeAlDecl = (TypeAlDecl) expr.dec_;
            variableStorage.saveVariable(typeAlDecl.ident_1, typeStorage.getType(typeAlDecl.ident_2), result);
            ident = typeAlDecl.ident_1;
        }
        return variableStorage.getVariable(ident);
    }

    @Override
    public Expr evalType(InitGlDecl expr) {
        Expr result = evalExpr(expr.expr_);
        GlDeclaration dec = (GlDeclaration) expr.gldec_;
        variableStorage.saveGlobalVariable(dec.ident_, dec.type_, result);
        return variableStorage.getVariable(dec.ident_);
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(TableDecl dec) {
        tableStorage.saveTable(dec);
        return null;
    }

    @Override
    public Expr evalType(GlTableDecl dec) {
        tableStorage.saveGlobalTable(dec);
        return null;
    }

    @Override
    public Expr evalType(InitTableDecl dec) {
        tableStorage.saveTable(dec);
        return null;
    }

    @Override
    public Expr evalType(InitGlTableDecl dec) {
        tableStorage.saveGlobalTable(dec);
        return null;
    }

    @Override
    public Expr evalType(InitFuncDecl expr) {
        functionStorage.saveFunction(expr.ident_, (FuncArgs) ((AnonymFunc) expr.expr_).fargs_, ((AnonymFunc) expr.expr_).type_, ((AnonymFunc) expr.expr_).program_);
        return null;
    }

    @Override
    public Expr evalType(TableElementCall expr) {
        return tableStorage.getTable(expr.ident_1, expr.ident_2);
    }

    @Override
    public Expr evalType(TableElementAssignment expr) {
        tableStorage.updateTable(expr.ident_1, expr.ident_2, expr.expr_);
        return null;
    }

/**------------------------------------------------------------**/

    @Override
    public Expr evalType(Assignment expr) {
        Expr result = evalExpr(expr.expr_);
        variableStorage.updateVariable(expr.ident_, result);
        return variableStorage.getVariable(expr.ident_);
    }

/**------------------------------------------------------------**/

    @Override
    public void evalType(LBFields fields) {
        fields.listfield_.forEach(field -> {
            String type = field.getClass().getSimpleName();
            if (type.equals("LBField")) {
                LBField lbField = (LBField) field;
                variableStorage.saveVariable(((Declaration) lbField.dec_).ident_, ((Declaration) lbField.dec_).type_, lbField.expr_);
            } else {
                TypeAnField typeAnField = (TypeAnField) field;
                try {
                    variableStorage.saveVariable(typeAnField.ident_, (new TypeChecker()).typeOf(new Context(), typeAnField.expr_), typeAnField.expr_);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public Expr evalType(LetBinding expr) {
        Eval eval = new EvalImpl();
        eval.evalType((LBFields) expr.fields_);
        return eval.evalExpr(expr.expr_);
    }
}
