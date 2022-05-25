package TypeCheckerTests;

import Intepreter.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sample.Absyn.*;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

public class FirstClassFuncTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/firstClassFuncTests.smpl");
    private static ListExpr exprs;
    private static TypeChecker typeChecker;

    @BeforeClass
    public static void setUp(){
        Yylex l = null;
        parser parser;
        try
        {
            l = new Yylex(new FileReader(filePathWithTests));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Error: File not found: " + filePathWithTests);
            System.exit(1);
        }

        parser = new parser(l);
        try {
            ProgramExprs programExprs = ((ProgramExprs) parser.pProgram());
            exprs = programExprs.listexpr_;
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }

        typeChecker = new TypeChecker();
    }

    @AfterClass
    public static void finished() {
    }

    @Test
    public void test_1() throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(0));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_2() throws TypeException, NameAlreadyUsedException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(1));
    }
}
