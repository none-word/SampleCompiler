package Intepreter;

import sample.Absyn.*;
import sample.Yylex;
import sample.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Interpreter {
    private final String programFilePath;
    private final Eval eval = new EvalImpl();

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
            ProgramExprs programExprs = ((ProgramExprs) parser.pProgram());
            typeCheck(programExprs.listexpr_);

            //System.out.println(sample.PrettyPrinter.show(ast));


//            var result = eval.evalProgram(programExprs);
//            System.out.println();
//            System.out.println("Result: " + PrettyPrinter.print(result));
        }
        catch (Exception e){
            System.out.println("Parse error in line " + e.getMessage());
        }


    }

    private void typeCheck(ListExpr exprs) throws TypeException{
        var typeChecker = new TypeChecker();
        Context context = new Context();
        addBultInFunctions(context);
        for (var expr : exprs) {
            var type = typeChecker.typeOf(context, expr);
        }
    }

    private void addBultInFunctions(Context context) {
        ListDec intListDec = new ListDec();
        intListDec.addAll(Arrays.asList(new Declaration("a", new IntType()), new Declaration("b", new IntType())));
        context.functions.add(new Function("add", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("sub", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("mul", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("div", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("mod", new IntType(), new FuncArgs(intListDec)));
        context.functions.add(new Function("exp", new IntType(), new FuncArgs(intListDec)));
        relationsOperations(context, intListDec);

        ListDec doubleListDec = new ListDec();
        doubleListDec.addAll(Arrays.asList(new Declaration("a", new DoubleType()), new Declaration("b", new DoubleType())));
        context.functions.add(new Function("add", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("sub", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("mul", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("div", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("mod", new DoubleType(), new FuncArgs(doubleListDec)));
        context.functions.add(new Function("exp", new DoubleType(), new FuncArgs(doubleListDec)));
        relationsOperations(context, doubleListDec);

        ListDec oneDeclIntList = new ListDec();
        oneDeclIntList.add(new Declaration("a", new IntType()));
        context.functions.add(new Function("neg", new IntType(), new FuncArgs(oneDeclIntList)));

        ListDec oneDeclDoubleList = new ListDec();
        oneDeclDoubleList.add(new Declaration("a", new DoubleType()));
        context.functions.add(new Function("neg", new DoubleType(), new FuncArgs(oneDeclDoubleList)));

        ListDec printDecList = new ListDec();
        context.functions.add(new Function("print", new VoidType(), new FuncArgs(printDecList)));

        ListDec strListDec = new ListDec();
        strListDec.addAll(Arrays.asList(new Declaration("a", new StringType()), new Declaration("b", new StringType())));
        context.functions.add(new Function("add", new StringType(), new FuncArgs(strListDec)));
        relationsOperations(context, strListDec);
    }

    private void relationsOperations(Context context, ListDec listDec) {
        context.functions.add(new Function("greater", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("less", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("equal", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("gOrE", new BoolType(), new FuncArgs(listDec)));
        context.functions.add(new Function("lOrE", new BoolType(), new FuncArgs(listDec)));
    }
}
