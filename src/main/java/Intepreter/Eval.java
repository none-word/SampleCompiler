package Intepreter;

import sample.Absyn.Expr;

import java.lang.reflect.Method;

public interface Eval {
    Expr evalStep(Expr expr);
}