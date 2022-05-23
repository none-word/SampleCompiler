package sample;
import sample.Absyn.*;

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
  public static String print(sample.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.ListExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.ListExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.Expr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.Expr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.ComaExprs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.ComaExprs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.FArgs foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.FArgs foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.ListDec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.ListDec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.Type foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.Type foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.TypeKW foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.TypeKW foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.VarKW foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.VarKW foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.TAnnot foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.TAnnot foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.TAscript foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.TAscript foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.Dec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.Dec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(sample.Absyn.GlDec foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(sample.Absyn.GlDec foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(sample.Absyn.Program foo, int _i_)
  {
    if (foo instanceof sample.Absyn.ProgramExprs)
    {
       sample.Absyn.ProgramExprs _programexprs = (sample.Absyn.ProgramExprs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_programexprs.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.ListExpr foo, int _i_)
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

  private static void pp(sample.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof sample.Absyn.Var)
    {
       sample.Absyn.Var _var = (sample.Absyn.Var) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_var.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.ConstTrue)
    {
       sample.Absyn.ConstTrue _consttrue = (sample.Absyn.ConstTrue) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("true");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.ConstFalse)
    {
       sample.Absyn.ConstFalse _constfalse = (sample.Absyn.ConstFalse) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("false");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.If)
    {
       sample.Absyn.If _if = (sample.Absyn.If) foo;
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
    else     if (foo instanceof sample.Absyn.FuncCall)
    {
       sample.Absyn.FuncCall _funccall = (sample.Absyn.FuncCall) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_funccall.ident_, 0);
       render("(");
       pp(_funccall.comaexprs_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Func)
    {
       sample.Absyn.Func _func = (sample.Absyn.Func) foo;
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
    else     if (foo instanceof sample.Absyn.Return)
    {
       sample.Absyn.Return _return = (sample.Absyn.Return) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("return");
       pp(_return.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.NilKeyword)
    {
       sample.Absyn.NilKeyword _nilkeyword = (sample.Absyn.NilKeyword) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("nil");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Not)
    {
       sample.Absyn.Not _not = (sample.Absyn.Not) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("!");
       pp(_not.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.And)
    {
       sample.Absyn.And _and = (sample.Absyn.And) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_and.expr_1, 0);
       render("and");
       pp(_and.expr_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Or)
    {
       sample.Absyn.Or _or = (sample.Absyn.Or) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_or.expr_1, 0);
       render("or");
       pp(_or.expr_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.ConstZero)
    {
       sample.Absyn.ConstZero _constzero = (sample.Absyn.ConstZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Succ)
    {
       sample.Absyn.Succ _succ = (sample.Absyn.Succ) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("succ");
       pp(_succ.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Pred)
    {
       sample.Absyn.Pred _pred = (sample.Absyn.Pred) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("pred");
       pp(_pred.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.IsZero)
    {
       sample.Absyn.IsZero _iszero = (sample.Absyn.IsZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("iszero");
       pp(_iszero.expr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.TypeAliasing)
    {
       sample.Absyn.TypeAliasing _typealiasing = (sample.Absyn.TypeAliasing) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_typealiasing.ident_, 0);
       render(":");
       pp(_typealiasing.typekw_, 0);
       render("=");
       pp(_typealiasing.type_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.VarTypeAnnotation)
    {
       sample.Absyn.VarTypeAnnotation _vartypeannotation = (sample.Absyn.VarTypeAnnotation) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_vartypeannotation.ident_, 0);
       pp(_vartypeannotation.tannot_, 0);
       render("=");
       pp(_vartypeannotation.expr_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.FuncTypeAnnotation)
    {
       sample.Absyn.FuncTypeAnnotation _functypeannotation = (sample.Absyn.FuncTypeAnnotation) foo;
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
    else     if (foo instanceof sample.Absyn.VarTypeAscription)
    {
       sample.Absyn.VarTypeAscription _vartypeascription = (sample.Absyn.VarTypeAscription) foo;
       if (_i_ > 4) render(_L_PAREN);
       pp(_vartypeascription.ident_, 0);
       pp(_vartypeascription.tascript_, 0);
       render("=");
       pp(_vartypeascription.expr_, 0);
       if (_i_ > 4) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.FuncTypeAscription)
    {
       sample.Absyn.FuncTypeAscription _functypeascription = (sample.Absyn.FuncTypeAscription) foo;
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
    else     if (foo instanceof sample.Absyn.EInt)
    {
       sample.Absyn.EInt _eint = (sample.Absyn.EInt) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.EDouble)
    {
       sample.Absyn.EDouble _edouble = (sample.Absyn.EDouble) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_edouble.double_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.EStr)
    {
       sample.Absyn.EStr _estr = (sample.Absyn.EStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_estr.string_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.OnlyDecl)
    {
       sample.Absyn.OnlyDecl _onlydecl = (sample.Absyn.OnlyDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_onlydecl.dec_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.OnlyGlDecl)
    {
       sample.Absyn.OnlyGlDecl _onlygldecl = (sample.Absyn.OnlyGlDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_onlygldecl.gldec_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.InitDecl)
    {
       sample.Absyn.InitDecl _initdecl = (sample.Absyn.InitDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_initdecl.dec_, 0);
       render("=");
       pp(_initdecl.expr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.InitGlDecl)
    {
       sample.Absyn.InitGlDecl _initgldecl = (sample.Absyn.InitGlDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_initgldecl.gldec_, 0);
       render("=");
       pp(_initgldecl.expr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.InitTableDecl)
    {
       sample.Absyn.InitTableDecl _inittabledecl = (sample.Absyn.InitTableDecl) foo;
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
    else     if (foo instanceof sample.Absyn.InitGlTableDecl)
    {
       sample.Absyn.InitGlTableDecl _initgltabledecl = (sample.Absyn.InitGlTableDecl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_initgltabledecl.gldec_, 0);
       render("=");
       render("(");
       pp(_initgltabledecl.dec_1, 0);
       render(",");
       pp(_initgltabledecl.dec_2, 0);
       render(")");
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.Assignment)
    {
       sample.Absyn.Assignment _assignment = (sample.Absyn.Assignment) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_assignment.ident_, 0);
       render("=");
       pp(_assignment.expr_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.ComaExprs foo, int _i_)
  {
    if (foo instanceof sample.Absyn.Vars)
    {
       sample.Absyn.Vars _vars = (sample.Absyn.Vars) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vars.listexpr_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.FArgs foo, int _i_)
  {
    if (foo instanceof sample.Absyn.FuncArgs)
    {
       sample.Absyn.FuncArgs _funcargs = (sample.Absyn.FuncArgs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_funcargs.listdec_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.ListDec foo, int _i_)
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

  private static void pp(sample.Absyn.Type foo, int _i_)
  {
    if (foo instanceof sample.Absyn.StringType)
    {
       sample.Absyn.StringType _stringtype = (sample.Absyn.StringType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("string");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.BoolType)
    {
       sample.Absyn.BoolType _booltype = (sample.Absyn.BoolType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("boolean");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.IntType)
    {
       sample.Absyn.IntType _inttype = (sample.Absyn.IntType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("integer");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.DoubleType)
    {
       sample.Absyn.DoubleType _doubletype = (sample.Absyn.DoubleType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("double");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.TableType)
    {
       sample.Absyn.TableType _tabletype = (sample.Absyn.TableType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("table");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof sample.Absyn.VoidType)
    {
       sample.Absyn.VoidType _voidtype = (sample.Absyn.VoidType) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("void");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.TypeKW foo, int _i_)
  {
    if (foo instanceof sample.Absyn.TypeKeyword)
    {
       sample.Absyn.TypeKeyword _typekeyword = (sample.Absyn.TypeKeyword) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("type");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.VarKW foo, int _i_)
  {
    if (foo instanceof sample.Absyn.VarKeyword)
    {
       sample.Absyn.VarKeyword _varkeyword = (sample.Absyn.VarKeyword) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("var");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.TAnnot foo, int _i_)
  {
    if (foo instanceof sample.Absyn.TypeAnnotation)
    {
       sample.Absyn.TypeAnnotation _typeannotation = (sample.Absyn.TypeAnnotation) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":");
       pp(_typeannotation.varkw_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.TAscript foo, int _i_)
  {
    if (foo instanceof sample.Absyn.TypeAscription)
    {
       sample.Absyn.TypeAscription _typeascription = (sample.Absyn.TypeAscription) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_typeascription.tannot_, 0);
       render("(");
       pp(_typeascription.type_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.Dec foo, int _i_)
  {
    if (foo instanceof sample.Absyn.Declaration)
    {
       sample.Absyn.Declaration _declaration = (sample.Absyn.Declaration) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_declaration.ident_, 0);
       render(":");
       pp(_declaration.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(sample.Absyn.GlDec foo, int _i_)
  {
    if (foo instanceof sample.Absyn.GlDeclaration)
    {
       sample.Absyn.GlDeclaration _gldeclaration = (sample.Absyn.GlDeclaration) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("global");
       pp(_gldeclaration.ident_, 0);
       render(":");
       pp(_gldeclaration.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(sample.Absyn.Program foo)
  {
    if (foo instanceof sample.Absyn.ProgramExprs)
    {
       sample.Absyn.ProgramExprs _programexprs = (sample.Absyn.ProgramExprs) foo;
       render("(");
       render("ProgramExprs");
       render("[");
       sh(_programexprs.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(sample.Absyn.ListExpr foo)
  {
     for (java.util.Iterator<Expr> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(sample.Absyn.Expr foo)
  {
    if (foo instanceof sample.Absyn.Var)
    {
       sample.Absyn.Var _var = (sample.Absyn.Var) foo;
       render("(");
       render("Var");
       sh(_var.ident_);
       render(")");
    }
    if (foo instanceof sample.Absyn.ConstTrue)
    {
       sample.Absyn.ConstTrue _consttrue = (sample.Absyn.ConstTrue) foo;
       render("ConstTrue");
    }
    if (foo instanceof sample.Absyn.ConstFalse)
    {
       sample.Absyn.ConstFalse _constfalse = (sample.Absyn.ConstFalse) foo;
       render("ConstFalse");
    }
    if (foo instanceof sample.Absyn.If)
    {
       sample.Absyn.If _if = (sample.Absyn.If) foo;
       render("(");
       render("If");
       sh(_if.expr_);
       sh(_if.program_1);
       sh(_if.program_2);
       render(")");
    }
    if (foo instanceof sample.Absyn.FuncCall)
    {
       sample.Absyn.FuncCall _funccall = (sample.Absyn.FuncCall) foo;
       render("(");
       render("FuncCall");
       sh(_funccall.ident_);
       sh(_funccall.comaexprs_);
       render(")");
    }
    if (foo instanceof sample.Absyn.Func)
    {
       sample.Absyn.Func _func = (sample.Absyn.Func) foo;
       render("(");
       render("Func");
       sh(_func.ident_);
       sh(_func.fargs_);
       sh(_func.type_);
       sh(_func.program_);
       render(")");
    }
    if (foo instanceof sample.Absyn.Return)
    {
       sample.Absyn.Return _return = (sample.Absyn.Return) foo;
       render("(");
       render("Return");
       sh(_return.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.NilKeyword)
    {
       sample.Absyn.NilKeyword _nilkeyword = (sample.Absyn.NilKeyword) foo;
       render("NilKeyword");
    }
    if (foo instanceof sample.Absyn.Not)
    {
       sample.Absyn.Not _not = (sample.Absyn.Not) foo;
       render("(");
       render("Not");
       sh(_not.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.And)
    {
       sample.Absyn.And _and = (sample.Absyn.And) foo;
       render("(");
       render("And");
       sh(_and.expr_1);
       sh(_and.expr_2);
       render(")");
    }
    if (foo instanceof sample.Absyn.Or)
    {
       sample.Absyn.Or _or = (sample.Absyn.Or) foo;
       render("(");
       render("Or");
       sh(_or.expr_1);
       sh(_or.expr_2);
       render(")");
    }
    if (foo instanceof sample.Absyn.ConstZero)
    {
       sample.Absyn.ConstZero _constzero = (sample.Absyn.ConstZero) foo;
       render("ConstZero");
    }
    if (foo instanceof sample.Absyn.Succ)
    {
       sample.Absyn.Succ _succ = (sample.Absyn.Succ) foo;
       render("(");
       render("Succ");
       sh(_succ.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.Pred)
    {
       sample.Absyn.Pred _pred = (sample.Absyn.Pred) foo;
       render("(");
       render("Pred");
       sh(_pred.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.IsZero)
    {
       sample.Absyn.IsZero _iszero = (sample.Absyn.IsZero) foo;
       render("(");
       render("IsZero");
       sh(_iszero.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.TypeAliasing)
    {
       sample.Absyn.TypeAliasing _typealiasing = (sample.Absyn.TypeAliasing) foo;
       render("(");
       render("TypeAliasing");
       sh(_typealiasing.ident_);
       sh(_typealiasing.typekw_);
       sh(_typealiasing.type_);
       render(")");
    }
    if (foo instanceof sample.Absyn.VarTypeAnnotation)
    {
       sample.Absyn.VarTypeAnnotation _vartypeannotation = (sample.Absyn.VarTypeAnnotation) foo;
       render("(");
       render("VarTypeAnnotation");
       sh(_vartypeannotation.ident_);
       sh(_vartypeannotation.tannot_);
       sh(_vartypeannotation.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.FuncTypeAnnotation)
    {
       sample.Absyn.FuncTypeAnnotation _functypeannotation = (sample.Absyn.FuncTypeAnnotation) foo;
       render("(");
       render("FuncTypeAnnotation");
       sh(_functypeannotation.ident_);
       sh(_functypeannotation.fargs_);
       sh(_functypeannotation.tannot_);
       sh(_functypeannotation.program_);
       render(")");
    }
    if (foo instanceof sample.Absyn.VarTypeAscription)
    {
       sample.Absyn.VarTypeAscription _vartypeascription = (sample.Absyn.VarTypeAscription) foo;
       render("(");
       render("VarTypeAscription");
       sh(_vartypeascription.ident_);
       sh(_vartypeascription.tascript_);
       sh(_vartypeascription.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.FuncTypeAscription)
    {
       sample.Absyn.FuncTypeAscription _functypeascription = (sample.Absyn.FuncTypeAscription) foo;
       render("(");
       render("FuncTypeAscription");
       sh(_functypeascription.ident_);
       sh(_functypeascription.fargs_);
       sh(_functypeascription.tascript_);
       sh(_functypeascription.program_);
       render(")");
    }
    if (foo instanceof sample.Absyn.EInt)
    {
       sample.Absyn.EInt _eint = (sample.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof sample.Absyn.EDouble)
    {
       sample.Absyn.EDouble _edouble = (sample.Absyn.EDouble) foo;
       render("(");
       render("EDouble");
       sh(_edouble.double_);
       render(")");
    }
    if (foo instanceof sample.Absyn.EStr)
    {
       sample.Absyn.EStr _estr = (sample.Absyn.EStr) foo;
       render("(");
       render("EStr");
       sh(_estr.string_);
       render(")");
    }
    if (foo instanceof sample.Absyn.OnlyDecl)
    {
       sample.Absyn.OnlyDecl _onlydecl = (sample.Absyn.OnlyDecl) foo;
       render("(");
       render("OnlyDecl");
       sh(_onlydecl.dec_);
       render(")");
    }
    if (foo instanceof sample.Absyn.OnlyGlDecl)
    {
       sample.Absyn.OnlyGlDecl _onlygldecl = (sample.Absyn.OnlyGlDecl) foo;
       render("(");
       render("OnlyGlDecl");
       sh(_onlygldecl.gldec_);
       render(")");
    }
    if (foo instanceof sample.Absyn.InitDecl)
    {
       sample.Absyn.InitDecl _initdecl = (sample.Absyn.InitDecl) foo;
       render("(");
       render("InitDecl");
       sh(_initdecl.dec_);
       sh(_initdecl.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.InitGlDecl)
    {
       sample.Absyn.InitGlDecl _initgldecl = (sample.Absyn.InitGlDecl) foo;
       render("(");
       render("InitGlDecl");
       sh(_initgldecl.gldec_);
       sh(_initgldecl.expr_);
       render(")");
    }
    if (foo instanceof sample.Absyn.InitTableDecl)
    {
       sample.Absyn.InitTableDecl _inittabledecl = (sample.Absyn.InitTableDecl) foo;
       render("(");
       render("InitTableDecl");
       sh(_inittabledecl.dec_1);
       sh(_inittabledecl.dec_2);
       sh(_inittabledecl.dec_3);
       render(")");
    }
    if (foo instanceof sample.Absyn.InitGlTableDecl)
    {
       sample.Absyn.InitGlTableDecl _initgltabledecl = (sample.Absyn.InitGlTableDecl) foo;
       render("(");
       render("InitGlTableDecl");
       sh(_initgltabledecl.gldec_);
       sh(_initgltabledecl.dec_1);
       sh(_initgltabledecl.dec_2);
       render(")");
    }
    if (foo instanceof sample.Absyn.Assignment)
    {
       sample.Absyn.Assignment _assignment = (sample.Absyn.Assignment) foo;
       render("(");
       render("Assignment");
       sh(_assignment.ident_);
       sh(_assignment.expr_);
       render(")");
    }
  }

  private static void sh(sample.Absyn.ComaExprs foo)
  {
    if (foo instanceof sample.Absyn.Vars)
    {
       sample.Absyn.Vars _vars = (sample.Absyn.Vars) foo;
       render("(");
       render("Vars");
       render("[");
       sh(_vars.listexpr_);
       render("]");
       render(")");
    }
  }

  private static void sh(sample.Absyn.FArgs foo)
  {
    if (foo instanceof sample.Absyn.FuncArgs)
    {
       sample.Absyn.FuncArgs _funcargs = (sample.Absyn.FuncArgs) foo;
       render("(");
       render("FuncArgs");
       render("[");
       sh(_funcargs.listdec_);
       render("]");
       render(")");
    }
  }

  private static void sh(sample.Absyn.ListDec foo)
  {
     for (java.util.Iterator<Dec> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(sample.Absyn.Type foo)
  {
    if (foo instanceof sample.Absyn.StringType)
    {
       sample.Absyn.StringType _stringtype = (sample.Absyn.StringType) foo;
       render("StringType");
    }
    if (foo instanceof sample.Absyn.BoolType)
    {
       sample.Absyn.BoolType _booltype = (sample.Absyn.BoolType) foo;
       render("BoolType");
    }
    if (foo instanceof sample.Absyn.IntType)
    {
       sample.Absyn.IntType _inttype = (sample.Absyn.IntType) foo;
       render("IntType");
    }
    if (foo instanceof sample.Absyn.DoubleType)
    {
       sample.Absyn.DoubleType _doubletype = (sample.Absyn.DoubleType) foo;
       render("DoubleType");
    }
    if (foo instanceof sample.Absyn.TableType)
    {
       sample.Absyn.TableType _tabletype = (sample.Absyn.TableType) foo;
       render("TableType");
    }
    if (foo instanceof sample.Absyn.VoidType)
    {
       sample.Absyn.VoidType _voidtype = (sample.Absyn.VoidType) foo;
       render("VoidType");
    }
  }

  private static void sh(sample.Absyn.TypeKW foo)
  {
    if (foo instanceof sample.Absyn.TypeKeyword)
    {
       sample.Absyn.TypeKeyword _typekeyword = (sample.Absyn.TypeKeyword) foo;
       render("TypeKeyword");
    }
  }

  private static void sh(sample.Absyn.VarKW foo)
  {
    if (foo instanceof sample.Absyn.VarKeyword)
    {
       sample.Absyn.VarKeyword _varkeyword = (sample.Absyn.VarKeyword) foo;
       render("VarKeyword");
    }
  }

  private static void sh(sample.Absyn.TAnnot foo)
  {
    if (foo instanceof sample.Absyn.TypeAnnotation)
    {
       sample.Absyn.TypeAnnotation _typeannotation = (sample.Absyn.TypeAnnotation) foo;
       render("(");
       render("TypeAnnotation");
       sh(_typeannotation.varkw_);
       render(")");
    }
  }

  private static void sh(sample.Absyn.TAscript foo)
  {
    if (foo instanceof sample.Absyn.TypeAscription)
    {
       sample.Absyn.TypeAscription _typeascription = (sample.Absyn.TypeAscription) foo;
       render("(");
       render("TypeAscription");
       sh(_typeascription.tannot_);
       sh(_typeascription.type_);
       render(")");
    }
  }

  private static void sh(sample.Absyn.Dec foo)
  {
    if (foo instanceof sample.Absyn.Declaration)
    {
       sample.Absyn.Declaration _declaration = (sample.Absyn.Declaration) foo;
       render("(");
       render("Declaration");
       sh(_declaration.ident_);
       sh(_declaration.type_);
       render(")");
    }
  }

  private static void sh(sample.Absyn.GlDec foo)
  {
    if (foo instanceof sample.Absyn.GlDeclaration)
    {
       sample.Absyn.GlDeclaration _gldeclaration = (sample.Absyn.GlDeclaration) foo;
       render("(");
       render("GlDeclaration");
       sh(_gldeclaration.ident_);
       sh(_gldeclaration.type_);
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

