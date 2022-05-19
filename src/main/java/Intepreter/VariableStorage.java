package Intepreter;

import Intepreter.Utils.Pair;
import sample.Absyn.Declaration;
import sample.Absyn.Expr;
import sample.Absyn.Type;

import java.util.HashMap;
import java.util.Objects;

public class VariableStorage {
    private static final HashMap<String, Pair<Type, Expr>> storage = new HashMap<>();

    public Expr getVariable(String ident) {
        return storage.get(ident).getValue();
    }

    public void saveVariable(String ident, Type type, Expr expr) {
        storage.put(ident, new Pair<>(type, expr));
    }
}
