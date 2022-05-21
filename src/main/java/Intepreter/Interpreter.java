package Intepreter;

import sample.Absyn.Expr;
import sample.Absyn.ProgramExprs;
import sample.PrettyPrinter;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
            //System.out.println(sample.PrettyPrinter.show(ast));

            for (var expr : programExprs.listexpr_) {
                evalAndTypeCheck(expr);
            }
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }


    }

    private void evalAndTypeCheck(Expr expr){
        try {
            var typeChecker = new TypeChecker();
            var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), expr);
            var result = eval.evalExpr(expr);
            System.out.print(PrettyPrinter.print(expr));
            System.out.print(" has type ");
            if (type != null)
                System.out.println(PrettyPrinter.print(type));
            else
                System.out.println("null");
            System.out.println("Result: " + PrettyPrinter.print(result));
            System.out.println("\n");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
