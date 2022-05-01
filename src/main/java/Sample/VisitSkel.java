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
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(Sample.Absyn.ProgramExprs p, A arg)
    { /* Code For ProgramExprs Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(Sample.Absyn.Var p, A arg)
    { /* Code For Var Goes Here */
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
    }            public R visit(Sample.Absyn.EInt p, A arg)
    { /* Code For EInt Goes Here */
      //p.integer_;
      return null;
    }    public R visit(Sample.Absyn.EDouble p, A arg)
    { /* Code For EDouble Goes Here */
      //p.double_;
      return null;
    }    public R visit(Sample.Absyn.EStr p, A arg)
    { /* Code For EStr Goes Here */
      //p.string_;
      return null;
    }    public R visit(Sample.Absyn.OnlyDecl p, A arg)
    { /* Code For OnlyDecl Goes Here */
      p.dec_.accept(new DecVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.InitDecl p, A arg)
    { /* Code For InitDecl Goes Here */
      p.dec_.accept(new DecVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
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
  public class DecVisitor<R,A> implements Dec.Visitor<R,A>
  {
    public R visit(Sample.Absyn.Declaration p, A arg)
    { /* Code For Declaration Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(Sample.Absyn.LocalVarDeclaration p, A arg)
    { /* Code For LocalVarDeclaration Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
}