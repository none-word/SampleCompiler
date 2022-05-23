package Intepreter;

import java.util.ArrayList;

public class Context {
    public ArrayList<Variable> variables;
    public ArrayList<Function> functions;
    public ArrayList<Table> tables;

    public Context(){
        this.variables = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.tables = new ArrayList<>();
    }
}
