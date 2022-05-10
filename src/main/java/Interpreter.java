import sample.parser;

import java.util.Scanner;
import java_cup.runtime.*;

public class Interpreter {
    private String program;

    public Interpreter(String program) {
        this.program = program;
    }

    public void run(){
        var p = new parser();
        try {
            sample.Absyn.Program program = p.pProgram();
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }

        /* create a parsing object */
        parser parser_obj = new parser();

        /* open input files, etc. here */
        Symbol parse_tree = null;

        try {
            if (do_debug_parse)
                parse_tree = parser_obj.debug_parse();
            else
                parse_tree = parser_obj.parse();
        } catch (Exception e) {
            /* do cleanup here - - possibly rethrow e */
        } finally {
            /* do close out here */
        }
    }
}
