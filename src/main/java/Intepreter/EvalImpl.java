//package Intepreter;
//
//import sample.Absyn.*;
//import sample.PrettyPrinter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class EvalImpl implements Eval {
//    private final VariableStorage variableStorage = new VariableStorage();
//    private final FunctionStorage functionStorage = new FunctionStorage();
//    private final StandardLibrary standardLibrary = new StandardLibraryImpl();
//
//    @Override
//    public Expr evalProgram(ProgramExprs program) {
//        for (Expr expr : program.listexpr_) {
//            String type = expr.getClass().getSimpleName();
//            if (type.equals("Return")) {
//                return evalExpr(expr);
//            }
//            var result = evalExpr(expr);
//            if (type.equals("If") && result != null) {
//                return result;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Expr evalExpr(Expr expr) {
//        String type = expr.getClass().getSimpleName();
//        switch (type) {
//            case ("ConstTrue"):
//                return evalType((ConstTrue) expr);
//            case ("ConstFalse"):
//                return evalType((ConstFalse) expr);
//            case ("If"):
//                return evalType((If) expr);
//            case ("TypeAliasing"):
//                return evalType((TypeAliasing) expr);
//            case ("InitDecl"):
//                return evalType((InitDecl) expr);
//            case ("And"):
//                return evalType((And) expr);
//            case ("Or"):
//                return evalType((Or) expr);
//            case ("Not"):
//                return evalType((Not) expr);
//            case ("Var"):
//                return evalType((Var) expr);
//            case ("NilKeyword"):
//                return evalType((NilKeyword) expr);
//            case ("EInt"):
//                return evalType((EInt) expr);
//            case ("EDouble"):
//                return evalType((EDouble) expr);
//            case ("EStr"):
//                return evalType((EStr) expr);
//            case ("OnlyDecl"):
//                return evalType((OnlyDecl) expr);
//            case ("Assignment"):
//                return evalType((Assignment) expr);
//            case ("Func"):
//                return evalType((Func) expr);
//            case ("InitTableDecl"):
//                return evalType((InitTableDecl) expr);
//            case ("FuncCall"):
//                return evalType((FuncCall) expr);
//            case ("Return"):
//                return evalType((Return) expr);
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public Expr evalType(ConstTrue expr) {
//        return new ConstTrue();
//    }
//
//    @Override
//    public Expr evalType(ConstFalse expr) {
//        return new ConstFalse();
//    }
//
//    @Override
//    public Expr evalType(If expr) {
//        if (evalExpr(expr.expr_) instanceof ConstTrue) {
//            return evalProgram((ProgramExprs) expr.program_1);
//        } else {
//            return evalProgram((ProgramExprs) expr.program_2);
//        }
//    }
//
//    @Override
//    public Expr evalType(TypeAliasing expr) {
//        variableStorage.saveVariable(expr.ident_, expr.type_, null);
//        return null;
//    }
//
//    @Override
//    public Expr evalType(InitDecl expr) {
//        Expr result = evalExpr(expr.expr_);
//        String type = expr.dec_.getClass().getSimpleName();
//        return type.equals("Declaration") ?
//                evalType((Declaration) expr.dec_, result) :
//                evalType((GlDeclaration) expr.dec_, result);
//    }
//
//    @Override
//    public Expr evalType(And expr) {
//        if (evalExpr(expr.expr_1) instanceof ConstTrue &&
//                        evalExpr(expr.expr_2) instanceof ConstTrue) {
//            return new ConstTrue();
//        } else {
//            return new ConstFalse();
//        }
//    }
//
//    @Override
//    public Expr evalType(Or expr) {
//        if (evalExpr(expr.expr_1) instanceof ConstTrue ||
//                evalExpr(expr.expr_2) instanceof ConstTrue) {
//            return new ConstTrue();
//        } else {
//            return new ConstFalse();
//        }
//    }
//
//    @Override
//    public Expr evalType(Not expr) {
//        if (evalExpr(expr.expr_) instanceof ConstTrue) {
//            return new ConstFalse();
//        } else {
//            return new ConstTrue();
//        }
//    }
//
//    @Override
//    public Expr evalType(Var expr) {
//        return variableStorage.getVariable(expr.ident_);
//    }
//
//    @Override
//    public Expr evalType(NilKeyword expr) {
//        return new NilKeyword();
//    }
//
//    @Override
//    public Expr evalType(EInt expr) {
//        return expr;
//    }
//
//    @Override
//    public Expr evalType(EDouble expr) {
//        return expr;
//    }
//
//    @Override
//    public Expr evalType(EStr expr) {
//        return expr;
//    }
//
//    @Override
//    public Expr evalType(OnlyDecl expr) {
//        return evalType((Declaration) expr.dec_);
//    }
//
//    @Override
//    public Expr evalType(Declaration dec) {
//        variableStorage.saveVariable(dec.ident_, dec.type_, null);
//        return variableStorage.getVariable(dec.ident_);
//    }
//
//    @Override
//    public Expr evalType(Declaration dec, Expr value) {
//        variableStorage.saveVariable(dec.ident_, dec.type_, value);
//        return variableStorage.getVariable(dec.ident_);
//    }
//
//    @Override
//    public Expr evalType(GlDeclaration dec, Expr value) {
//        variableStorage.saveGlobalVariable(dec.ident_, dec.type_, value);
//        return variableStorage.getVariable(dec.ident_);
//    }
//
//    @Override
//    public Expr evalType(Assignment expr) {
//        Expr result = evalExpr(expr.expr_);
//        variableStorage.updateVariable(expr.ident_, result);
//        return variableStorage.getVariable(expr.ident_);
//    }
//
//    @Override
//    public Expr evalType(Func expr) {
//        functionStorage.saveFunction(expr.ident_, (FuncArgs) expr.fargs_, expr.type_, expr.program_);
//        return expr;
//    }
//
//    @Override
//    public List<Expr> evalType(FuncArgs args, List<Expr> exprs) {
//        List<Expr> result = new ArrayList<>();
//        ListDec declarations = args.listdec_;
//        for (int i = 0; i < args.listdec_.size(); i++) {
//            result.add(new InitDecl(declarations.get(i), exprs.get(i)));
//        }
//        return result;
//    }
//
//    @Override
//    public List<Expr> evalType(Vars args) {
//        return args.listexpr_.stream().map(this::evalExpr).collect(Collectors.toList());
//    }
//
//    @Override
//    public Expr evalType(InitTableDecl args) {
//        return null;
//    }
//
//    @Override
//    public Expr evalType(FuncCall expr) {
//        String funcName = expr.ident_;
//        List<Expr> args = ((Vars) expr.comaexprs_).listexpr_;
//        switch (funcName) {
//            case ("add"):
//                return standardLibrary.add(args.get(0), args.get(1), variableStorage);
//            case ("sub"):
//                return standardLibrary.sub(args.get(0), args.get(1), variableStorage);
//            case ("mul"):
//                return standardLibrary.mul(args.get(0), args.get(1), variableStorage);
//            case ("div"):
//                return standardLibrary.div(args.get(0), args.get(1), variableStorage);
//            case ("mod"):
//                return standardLibrary.mod(args.get(0), args.get(1), variableStorage);
//            case ("neg"):
//                return standardLibrary.neg(args.get(0), variableStorage);
//            case ("exp"):
//                return standardLibrary.exp(args.get(0), args.get(1), variableStorage);
//            case ("greater"):
//                return standardLibrary.greater(args.get(0), args.get(1), variableStorage);
//            case ("less"):
//                return standardLibrary.less(args.get(0), args.get(1), variableStorage);
//            case ("equal"):
//                return standardLibrary.equal(args.get(0), args.get(1), variableStorage);
//            case ("gOrE"):
//                return standardLibrary.gOrE(args.get(0), args.get(1), variableStorage);
//            case ("lOrE"):
//                return standardLibrary.lOrE(args.get(0), args.get(1), variableStorage);
//            case ("print"):
//                evalType((Vars) expr.comaexprs_).forEach(e -> System.out.print(PrettyPrinter.print(e)));
//                System.out.println();
//                return null;
//            default:
//                return funcCall(expr);
//        }
//    }
//
//    private Expr funcCall(FuncCall call) {
//        Eval eval = new EvalImpl();
//        FuncArgs funcArgs = functionStorage.getArguments(call.ident_);
//        List<Expr> args = evalType((Vars) call.comaexprs_);
//        List<Expr> declarations = eval.evalType(funcArgs, args);
//        declarations.forEach(initDec -> eval.evalType((InitDecl) initDec));
//        Program program = functionStorage.getFunction(call.ident_);
//        return eval.evalProgram((ProgramExprs) program);
//    }
//
//    @Override
//    public Expr evalType(Return expr) {
//        return evalExpr(expr.expr_);
//    }
//}
