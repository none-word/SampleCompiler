package TypeCheckerTests;
import Intepreter.TypeChecker;
import Intepreter.TypeException;
import org.junit.*;
import sample.Absyn.*;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncTests {
    private static final String filePathWithTests = System.getProperty("user.dir") + Paths.get("/src/test/java/TypeCheckerTests/TestFiles/funcTests.smpl");
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
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(0));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test
    public void test_2() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(1));
        Assert.assertTrue(typeChecker.isSameType(type, new BoolType()));
    }

    @Test(expected = TypeException.class)
    public void test_3() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(2));
    }

    @Test
    public void test_4() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(3));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test
    public void test_5() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(4));
        Assert.assertTrue(typeChecker.isSameType(type, new IntType()));
    }

    @Test(expected = TypeException.class)
    public void test_6() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(5));
    }

    @Test
    public void test_7() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(6));
        Assert.assertTrue(typeChecker.isSameType(type, new VoidType()));
    }

    @Test(expected = TypeException.class)
    public void test_8() throws TypeException {
        var type = typeChecker.typeOf(new ArrayList<TypeChecker.Variable>(), exprs.get(7));
    }
}
