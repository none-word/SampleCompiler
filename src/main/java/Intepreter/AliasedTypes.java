package Intepreter;

import sample.Absyn.Type;

public class AliasedTypes {
    public String ident;
    public Type aliasedType;

    public AliasedTypes(String ident, Type aliasedType) {
        this.ident = ident;
        this.aliasedType = aliasedType;
    }
}
