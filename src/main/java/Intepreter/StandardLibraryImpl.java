package Intepreter;

import sample.Absyn.*;

public class StandardLibraryImpl implements StandardLibrary {
    private final VariableStorage variableStorage = new VariableStorage();

    @Override
    public Expr add(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = variableStorage.getVariable(((Var) expr2).ident_);
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
    public Expr sub(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = variableStorage.getVariable(((Var) expr2).ident_);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ - ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ - ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr mul(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = variableStorage.getVariable(((Var) expr2).ident_);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ * ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ * ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr div(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = variableStorage.getVariable(((Var) expr2).ident_);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ / ((EInt) expr2).integer_);
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ / ((EDouble) expr2).double_);
        return null;
    }

    @Override
    public Expr neg(Expr expr1) {
        String type1 = expr1.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type1.equals("EInt"))
            return new EInt(((EInt) expr1).integer_ * (-1));
        if (type1.equals("EDouble"))
            return new EDouble(((EDouble) expr1).double_ * (-1));
        return null;
    }

    @Override
    public Expr exp(Expr expr1, Expr expr2) {
        String type1 = expr1.getClass().getSimpleName();
        String type2 = expr2.getClass().getSimpleName();
        if (type1.equals("Var")) {
            expr1 = variableStorage.getVariable(((Var) expr1).ident_);
            type1 = expr1.getClass().getSimpleName();
        }
        if (type2.equals("Var")) {
            expr2 = variableStorage.getVariable(((Var) expr2).ident_);
            type2 = expr2.getClass().getSimpleName();
        }
        if (type1.equals("EInt") && type2.equals("EInt"))
            return new EInt((int) Math.pow(((EInt) expr1).integer_, ((EInt) expr2).integer_));
        if (type1.equals("EDouble") && type2.equals("EDouble"))
            return new EDouble(Math.pow(((EDouble) expr1).double_, ((EDouble) expr2).double_));
        return null;
    }
}
