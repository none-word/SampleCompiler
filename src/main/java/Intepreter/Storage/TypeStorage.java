package Intepreter.Storage;

import sample.Absyn.Type;

import java.util.HashMap;

public class TypeStorage {
    private static final HashMap<String, Type> globalTypeStorage = new HashMap<>();
    private final HashMap<String, Type> typeStorage = new HashMap<>();

    public Type getType(String ident) {
        Type localType = typeStorage.get(ident);
        Type globalType = globalTypeStorage.get(ident);
        return localType == null ? globalType : localType;
    }

    public void saveType(String ident, Type type) {
        typeStorage.put(ident, type);
    }

    public void saveGlobalType(String ident, Type type) {
        globalTypeStorage.put(ident, type);
    }

    public void updateType(String ident, Type type) {
        Type localVariable = typeStorage.get(ident);
        if (localVariable == null){
            globalTypeStorage.put(ident, type);
        } else {
            typeStorage.put(ident, type);
        }
    }

    public void updateGlobalType(String ident, Type type) {
        typeStorage.put(ident, type);
    }
}
