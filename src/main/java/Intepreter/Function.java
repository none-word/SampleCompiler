package Intepreter;

import sample.Absyn.FuncArgs;
import sample.Absyn.Type;

public class Function{
    public String ident;
    public Type type;
    public FuncArgs args;

    public Function(String ident, Type type, FuncArgs args){
        this.ident = ident;
        this.type = type;
        this.args = args;
    }
}