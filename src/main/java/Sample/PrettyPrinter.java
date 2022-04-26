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
  public static String print(Sample.Absyn.Assignment_op foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.Assignment_op foo)
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
  public static String print(Sample.Absyn.FieldTypeExpr foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Sample.Absyn.FieldTypeExpr foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(Sample.Absyn.Expr foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Vary)
    {
       Sample.Absyn.Vary _vary = (Sample.Absyn.Vary) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vary.ident_, 0);
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
       pp(_if.expr_1, 0);
       render("then");
       pp(_if.expr_2, 0);
       render("else");
       pp(_if.expr_3, 0);
       render("end");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Binding)
    {
       Sample.Absyn.Binding _binding = (Sample.Absyn.Binding) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_binding.ident_, 0);
       render(":");
       pp(_binding.type_, 0);
       render("=");
       pp(_binding.expr_, 0);
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
    else     if (foo instanceof Sample.Absyn.Var)
    {
       Sample.Absyn.Var _var = (Sample.Absyn.Var) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_var.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Sample.Absyn.Application)
    {
       Sample.Absyn.Application _application = (Sample.Absyn.Application) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_application.expr_1, 0);
       pp(_application.expr_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.Assignment_op foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Assign)
    {
       Sample.Absyn.Assign _assign = (Sample.Absyn.Assign) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("=");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(Sample.Absyn.Dec foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.Declarators)
    {
       Sample.Absyn.Declarators _declarators = (Sample.Absyn.Declarators) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_declarators.ident_, 0);
       render(":");
       pp(_declarators.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

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
  }

  private static void pp(Sample.Absyn.FieldTypeExpr foo, int _i_)
  {
    if (foo instanceof Sample.Absyn.FieldType)
    {
       Sample.Absyn.FieldType _fieldtype = (Sample.Absyn.FieldType) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_fieldtype.ident_, 0);
       render(":");
       pp(_fieldtype.type_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(Sample.Absyn.Expr foo)
  {
    if (foo instanceof Sample.Absyn.Vary)
    {
       Sample.Absyn.Vary _vary = (Sample.Absyn.Vary) foo;
       render("(");
       render("Vary");
       sh(_vary.ident_);
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
       sh(_if.expr_1);
       sh(_if.expr_2);
       sh(_if.expr_3);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Binding)
    {
       Sample.Absyn.Binding _binding = (Sample.Absyn.Binding) foo;
       render("(");
       render("Binding");
       sh(_binding.ident_);
       sh(_binding.type_);
       sh(_binding.expr_);
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
    if (foo instanceof Sample.Absyn.Var)
    {
       Sample.Absyn.Var _var = (Sample.Absyn.Var) foo;
       render("(");
       render("Var");
       sh(_var.ident_);
       render(")");
    }
    if (foo instanceof Sample.Absyn.Application)
    {
       Sample.Absyn.Application _application = (Sample.Absyn.Application) foo;
       render("(");
       render("Application");
       sh(_application.expr_1);
       sh(_application.expr_2);
       render(")");
    }
  }

  private static void sh(Sample.Absyn.Assignment_op foo)
  {
    if (foo instanceof Sample.Absyn.Assign)
    {
       Sample.Absyn.Assign _assign = (Sample.Absyn.Assign) foo;
       render("Assign");
    }
  }

  private static void sh(Sample.Absyn.Dec foo)
  {
    if (foo instanceof Sample.Absyn.Declarators)
    {
       Sample.Absyn.Declarators _declarators = (Sample.Absyn.Declarators) foo;
       render("(");
       render("Declarators");
       sh(_declarators.ident_);
       sh(_declarators.type_);
       render(")");
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
  }

  private static void sh(Sample.Absyn.FieldTypeExpr foo)
  {
    if (foo instanceof Sample.Absyn.FieldType)
    {
       Sample.Absyn.FieldType _fieldtype = (Sample.Absyn.FieldType) foo;
       render("(");
       render("FieldType");
       sh(_fieldtype.ident_);
       sh(_fieldtype.type_);
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

