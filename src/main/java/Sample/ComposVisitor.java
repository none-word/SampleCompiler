package Sample;
import Sample.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  Sample.Absyn.Expr.Visitor<Sample.Absyn.Expr,A>,
  Sample.Absyn.Assignment_op.Visitor<Sample.Absyn.Assignment_op,A>,
  Sample.Absyn.Dec.Visitor<Sample.Absyn.Dec,A>,
  Sample.Absyn.Type.Visitor<Sample.Absyn.Type,A>,
  Sample.Absyn.FieldTypeExpr.Visitor<Sample.Absyn.FieldTypeExpr,A>
{
/* Expr */
    public Expr visit(Sample.Absyn.Vary p, A arg)
    {
      String ident_ = p.ident_;
      return new Sample.Absyn.Vary(ident_);
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
    }    public Expr visit(Sample.Absyn.Binding p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Binding(ident_, type_, expr_);
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
    }    public Expr visit(Sample.Absyn.Var p, A arg)
    {
      String ident_ = p.ident_;
      return new Sample.Absyn.Var(ident_);
    }    public Expr visit(Sample.Absyn.Application p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new Sample.Absyn.Application(expr_1, expr_2);
    }
/* Assignment_op */
    public Assignment_op visit(Sample.Absyn.Assign p, A arg)
    {
      return new Sample.Absyn.Assign();
    }
/* Dec */
    public Dec visit(Sample.Absyn.Declarators p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.Declarators(ident_, type_);
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
/* FieldTypeExpr */
    public FieldTypeExpr visit(Sample.Absyn.FieldType p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.FieldType(ident_, type_);
    }
}