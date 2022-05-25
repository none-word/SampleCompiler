package Intepreter;

import sample.Absyn.FuncArgs;
import sample.Absyn.Type;

public class Function{
    public String ident;
    public Type returnType;
    public FuncArgs args;

    public Function(String ident, Type returnType, FuncArgs args){
        this.ident = ident;
        this.returnType = returnType;
        this.args = args;
    }
}