package Sample;
import Sample.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(Sample.Absyn.Vary p, A arg)
    { /* Code For Vary Goes Here */
      //p.ident_;
      return null;
    }    public R visit(Sample.Absyn.ConstTrue p, A arg)
    { /* Code For ConstTrue Goes Here */
      return null;
    }    public R visit(Sample.Absyn.ConstFalse p, A arg)
    { /* Code For ConstFalse Goes Here */
      return null;
    }    public R visit(Sample.Absyn.If p, A arg)
    { /* Code For If Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.Binding p, A arg)
    { /* Code For Binding Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.Not p, A arg)
    { /* Code For Not Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.And p, A arg)
    { /* Code For And Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.Or p, A arg)
    { /* Code For Or Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.ConstZero p, A arg)
    { /* Code For ConstZero Goes Here */
      return null;
    }    public R visit(Sample.Absyn.Succ p, A arg)
    { /* Code For Succ Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.Pred p, A arg)
    { /* Code For Pred Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.IsZero p, A arg)
    { /* Code For IsZero Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.Var p, A arg)
    { /* Code For Var Goes Here */
      //p.ident_;
      return null;
    }    public R visit(Sample.Absyn.Application p, A arg)
    { /* Code For Application Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    
  }
  public class Assignment_opVisitor<R,A> implements Assignment_op.Visitor<R,A>
  {
    public R visit(Sample.Absyn.Assign p, A arg)
    { /* Code For Assign Goes Here */
      return null;
    }
  }
  public class DecVisitor<R,A> implements Dec.Visitor<R,A>
  {
    public R visit(Sample.Absyn.Declarators p, A arg)
    { /* Code For Declarators Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(Sample.Absyn.StringType p, A arg)
    { /* Code For StringType Goes Here */
      return null;
    }    public R visit(Sample.Absyn.BoolType p, A arg)
    { /* Code For BoolType Goes Here */
      return null;
    }    public R visit(Sample.Absyn.UnitType p, A arg)
    { /* Code For UnitType Goes Here */
      return null;
    }    public R visit(Sample.Absyn.IntType p, A arg)
    { /* Code For IntType Goes Here */
      return null;
    }    public R visit(Sample.Absyn.DoubleType p, A arg)
    { /* Code For DoubleType Goes Here */
      return null;
    }
  }
  public class FieldTypeExprVisitor<R,A> implements FieldTypeExpr.Visitor<R,A>
  {
    public R visit(Sample.Absyn.FieldType p, A arg)
    { /* Code For FieldType Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
}