package Intepreter;

import sample.Absyn.Type;

public class Variable{
    public String ident;
    public Type type;

    public Variable(String ident, Type type) {
        this.ident = ident;
        this.type = type;
    }
}
