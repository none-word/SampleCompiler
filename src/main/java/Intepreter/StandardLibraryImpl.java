package Intepreter;

import sample.Absyn.*;

public class StandardLibraryImpl implements StandardLibrary {
    private final VariableStorage variableStorage = new VariableStorage();

    @Override
    public Expr add(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ + ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ + ((EDouble) expr2).double_);
        if (type1.equals("EStr") && type2.equals("EStr"))
            return new EStr(((EStr) expr1).string_ + ((EStr) expr2).string_);
        if (type1.equals("Var") && type2.equals("Var")) {
            Expr var1 = variableStorage.getVariable(((Var) expr1).ident_);
            Expr var2 = variableStorage.getVariable(((Var) expr2).ident_);
            return add(var1, var2);
        }
        if (type1.equals("Var") && type2.equals("EInt")) {
            Expr var1 = variableStorage.getVariable(((Var) expr1).ident_);
            return add(var1, expr2);
        }
        if (type1.equals("EInt") && type2.equals("Var")) {
            Expr var2 = variableStorage.getVariable(((Var) expr2).ident_);
            return add(expr1, var2);
        }
        return null;
    }

    @Override
    public Expr sub(Expr expr1, Expr expr2) {
        return null;
    }

    @Override
    public Expr mul(Expr expr1, Expr expr2) {
        return null;
    }

    @Override
    public Expr div(Expr expr1, Expr expr2) {
        return null;
    }

    @Override
    public Expr neg(Expr expr1, Expr expr2) {
        return null;
    }

    @Override
    public Expr exp(Expr expr1, Expr expr2) {
        return null;
    }
}
