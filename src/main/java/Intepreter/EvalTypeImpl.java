package Intepreter;

import sample.Absyn.ConstFalse;
import sample.Absyn.ConstTrue;
import sample.Absyn.Expr;
import sample.Absyn.If;

public class EvalTypeImpl implements EvalType {
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
//        if (expr.expr_1 instanceof ConstTrue) {
//            return expr.expr_2;
//        } else {
//            return expr.expr_3;
//        }
//    }
        return null;
    }
}
