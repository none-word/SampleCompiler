package Sample;
import Sample.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(Sample.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.ListExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.ListExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.Expr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.Expr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.ComaExprs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.ComaExprs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.FArgs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.FArgs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.ListDec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.ListDec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.TypeKW foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.TypeKW foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.VarKW foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.VarKW foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.TAnnot foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.TAnnot foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.TAscript foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.TAscript foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(Sample.Absyn.Dec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.Dec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(Sample.Absyn.Program foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.ProgramExprs)
    {
       Sample.Absyn.ProgramExprs _programexprs = (Sample.Absyn.ProgramExprs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_programexprs.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.ListExpr foo, int _i_)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }  }

  private static void pp(Sample.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Var)
    {
       Sample.Absyn.Var _var = (Sample.Absyn.Var) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_var.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.ConstTrue)
    {
       Sample.Absyn.ConstTrue _consttrue = (Sample.Absyn.ConstTrue) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.ConstFalse)
    {
       Sample.Absyn.ConstFalse _constfalse = (Sample.Absyn.ConstFalse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.If)
    {
       Sample.Absyn.If _if = (Sample.Absyn.If) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       pp(_if.expr_, 0);
       render("then");
       pp(_if.program_1, 0);
       render("else");
       pp(_if.program_2, 0);
       render("end");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.FuncCall)
    {
       Sample.Absyn.FuncCall _funccall = (Sample.Absyn.FuncCall) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_funccall.ident_, 0);
       render("(");
       pp(_funccall.comaexprs_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Func)
    {
       Sample.Absyn.Func _func = (Sample.Absyn.Func) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("function");
       pp(_func.ident_, 0);
       render("(");
       pp(_func.fargs_, 0);
       render(")");
       render(":");
       pp(_func.type_, 0);
       pp(_func.program_, 0);
       render("end");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Return)
    {
       Sample.Absyn.Return _return = (Sample.Absyn.Return) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("return");
       pp(_return.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Not)
    {
       Sample.Absyn.Not _not = (Sample.Absyn.Not) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("!");
       pp(_not.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.And)
    {
       Sample.Absyn.And _and = (Sample.Absyn.And) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_and.expr_1, 0);
       render("and");
       pp(_and.expr_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Or)
    {
       Sample.Absyn.Or _or = (Sample.Absyn.Or) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_or.expr_1, 0);
       render("or");
       pp(_or.expr_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.ConstZero)
    {
       Sample.Absyn.ConstZero _constzero = (Sample.Absyn.ConstZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Succ)
    {
       Sample.Absyn.Succ _succ = (Sample.Absyn.Succ) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("succ");
       pp(_succ.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Pred)
    {
       Sample.Absyn.Pred _pred = (Sample.Absyn.Pred) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("pred");
       pp(_pred.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.IsZero)
    {
       Sample.Absyn.IsZero _iszero = (Sample.Absyn.IsZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("iszero");
       pp(_iszero.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.TypeAliasing)
    {
       Sample.Absyn.TypeAliasing _typealiasing = (Sample.Absyn.TypeAliasing) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_typealiasing.ident_, 0);
       render(":");
       pp(_typealiasing.typekw_, 0);
       render("=");
       pp(_typealiasing.type_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.LcTypeAliasing)
    {
       Sample.Absyn.LcTypeAliasing _lctypealiasing = (Sample.Absyn.LcTypeAliasing) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("local");
       pp(_lctypealiasing.ident_, 0);
       render(":");
       pp(_lctypealiasing.typekw_, 0);
       render("=");
       pp(_lctypealiasing.type_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.VarTypeAnnotation)
    {
       Sample.Absyn.VarTypeAnnotation _vartypeannotation = (Sample.Absyn.VarTypeAnnotation) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_vartypeannotation.ident_, 0);
       pp(_vartypeannotation.tannot_, 0);
       render("=");
       pp(_vartypeannotation.expr_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.LcVarTypeAnnotation)
    {
       Sample.Absyn.LcVarTypeAnnotation _lcvartypeannotation = (Sample.Absyn.LcVarTypeAnnotation) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("local");
       pp(_lcvartypeannotation.ident_, 0);
       pp(_lcvartypeannotation.tannot_, 0);
       render("=");
       pp(_lcvartypeannotation.expr_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.FuncTypeAnnotation)
    {
       Sample.Absyn.FuncTypeAnnotation _functypeannotation = (Sample.Absyn.FuncTypeAnnotation) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("function");
       pp(_functypeannotation.ident_, 0);
       render("(");
       pp(_functypeannotation.fargs_, 0);
       render(")");
       pp(_functypeannotation.tannot_, 0);
       pp(_functypeannotation.program_, 0);
       render("end");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.VarTypeAscription)
    {
       Sample.Absyn.VarTypeAscription _vartypeascription = (Sample.Absyn.VarTypeAscription) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_vartypeascription.ident_, 0);
       pp(_vartypeascription.tascript_, 0);
       render("=");
       pp(_vartypeascription.expr_, 0);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.LcVarTypeAscription)
    {
       Sample.Absyn.LcVarTypeAscription _lcvartypeascription = (Sample.Absyn.LcVarTypeAscription) foo;
       if (_i_ > 4) render(_L_PAREN);
       render("local");
       pp(_lcvartypeascription.ident_, 0);
       pp(_lcvartypeascription.tascript_, 0);
       render("=");
       pp(_lcvartypeascription.expr_, 0);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.FuncTypeAscription)
    {
       Sample.Absyn.FuncTypeAscription _functypeascription = (Sample.Absyn.FuncTypeAscription) foo;
       if (_i_ > 4) render(_L_PAREN);
       render("function");
       pp(_functypeascription.ident_, 0);
       render("(");
       pp(_functypeascription.fargs_, 0);
       render(")");
       pp(_functypeascription.tascript_, 0);
       pp(_functypeascription.program_, 0);
       render("end");
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.EInt)
    {
       Sample.Absyn.EInt _eint = (Sample.Absyn.EInt) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.EDouble)
    {
       Sample.Absyn.EDouble _edouble = (Sample.Absyn.EDouble) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_edouble.double_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.EStr)
    {
       Sample.Absyn.EStr _estr = (Sample.Absyn.EStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_estr.string_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.OnlyDecl)
    {
       Sample.Absyn.OnlyDecl _onlydecl = (Sample.Absyn.OnlyDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_onlydecl.dec_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.InitDecl)
    {
       Sample.Absyn.InitDecl _initdecl = (Sample.Absyn.InitDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_initdecl.dec_, 0);
       render("=");
       pp(_initdecl.expr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.InitTableDecl)
    {
       Sample.Absyn.InitTableDecl _inittabledecl = (Sample.Absyn.InitTableDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_inittabledecl.dec_1, 0);
       render("=");
       render("(");
       pp(_inittabledecl.dec_2, 0);
       render(",");
       pp(_inittabledecl.dec_3, 0);
       render(")");
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.ComaExprs foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Vars)
    {
       Sample.Absyn.Vars _vars = (Sample.Absyn.Vars) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vars.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.FArgs foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.FuncArgs)
    {
       Sample.Absyn.FuncArgs _funcargs = (Sample.Absyn.FuncArgs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_funcargs.listdec_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.ListDec foo, int _i_)
  {
     for (java.util.Iterator<Dec> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(Sample.Absyn.Type foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.StringType)
    {
       Sample.Absyn.StringType _stringtype = (Sample.Absyn.StringType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("string");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.BoolType)
    {
       Sample.Absyn.BoolType _booltype = (Sample.Absyn.BoolType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("boolean");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.UnitType)
    {
       Sample.Absyn.UnitType _unittype = (Sample.Absyn.UnitType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("void");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.IntType)
    {
       Sample.Absyn.IntType _inttype = (Sample.Absyn.IntType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("integer");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.DoubleType)
    {
       Sample.Absyn.DoubleType _doubletype = (Sample.Absyn.DoubleType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("double");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.TableType)
    {
       Sample.Absyn.TableType _tabletype = (Sample.Absyn.TableType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("table");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.NilType)
    {
       Sample.Absyn.NilType _niltype = (Sample.Absyn.NilType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("nil");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.VoidType)
    {
       Sample.Absyn.VoidType _voidtype = (Sample.Absyn.VoidType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("void");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.TypeKW foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.TypeKeyword)
    {
       Sample.Absyn.TypeKeyword _typekeyword = (Sample.Absyn.TypeKeyword) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("type");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.VarKW foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.VarKeyword)
    {
       Sample.Absyn.VarKeyword _varkeyword = (Sample.Absyn.VarKeyword) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("var");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.TAnnot foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.TypeAnnotation)
    {
       Sample.Absyn.TypeAnnotation _typeannotation = (Sample.Absyn.TypeAnnotation) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":");
       pp(_typeannotation.varkw_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.TAscript foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.TypeAscription)
    {
       Sample.Absyn.TypeAscription _typeascription = (Sample.Absyn.TypeAscription) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_typeascription.tannot_, 0);
       render("(");
       pp(_typeascription.type_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.Dec foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Declaration)
    {
       Sample.Absyn.Declaration _declaration = (Sample.Absyn.Declaration) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_declaration.ident_, 0);
       render(":");
       pp(_declaration.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.LcVarDeclaration)
    {
       Sample.Absyn.LcVarDeclaration _lcvardeclaration = (Sample.Absyn.LcVarDeclaration) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("local");
       pp(_lcvardeclaration.ident_, 0);
       render(":");
       pp(_lcvardeclaration.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(Sample.Absyn.Program foo)
  {
    if (foo instanceof Sample.Absyn.ProgramExprs)
    {
       Sample.Absyn.ProgramExprs _programexprs = (Sample.Absyn.ProgramExprs) foo;
       render("(");
       render("ProgramExprs");
       render("[");
       sh(_programexprs.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(Sample.Absyn.ListExpr foo)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(Sample.Absyn.Expr foo)
  {
    if (foo instanceof Sample.Absyn.Var)
    {
       Sample.Absyn.Var _var = (Sample.Absyn.Var) foo;
       render("(");
       render("Var");
       sh(_var.ident_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.ConstTrue)
    {
       Sample.Absyn.ConstTrue _consttrue = (Sample.Absyn.ConstTrue) foo;
       render("ConstTrue");
    }
    if (foo instanceof Sample.Absyn.ConstFalse)
    {
       Sample.Absyn.ConstFalse _constfalse = (Sample.Absyn.ConstFalse) foo;
       render("ConstFalse");
    }
    if (foo instanceof Sample.Absyn.If)
    {
       Sample.Absyn.If _if = (Sample.Absyn.If) foo;
       render("(");
       render("If");
       sh(_if.expr_);
       sh(_if.program_1);
       sh(_if.program_2);
       render(")");
    }
    if (foo instanceof Sample.Absyn.FuncCall)
    {
       Sample.Absyn.FuncCall _funccall = (Sample.Absyn.FuncCall) foo;
       render("(");
       render("FuncCall");
       sh(_funccall.ident_);
       sh(_funccall.comaexprs_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Func)
    {
       Sample.Absyn.Func _func = (Sample.Absyn.Func) foo;
       render("(");
       render("Func");
       sh(_func.ident_);
       sh(_func.fargs_);
       sh(_func.type_);
       sh(_func.program_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Return)
    {
       Sample.Absyn.Return _return = (Sample.Absyn.Return) foo;
       render("(");
       render("Return");
       sh(_return.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Not)
    {
       Sample.Absyn.Not _not = (Sample.Absyn.Not) foo;
       render("(");
       render("Not");
       sh(_not.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.And)
    {
       Sample.Absyn.And _and = (Sample.Absyn.And) foo;
       render("(");
       render("And");
       sh(_and.expr_1);
       sh(_and.expr_2);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Or)
    {
       Sample.Absyn.Or _or = (Sample.Absyn.Or) foo;
       render("(");
       render("Or");
       sh(_or.expr_1);
       sh(_or.expr_2);
       render(")");
    }
    if (foo instanceof Sample.Absyn.ConstZero)
    {
       Sample.Absyn.ConstZero _constzero = (Sample.Absyn.ConstZero) foo;
       render("ConstZero");
    }
    if (foo instanceof Sample.Absyn.Succ)
    {
       Sample.Absyn.Succ _succ = (Sample.Absyn.Succ) foo;
       render("(");
       render("Succ");
       sh(_succ.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Pred)
    {
       Sample.Absyn.Pred _pred = (Sample.Absyn.Pred) foo;
       render("(");
       render("Pred");
       sh(_pred.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.IsZero)
    {
       Sample.Absyn.IsZero _iszero = (Sample.Absyn.IsZero) foo;
       render("(");
       render("IsZero");
       sh(_iszero.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.TypeAliasing)
    {
       Sample.Absyn.TypeAliasing _typealiasing = (Sample.Absyn.TypeAliasing) foo;
       render("(");
       render("TypeAliasing");
       sh(_typealiasing.ident_);
       sh(_typealiasing.typekw_);
       sh(_typealiasing.type_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.LcTypeAliasing)
    {
       Sample.Absyn.LcTypeAliasing _lctypealiasing = (Sample.Absyn.LcTypeAliasing) foo;
       render("(");
       render("LcTypeAliasing");
       sh(_lctypealiasing.ident_);
       sh(_lctypealiasing.typekw_);
       sh(_lctypealiasing.type_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.VarTypeAnnotation)
    {
       Sample.Absyn.VarTypeAnnotation _vartypeannotation = (Sample.Absyn.VarTypeAnnotation) foo;
       render("(");
       render("VarTypeAnnotation");
       sh(_vartypeannotation.ident_);
       sh(_vartypeannotation.tannot_);
       sh(_vartypeannotation.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.LcVarTypeAnnotation)
    {
       Sample.Absyn.LcVarTypeAnnotation _lcvartypeannotation = (Sample.Absyn.LcVarTypeAnnotation) foo;
       render("(");
       render("LcVarTypeAnnotation");
       sh(_lcvartypeannotation.ident_);
       sh(_lcvartypeannotation.tannot_);
       sh(_lcvartypeannotation.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.FuncTypeAnnotation)
    {
       Sample.Absyn.FuncTypeAnnotation _functypeannotation = (Sample.Absyn.FuncTypeAnnotation) foo;
       render("(");
       render("FuncTypeAnnotation");
       sh(_functypeannotation.ident_);
       sh(_functypeannotation.fargs_);
       sh(_functypeannotation.tannot_);
       sh(_functypeannotation.program_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.VarTypeAscription)
    {
       Sample.Absyn.VarTypeAscription _vartypeascription = (Sample.Absyn.VarTypeAscription) foo;
       render("(");
       render("VarTypeAscription");
       sh(_vartypeascription.ident_);
       sh(_vartypeascription.tascript_);
       sh(_vartypeascription.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.LcVarTypeAscription)
    {
       Sample.Absyn.LcVarTypeAscription _lcvartypeascription = (Sample.Absyn.LcVarTypeAscription) foo;
       render("(");
       render("LcVarTypeAscription");
       sh(_lcvartypeascription.ident_);
       sh(_lcvartypeascription.tascript_);
       sh(_lcvartypeascription.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.FuncTypeAscription)
    {
       Sample.Absyn.FuncTypeAscription _functypeascription = (Sample.Absyn.FuncTypeAscription) foo;
       render("(");
       render("FuncTypeAscription");
       sh(_functypeascription.ident_);
       sh(_functypeascription.fargs_);
       sh(_functypeascription.tascript_);
       sh(_functypeascription.program_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.EInt)
    {
       Sample.Absyn.EInt _eint = (Sample.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.EDouble)
    {
       Sample.Absyn.EDouble _edouble = (Sample.Absyn.EDouble) foo;
       render("(");
       render("EDouble");
       sh(_edouble.double_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.EStr)
    {
       Sample.Absyn.EStr _estr = (Sample.Absyn.EStr) foo;
       render("(");
       render("EStr");
       sh(_estr.string_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.OnlyDecl)
    {
       Sample.Absyn.OnlyDecl _onlydecl = (Sample.Absyn.OnlyDecl) foo;
       render("(");
       render("OnlyDecl");
       sh(_onlydecl.dec_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.InitDecl)
    {
       Sample.Absyn.InitDecl _initdecl = (Sample.Absyn.InitDecl) foo;
       render("(");
       render("InitDecl");
       sh(_initdecl.dec_);
       sh(_initdecl.expr_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.InitTableDecl)
    {
       Sample.Absyn.InitTableDecl _inittabledecl = (Sample.Absyn.InitTableDecl) foo;
       render("(");
       render("InitTableDecl");
       sh(_inittabledecl.dec_1);
       sh(_inittabledecl.dec_2);
       sh(_inittabledecl.dec_3);
       render(")");
    }
  }

  private static void sh(Sample.Absyn.ComaExprs foo)
  {
    if (foo instanceof Sample.Absyn.Vars)
    {
       Sample.Absyn.Vars _vars = (Sample.Absyn.Vars) foo;
       render("(");
       render("Vars");
       render("[");
       sh(_vars.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(Sample.Absyn.FArgs foo)
  {
    if (foo instanceof Sample.Absyn.FuncArgs)
    {
       Sample.Absyn.FuncArgs _funcargs = (Sample.Absyn.FuncArgs) foo;
       render("(");
       render("FuncArgs");
       render("[");
       sh(_funcargs.listdec_);
       render("]");
       render(")");
    }
  }

  private static void sh(Sample.Absyn.ListDec foo)
  {
     for (java.util.Iterator<Dec> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(Sample.Absyn.Type foo)
  {
    if (foo instanceof Sample.Absyn.StringType)
    {
       Sample.Absyn.StringType _stringtype = (Sample.Absyn.StringType) foo;
       render("StringType");
    }
    if (foo instanceof Sample.Absyn.BoolType)
    {
       Sample.Absyn.BoolType _booltype = (Sample.Absyn.BoolType) foo;
       render("BoolType");
    }
    if (foo instanceof Sample.Absyn.UnitType)
    {
       Sample.Absyn.UnitType _unittype = (Sample.Absyn.UnitType) foo;
       render("UnitType");
    }
    if (foo instanceof Sample.Absyn.IntType)
    {
       Sample.Absyn.IntType _inttype = (Sample.Absyn.IntType) foo;
       render("IntType");
    }
    if (foo instanceof Sample.Absyn.DoubleType)
    {
       Sample.Absyn.DoubleType _doubletype = (Sample.Absyn.DoubleType) foo;
       render("DoubleType");
    }
    if (foo instanceof Sample.Absyn.TableType)
    {
       Sample.Absyn.TableType _tabletype = (Sample.Absyn.TableType) foo;
       render("TableType");
    }
    if (foo instanceof Sample.Absyn.NilType)
    {
       Sample.Absyn.NilType _niltype = (Sample.Absyn.NilType) foo;
       render("NilType");
    }
    if (foo instanceof Sample.Absyn.VoidType)
    {
       Sample.Absyn.VoidType _voidtype = (Sample.Absyn.VoidType) foo;
       render("VoidType");
    }
  }

  private static void sh(Sample.Absyn.TypeKW foo)
  {
    if (foo instanceof Sample.Absyn.TypeKeyword)
    {
       Sample.Absyn.TypeKeyword _typekeyword = (Sample.Absyn.TypeKeyword) foo;
       render("TypeKeyword");
    }
  }

  private static void sh(Sample.Absyn.VarKW foo)
  {
    if (foo instanceof Sample.Absyn.VarKeyword)
    {
       Sample.Absyn.VarKeyword _varkeyword = (Sample.Absyn.VarKeyword) foo;
       render("VarKeyword");
    }
  }

  private static void sh(Sample.Absyn.TAnnot foo)
  {
    if (foo instanceof Sample.Absyn.TypeAnnotation)
    {
       Sample.Absyn.TypeAnnotation _typeannotation = (Sample.Absyn.TypeAnnotation) foo;
       render("(");
       render("TypeAnnotation");
       sh(_typeannotation.varkw_);
       render(")");
    }
  }

  private static void sh(Sample.Absyn.TAscript foo)
  {
    if (foo instanceof Sample.Absyn.TypeAscription)
    {
       Sample.Absyn.TypeAscription _typeascription = (Sample.Absyn.TypeAscription) foo;
       render("(");
       render("TypeAscription");
       sh(_typeascription.tannot_);
       sh(_typeascription.type_);
       render(")");
    }
  }

  private static void sh(Sample.Absyn.Dec foo)
  {
    if (foo instanceof Sample.Absyn.Declaration)
    {
       Sample.Absyn.Declaration _declaration = (Sample.Absyn.Declaration) foo;
       render("(");
       render("Declaration");
       sh(_declaration.ident_);
       sh(_declaration.type_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.LcVarDeclaration)
    {
       Sample.Absyn.LcVarDeclaration _lcvardeclaration = (Sample.Absyn.LcVarDeclaration) foo;
       render("(");
       render("LcVarDeclaration");
       sh(_lcvardeclaration.ident_);
       sh(_lcvardeclaration.type_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

