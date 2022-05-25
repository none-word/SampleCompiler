package TypeCheckerTests;

import Intepreter.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sample.Absyn.BoolType;
import sample.Absyn.ListExpr;
import sample.Absyn.ProgramExprs;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

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
    public void test_1() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(0));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_2() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(1));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_3() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(2));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_4() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(3));
    }

    @Test(expected = TypeException.class)
    public void test_5() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(4));
    }

    @Test(expected = TypeException.class)
    public void test_6() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(5));
    }

    @Test
    public void test_7() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(6));
        type = typeChecker.typeOf(context, exprs.get(7));
        type = typeChecker.typeOf(context, exprs.get(8));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_8() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(9));
        type = typeChecker.typeOf(context, exprs.get(10));
        type = typeChecker.typeOf(context, exprs.get(11));
    }

    @Test
    public void test_9() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(12));
        type = typeChecker.typeOf(context, exprs.get(13));
        type = typeChecker.typeOf(context, exprs.get(14));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_10() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(15));
        type = typeChecker.typeOf(context, exprs.get(16));
        type = typeChecker.typeOf(context, exprs.get(17));
    }

    @Test
    public void test_11() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(18));
        type = typeChecker.typeOf(context, exprs.get(19));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_12() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(20));
        type = typeChecker.typeOf(context, exprs.get(21));

        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }
}
