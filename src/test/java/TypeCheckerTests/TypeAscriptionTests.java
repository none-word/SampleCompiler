package TypeCheckerTests;

import Intepreter.Context;
import Intepreter.TypeChecker;
import Intepreter.TypeException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sample.Absyn.IntType;
import sample.Absyn.ListExpr;
import sample.Absyn.ProgramExprs;
import sample.Absyn.StringType;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

public class TypeAscriptionTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/typeAscriptionTests.smpl");
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
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(0));
        type = typeChecker.typeOf(context, exprs.get(1));
        type = typeChecker.typeOf(context, exprs.get(2));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_2() throws TypeException {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(3));
        type = typeChecker.typeOf(context, exprs.get(4));
    }

    @Test
    public void test_3() throws TypeException {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(5));
        type = typeChecker.typeOf(context, exprs.get(6));
        type = typeChecker.typeOf(context, exprs.get(7));
        type = typeChecker.typeOf(context, exprs.get(8));
        type = typeChecker.typeOf(context, exprs.get(9));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_4() throws TypeException {
        var context = new Context();
        var type = typeChecker.typeOf(context, exprs.get(10));
        type = typeChecker.typeOf(context, exprs.get(11));
        type = typeChecker.typeOf(context, exprs.get(12));
        type = typeChecker.typeOf(context, exprs.get(13));
    }
}
