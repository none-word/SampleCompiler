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
import sample.Absyn.BoolType;
import sample.Absyn.ListExpr;
import sample.Absyn.ProgramExprs;
import sample.Absyn.VoidType;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LogicOperationsTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/logicOperationsTests.smpl");
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
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_2() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(1));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_3() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(2));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_4() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(3));
    }

    @Test(expected = TypeException.class)
    public void test_5() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(4));
    }

    @Test(expected = TypeException.class)
    public void test_6() throws TypeException {
        var type = typeChecker.typeOf(new Context(), new GlobalContext(), exprs.get(5));
    }

    @Test
    public void test_7() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(6));
        type = typeChecker.typeOf(context, globalContext, exprs.get(7));
        type = typeChecker.typeOf(context, globalContext, exprs.get(8));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_8() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(9));
        type = typeChecker.typeOf(context, globalContext, exprs.get(10));
        type = typeChecker.typeOf(context, globalContext, exprs.get(11));
    }

    @Test
    public void test_9() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(12));
        type = typeChecker.typeOf(context, globalContext, exprs.get(13));
        type = typeChecker.typeOf(context, globalContext, exprs.get(14));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_10() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(15));
        type = typeChecker.typeOf(context, globalContext, exprs.get(16));
        type = typeChecker.typeOf(context, globalContext, exprs.get(17));
    }

    @Test
    public void test_11() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(18));
        type = typeChecker.typeOf(context, globalContext, exprs.get(19));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_12() throws TypeException {
        var context = new Context();
        var globalContext = new GlobalContext();
        var type = typeChecker.typeOf(context, globalContext, exprs.get(20));
        type = typeChecker.typeOf(context, globalContext, exprs.get(21));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }
}
