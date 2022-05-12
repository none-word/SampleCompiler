import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Interpreter {
    private final String programFilePath;

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
            sample.Absyn.Program ast = parser.pProgram();
            System.out.println(sample.PrettyPrinter.show(ast));
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }


    }
}
