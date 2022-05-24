package Intepreter;

import sample.Absyn.ListExpr;
import sample.Absyn.ProgramExprs;
import sample.PrettyPrinter;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Interpreter {
    private final String programFilePath;
    private final Eval eval = new EvalImpl();

    public Interpreter(String programFilePath) {
        this.programFilePath = programFilePath;
    }

    public void run(){

        Yylex l = null;
        parser parser;
        try
        {
            l = new Yylex(new FileReader(programFilePath));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Error: File not found: " + programFilePath);
            System.exit(1);
        }

        parser = new parser(l);
        try {
            ProgramExprs programExprs = ((ProgramExprs) parser.pProgram());
            typeCheck(programExprs.listexpr_);

            //System.out.println(sample.PrettyPrinter.show(ast));


            var result = eval.evalProgram(programExprs);
            System.out.println();
            System.out.println("Result: " + PrettyPrinter.print(result));
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }


    }

    private void typeCheck(ListExpr exprs) throws TypeException{
        var typeChecker = new TypeChecker();
        Context context = new Context();

        for (var expr : exprs) {
            var type = typeChecker.typeOf(context, expr);
        }
    }
}
