package Intepreter;

import sample.Absyn.ConstFalse;
import sample.Absyn.ConstTrue;
import sample.Absyn.Expr;
import sample.Absyn.If;

public interface EvalType {
    Expr evalType(ConstTrue expr);
    Expr evalType(ConstFalse expr);
    Expr evalType(If expr);
}
