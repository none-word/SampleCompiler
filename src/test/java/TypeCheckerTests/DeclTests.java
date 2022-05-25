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

public class DeclTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/declTests.smpl");
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
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_2() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(1));
    }

    @Test
    public void test_3() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(2));
        Assert.assertTrue(typeChecker.isSameType(type, new StringType()));
    }

    @Test
    public void test_4() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(3));
        type = typeChecker.typeOf(context, exprs.get(4));

        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_5() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(5));
        type = typeChecker.typeOf(context, exprs.get(6));
    }

    @Test
    public void test_6() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(7));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_7() throws TypeException, UndefinedIdentifierExpression {
        var type = typeChecker.typeOf(new Context(), exprs.get(8));
    }

    @Test
    public void test_8() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(9));
        type = typeChecker.typeOf(context, exprs.get(10));
        type = typeChecker.typeOf(context, exprs.get(11));

        Assert.assertTrue(typeChecker.isSameType(type, new VoidType()));
    }

    @Test(expected = TypeException.class)
    public void test_9() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(12));
        type = typeChecker.typeOf(context, exprs.get(13));
        type = typeChecker.typeOf(context, exprs.get(14));
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
        var type = typeChecker.typeOf(new Context(), exprs.get(18));
        Assert.assertTrue(typeChecker.isSameType(type, new TableType()));
    }

    @Test
    public void test_12() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(19));
        type = typeChecker.typeOf(context, exprs.get(20));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test
    public void test_13() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(21));
        type = typeChecker.typeOf(context, exprs.get(22));
        type = typeChecker.typeOf(context, exprs.get(23));
        Assert.assertTrue(typeChecker.isSameType(type, new TableType()));
    }

    @Test
    public void test_14() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(24));
        type = typeChecker.typeOf(context, exprs.get(25));
        type = typeChecker.typeOf(context, exprs.get(26));
        type = typeChecker.typeOf(context, exprs.get(27));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_15() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(28));
        type = typeChecker.typeOf(context, exprs.get(29));
        type = typeChecker.typeOf(context, exprs.get(30));
        type = typeChecker.typeOf(context, exprs.get(31));
        type = typeChecker.typeOf(context, exprs.get(32));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test
    public void test_16() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(33));
        type = typeChecker.typeOf(context, exprs.get(34));
        type = typeChecker.typeOf(context, exprs.get(35));
        type = typeChecker.typeOf(context, exprs.get(36));
        type = typeChecker.typeOf(context, exprs.get(37));
        Assert.assertTrue(typeChecker.isSameType(type, new TableType()));
    }

    @Test(expected = TypeException.class)
    public void test_17() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(38));
        type = typeChecker.typeOf(context, exprs.get(39));
        type = typeChecker.typeOf(context, exprs.get(40));
        type = typeChecker.typeOf(context, exprs.get(41));
        type = typeChecker.typeOf(context, exprs.get(42));
    }

    @Test(expected = TypeException.class)
    public void test_18() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(43));
        type = typeChecker.typeOf(context, exprs.get(44));
        type = typeChecker.typeOf(context, exprs.get(45));
        type = typeChecker.typeOf(context, exprs.get(46));
        type = typeChecker.typeOf(context, exprs.get(47));
    }
    @Test
    public void test_19() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(48));
        type = typeChecker.typeOf(context, exprs.get(49));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test
    public void test_20() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(50));
        type = typeChecker.typeOf(context, exprs.get(51));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test
    public void test_21() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(52));
        type = typeChecker.typeOf(context, exprs.get(53));
        type = typeChecker.typeOf(context, exprs.get(54));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_22() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(55));
        type = typeChecker.typeOf(context, exprs.get(56));
    }

    @Test(expected = TypeException.class)
    public void test_23() throws TypeException, UndefinedIdentifierExpression {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(55));
        type = typeChecker.typeOf(context, exprs.get(56));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }
}
