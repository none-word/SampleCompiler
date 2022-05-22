package Intepreter;

import sample.Absyn.Expr;

public interface StandardLibrary {
    Expr add(Expr expr1, Expr expr2);
    Expr sub(Expr expr1, Expr expr2);
    Expr mul(Expr expr1, Expr expr2);
    Expr div(Expr expr1, Expr expr2);
    Expr neg(Expr expr1);
    Expr exp(Expr expr1, Expr expr2);
}
