package Intepreter.Storage;

import Intepreter.Utils.Pair;
import sample.Absyn.Expr;
import sample.Absyn.Type;

import java.util.HashMap;

public class VariableStorage {
    private static final HashMap<String, Pair<Type, Expr>> globalVariableStorage = new HashMap<>();
    private final HashMap<String, Pair<Type, Expr>> variableStorage = new HashMap<>();

    public Expr getVariable(String ident) {
        Pair<Type, Expr> localVariable = variableStorage.get(ident);
        Pair<Type, Expr> globalVariable = globalVariableStorage.get(ident);
        return localVariable == null ? globalVariable.getValue() : localVariable.getValue();
    }

    public void saveVariable(String ident, Type type, Expr expr) {
        variableStorage.put(ident, new Pair<>(type, expr));
    }

    public void saveGlobalVariable(String ident, Type type, Expr expr) {
        globalVariableStorage.put(ident, new Pair<>(type, expr));
    }

    public void updateVariable(String ident, Expr expr) {
        Pair<Type, Expr> localVariable = variableStorage.get(ident);
        Pair<Type, Expr> globalVariable = globalVariableStorage.get(ident);
        if (localVariable == null){
            globalVariable.setValue(expr);
        } else {
            localVariable.setValue(expr);
        }
    }

    public void updateGlobalVariable(String ident, Expr expr) {
        Pair<Type, Expr> savedPair = variableStorage.get(ident);
        savedPair.setValue(expr);
    }
}
