package TypeCheckerTests;

import Intepreter.Context;
import Intepreter.GlobalContext;
import Intepreter.TypeChecker;
import Intepreter.TypeException;
import Intepreter.Utils.Pair;
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
import java.util.ArrayList;

public class IfTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/ifTests.smpl");
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
    public void test_1() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(0));
        Assert.assertTrue(typeChecker.isSameType(type, new VoidType()));
    }

    @Test
    public void test_2() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(1));
        Assert.assertTrue(typeChecker.isSameType(type, new VoidType()));
    }

    @Test
    public void test_3() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(2));
        type = typeChecker.typeOf(context, globalContext, exprs.get(3));

        Assert.assertTrue(typeChecker.isSameType(type, new VoidType()));
    }

    @Test(expected = TypeException.class)
    public void test_4() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(4));
        type = typeChecker.typeOf(context, globalContext, exprs.get(5));
    }
}
