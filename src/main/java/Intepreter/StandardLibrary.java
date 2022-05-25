package Intepreter;

import sample.Absyn.Expr;

public interface StandardLibrary {
    Expr add(Expr expr1, Expr expr2, Eval eval);
    Expr sub(Expr expr1, Expr expr2, Eval eval);
    Expr mul(Expr expr1, Expr expr2, Eval eval);
    Expr div(Expr expr1, Expr expr2, Eval eval);
    Expr mod(Expr expr1, Expr expr2, Eval eval);
    Expr neg(Expr expr1, Eval eval);
    Expr exp(Expr expr1, Expr expr2, Eval eval);
    Expr greater(Expr expr1, Expr expr2, Eval eval);
    Expr less(Expr expr1, Expr expr2, Eval eval);
    Expr equal(Expr expr1, Expr expr2, Eval eval);
    Expr gOrE(Expr expr1, Expr expr2, Eval eval);
    Expr lOrE(Expr expr1, Expr expr2, Eval eval);
}
