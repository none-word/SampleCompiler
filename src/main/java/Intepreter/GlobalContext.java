package Intepreter;

import java.util.ArrayList;

public class GlobalContext {
    public ArrayList<Variable> variables;
    public ArrayList<Table> tables;

    public GlobalContext(){
        this.variables = new ArrayList<>();
        this.tables = new ArrayList<>();
    }
}
