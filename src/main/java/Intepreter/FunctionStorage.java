package Intepreter;

import Intepreter.Utils.Pair;
import sample.Absyn.FuncArgs;
import sample.Absyn.Program;
import sample.Absyn.Type;

import java.util.HashMap;

public class FunctionStorage {
    private static final HashMap<String, Pair<Pair<FuncArgs, Type>, Program>> functionStorage = new HashMap<>();

    public Program getFunction(String ident) {
        return functionStorage.get(ident).getValue();
    }

    public FuncArgs getArguments(String ident) {
        return functionStorage.get(ident).getKey().getKey();
    }

    public void saveFunction(String ident, FuncArgs args, Type type, Program program) {
        functionStorage.put(ident, new Pair<>(new Pair<>(args, type), program));
    }
}
