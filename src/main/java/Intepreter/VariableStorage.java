package Intepreter;

import Intepreter.Utils.Pair;
import sample.Absyn.Expr;
import sample.Absyn.Type;

import java.util.HashMap;

public class VariableStorage {
    private static final HashMap<String, Pair<Type, Expr>> variableStorage = new HashMap<>();

    public Expr getVariable(String ident) {
        return variableStorage.get(ident).getValue();
    }

    public void saveVariable(String ident, Type type, Expr expr) {
        variableStorage.put(ident, new Pair<>(type, expr));
    }

    public void updateVariable(String ident, Expr expr) {
        Pair<Type, Expr> savedPair = variableStorage.get(ident);
        savedPair.setValue(expr);
    }
}
