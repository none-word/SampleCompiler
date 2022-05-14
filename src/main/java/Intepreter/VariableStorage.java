package Intepreter;

import sample.Absyn.Declaration;
import sample.Absyn.Expr;

import java.util.HashMap;

public class VariableStorage {
    private static final HashMap<Declaration, Object> storage = new HashMap<>();

    public static Object getVariable(Declaration declaration) {
        return storage.get(declaration);
    }

    public static Object saveVariable(Declaration declaration, Object value) {
        return storage.put(declaration, value);
    }
}
