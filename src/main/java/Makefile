JAVAC=javac
JAVAC_FLAGS=-sourcepath .
JAVA=java
JAVA_FLAGS=
CUP=java_cup.Main
CUPFLAGS=-nopositions -expect 100
JLEX=JLex.Main
all: test

test: absyn Sample/Yylex.class Sample/PrettyPrinter.class Sample/Test.class Sample/ComposVisitor.class Sample/AbstractVisitor.class Sample/FoldVisitor.class Sample/AllVisitor.class Sample/parser.class Sample/sym.class Sample/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: Sample/Absyn/Program.java Sample/Absyn/ProgramExprs.java Sample/Absyn/ListExpr.java Sample/Absyn/Expr.java Sample/Absyn/Var.java Sample/Absyn/ConstTrue.java Sample/Absyn/ConstFalse.java Sample/Absyn/If.java Sample/Absyn/EInt.java Sample/Absyn/EDouble.java Sample/Absyn/EStr.java Sample/Absyn/Not.java Sample/Absyn/And.java Sample/Absyn/Or.java Sample/Absyn/ConstZero.java Sample/Absyn/Succ.java Sample/Absyn/Pred.java Sample/Absyn/IsZero.java Sample/Absyn/OnlyDecl.java Sample/Absyn/InitDecl.java Sample/Absyn/Type.java Sample/Absyn/StringType.java Sample/Absyn/BoolType.java Sample/Absyn/UnitType.java Sample/Absyn/IntType.java Sample/Absyn/DoubleType.java Sample/Absyn/Dec.java Sample/Absyn/Declaration.java Sample/Absyn/LocalVarDeclaration.java
	${JAVAC} ${JAVAC_FLAGS} $^

Sample/Yylex.java: Sample/Yylex
	${JAVA} ${JAVA_FLAGS} ${JLEX} Sample/Yylex

Sample/sym.java Sample/parser.java: Sample/Sample.cup
	${JAVA} ${JAVA_FLAGS} ${CUP} ${CUPFLAGS} Sample/Sample.cup
	mv sym.java parser.java Sample/

Sample/Yylex.class: Sample/Yylex.java Sample/sym.java

Sample/sym.class: Sample/sym.java

Sample/parser.class: Sample/parser.java Sample/sym.java

Sample/PrettyPrinter.class: Sample/PrettyPrinter.java

clean:
	rm -f Sample/Absyn/*.class Sample/*.class

distclean: vclean

vclean:
	 rm -f Sample/Absyn/Program.java Sample/Absyn/ProgramExprs.java Sample/Absyn/ListExpr.java Sample/Absyn/Expr.java Sample/Absyn/Var.java Sample/Absyn/ConstTrue.java Sample/Absyn/ConstFalse.java Sample/Absyn/If.java Sample/Absyn/EInt.java Sample/Absyn/EDouble.java Sample/Absyn/EStr.java Sample/Absyn/Not.java Sample/Absyn/And.java Sample/Absyn/Or.java Sample/Absyn/ConstZero.java Sample/Absyn/Succ.java Sample/Absyn/Pred.java Sample/Absyn/IsZero.java Sample/Absyn/OnlyDecl.java Sample/Absyn/InitDecl.java Sample/Absyn/Type.java Sample/Absyn/StringType.java Sample/Absyn/BoolType.java Sample/Absyn/UnitType.java Sample/Absyn/IntType.java Sample/Absyn/DoubleType.java Sample/Absyn/Dec.java Sample/Absyn/Declaration.java Sample/Absyn/LocalVarDeclaration.java Sample/Absyn/Program.class Sample/Absyn/ProgramExprs.class Sample/Absyn/ListExpr.class Sample/Absyn/Expr.class Sample/Absyn/Var.class Sample/Absyn/ConstTrue.class Sample/Absyn/ConstFalse.class Sample/Absyn/If.class Sample/Absyn/EInt.class Sample/Absyn/EDouble.class Sample/Absyn/EStr.class Sample/Absyn/Not.class Sample/Absyn/And.class Sample/Absyn/Or.class Sample/Absyn/ConstZero.class Sample/Absyn/Succ.class Sample/Absyn/Pred.class Sample/Absyn/IsZero.class Sample/Absyn/OnlyDecl.class Sample/Absyn/InitDecl.class Sample/Absyn/Type.class Sample/Absyn/StringType.class Sample/Absyn/BoolType.class Sample/Absyn/UnitType.class Sample/Absyn/IntType.class Sample/Absyn/DoubleType.class Sample/Absyn/Dec.class Sample/Absyn/Declaration.class Sample/Absyn/LocalVarDeclaration.class
	 rm -f Sample/Absyn/*.class
	 rmdir Sample/Absyn/
	 rm -f Sample/Yylex Sample/Sample.cup Sample/Yylex.java Sample/VisitSkel.java Sample/ComposVisitor.java Sample/AbstractVisitor.java Sample/FoldVisitor.java Sample/AllVisitor.java Sample/PrettyPrinter.java Sample/Skeleton.java Sample/Test.java Sample/sym.java Sample/parser.java Sample/*.class
	rm -f Makefile
	rmdir -p Sample/

