package Sample;
import Sample.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  Sample.Absyn.Program.Visitor<Sample.Absyn.Program,A>,
  Sample.Absyn.Expr.Visitor<Sample.Absyn.Expr,A>,
  Sample.Absyn.Type.Visitor<Sample.Absyn.Type,A>,
  Sample.Absyn.Dec.Visitor<Sample.Absyn.Dec,A>
{
/* Program */
    public Program visit(Sample.Absyn.ProgramExprs p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new Sample.Absyn.ProgramExprs(listexpr_);
    }
/* Expr */
    public Expr visit(Sample.Absyn.Var p, A arg)
    {
      String ident_ = p.ident_;
      return new Sample.Absyn.Var(ident_);
    }    public Expr visit(Sample.Absyn.ConstTrue p, A arg)
    {
      return new Sample.Absyn.ConstTrue();
    }    public Expr visit(Sample.Absyn.ConstFalse p, A arg)
    {
      return new Sample.Absyn.ConstFalse();
    }    public Expr visit(Sample.Absyn.If p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new Sample.Absyn.If(expr_1, expr_2, expr_3);
    }    public Expr visit(Sample.Absyn.Not p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Not(expr_);
    }    public Expr visit(Sample.Absyn.And p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new Sample.Absyn.And(expr_1, expr_2);
    }    public Expr visit(Sample.Absyn.Or p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new Sample.Absyn.Or(expr_1, expr_2);
    }    public Expr visit(Sample.Absyn.ConstZero p, A arg)
    {
      return new Sample.Absyn.ConstZero();
    }    public Expr visit(Sample.Absyn.Succ p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Succ(expr_);
    }    public Expr visit(Sample.Absyn.Pred p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Pred(expr_);
    }    public Expr visit(Sample.Absyn.IsZero p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.IsZero(expr_);
    }    public Expr visit(Sample.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new Sample.Absyn.EInt(integer_);
    }    public Expr visit(Sample.Absyn.EDouble p, A arg)
    {
      Double double_ = p.double_;
      return new Sample.Absyn.EDouble(double_);
    }    public Expr visit(Sample.Absyn.EStr p, A arg)
    {
      String string_ = p.string_;
      return new Sample.Absyn.EStr(string_);
    }    public Expr visit(Sample.Absyn.OnlyDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      return new Sample.Absyn.OnlyDecl(dec_);
    }    public Expr visit(Sample.Absyn.InitDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.InitDecl(dec_, expr_);
    }
/* Type */
    public Type visit(Sample.Absyn.StringType p, A arg)
    {
      return new Sample.Absyn.StringType();
    }    public Type visit(Sample.Absyn.BoolType p, A arg)
    {
      return new Sample.Absyn.BoolType();
    }    public Type visit(Sample.Absyn.UnitType p, A arg)
    {
      return new Sample.Absyn.UnitType();
    }    public Type visit(Sample.Absyn.IntType p, A arg)
    {
      return new Sample.Absyn.IntType();
    }    public Type visit(Sample.Absyn.DoubleType p, A arg)
    {
      return new Sample.Absyn.DoubleType();
    }
/* Dec */
    public Dec visit(Sample.Absyn.Declaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.Declaration(ident_, type_);
    }    public Dec visit(Sample.Absyn.LocalVarDeclaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.LocalVarDeclaration(ident_, type_);
    }
}