package Intepreter;

import sample.Absyn.*;

import java.util.Objects;

public class StandardLibraryImpl implements StandardLibrary {
    @Override
    public Expr add(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ + ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ + ((EDouble) expr2).double_);
        if (type1.equals("EStr") && type2.equals("EStr"))
            return new EStr(((EStr) expr1).string_ + ((EStr) expr2).string_);
        return null;
    }

    @Override
    public Expr sub(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ - ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ - ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr mul(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ * ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ * ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr div(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ / ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ / ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr mod(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ % ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ % ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr neg(Expr expr1, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type1.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ * (-1));
        if (type1.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ * (-1));
        return null;
    }

    @Override
    public Expr exp(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt((int) Math.pow(((EInt) expr1).integer_, ((EInt) expr2).integer_));
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(Math.pow(((EDouble) expr1).double_, ((EDouble) expr2).double_));
        return null;
    }

    @Override
    public Expr greater(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return ((EInt) expr1).integer_ > ((EInt) expr2).integer_ ? new ConstTrue() : new ConstFalse();
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return ((EDouble) expr1).double_ > ((EDouble) expr2).double_ ? new ConstTrue() : new ConstFalse();
        return null;
    }

    @Override
    public Expr less(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return ((EInt) expr1).integer_ < ((EInt) expr2).integer_ ? new ConstTrue() : new ConstFalse();
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return ((EDouble) expr1).double_ < ((EDouble) expr2).double_ ? new ConstTrue() : new ConstFalse();
        return null;
    }

    @Override
    public Expr equal(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return Objects.equals(((EInt) expr1).integer_, ((EInt) expr2).integer_) ? new ConstTrue() : new ConstFalse();
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return Objects.equals(((EDouble) expr1).double_, ((EDouble) expr2).double_) ? new ConstTrue() : new ConstFalse();
        return null;
    }

    @Override
    public Expr gOrE(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return ((EInt) expr1).integer_ >= ((EInt) expr2).integer_ ? new ConstTrue() : new ConstFalse();
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return ((EDouble) expr1).double_ >= ((EDouble) expr2).double_ ? new ConstTrue() : new ConstFalse();
        return null;
    }

    @Override
    public Expr lOrE(Expr expr1, Expr expr2, Eval eval) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = eval.evalType((Var) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = eval.evalType((Var) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("FuncCall")) {
            expr1 = eval.evalType((FuncCall) expr1);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("FuncCall")) {
            expr2 = eval.evalType((FuncCall) expr2);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return ((EInt) expr1).integer_ <= ((EInt) expr2).integer_ ? new ConstTrue() : new ConstFalse();
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return ((EDouble) expr1).double_ <= ((EDouble) expr2).double_ ? new ConstTrue() : new ConstFalse();
        return null;
    }
}
