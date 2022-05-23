package Intepreter;

import sample.Absyn.Expr;

public interface StandardLibrary {
    Expr add(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr sub(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr mul(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr div(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr mod(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr neg(Expr expr1, VariableStorage variableStorage);
    Expr exp(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr greater(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr less(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr equal(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr gOrE(Expr expr1, Expr expr2, VariableStorage variableStorage);
    Expr lOrE(Expr expr1, Expr expr2, VariableStorage variableStorage);
}
