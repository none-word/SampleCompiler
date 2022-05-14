package Intepreter;

import sample.Absyn.ConstFalse;
import sample.Absyn.ConstTrue;
import sample.Absyn.Expr;
import sample.Absyn.If;

public class EvalImpl implements Eval {
    private final EvalType evalType = new EvalTypeImpl();
    @Override
    public Expr evalStep(Expr expr) {
        String type = expr.getClass().getSimpleName();
        switch (type) {
            case ("ConstTrue"):
                return evalType.evalType((ConstTrue) expr);
            case ("ConstFalse"):
                return evalType.evalType((ConstFalse) expr);
            case ("If"):
                return evalType.evalType((If) expr);
            default:
                return null;
        }
    }
}
