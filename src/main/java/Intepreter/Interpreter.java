package Intepreter;

import sample.Absyn.ListExpr;
import sample.Absyn.ProgramExprs;
import sample.PrettyPrinter;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Interpreter {
    private static String programFilePath;

    public Interpreter(String filePath) {
        Interpreter.programFilePath = filePath;
    }

    public void run() throws Exception {
        ProgramExprs programExprs = Interpreter.readFile(programFilePath);
        runProgram(programExprs);
    }

    public static void runProgram(ProgramExprs programExprs) {
        Eval eval = new EvalImpl();
        try {
            typeCheck(programExprs.listexpr_);
            var result = eval.evalProgram(programExprs);
            System.out.println();
            System.out.println(PrettyPrinter.print(result));
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ProgramExprs readFile(String filePath) throws Exception {
        Yylex l = null;
        parser parser;
        try
        {
            l = new Yylex(new FileReader(filePath));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Error: File not found: " + filePath);
            System.exit(1);
        }

        parser = new parser(l);
        ProgramExprs programExprs = ((ProgramExprs) parser.pProgram());
        return programExprs;
    }

    private static void typeCheck(ListExpr exprs) throws TypeException, UndefinedIdentifierExpression {
        var typeChecker = new TypeChecker();
        Context context = new Context();
        for (var expr : exprs) {
            String typeName = expr.getClass().getSimpleName();
            if (typeName.equals("Import")) {
                break;
            }
            var type = typeChecker.typeOf(context, expr);
        }
    }
}
