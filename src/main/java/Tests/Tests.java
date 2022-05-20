package Tests;
import Intepreter.Interpreter;
import org.junit.*;
import sample.Absyn.ProgramExprs;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Tests {

    @BeforeClass
    public static void setUp(){
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

    @AfterClass
    public static void finished() {
    }

    @Test
    public void testFunctionTypes(){
        var programFilePath = "./funcTest_1.smpl";

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
}
