package Intepreter;

import sample.Absyn.FuncArgs;
import sample.Absyn.Type;

public class Table{
    public String ident;
    public Type type;
    public Variable variable_1;
    public Variable variable_2;

    public Table(String ident, Type type, Variable variable_1, Variable variable_2){
        this.ident = ident;
        this.type = type;
        this.variable_1 = variable_1;
        this.variable_2 = variable_2;
    }
}
