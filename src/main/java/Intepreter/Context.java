package Intepreter;

import java.util.ArrayList;

public class Context {
    public ArrayList<Variable> variables;
    public ArrayList<Function> functions;
    public ArrayList<Table> tables;

    public ArrayList<AliasedTypes> aliasedTypes;

    public Context(){
        this.variables = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.aliasedTypes = new ArrayList<>();
    }
}
