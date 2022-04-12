// File generated by the BNF Converter (bnfc 2.9.4).

package syntax.nameless;

import syntax.nameless.Absyn.*;
import syntax.nameless.Absyn.Expr.Visitor;

/*** Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ExprVisitor<R,A> implements Visitor<R,A>
  {
    public R visit(ConstTrue p, A arg)
    { /* Code for ConstTrue goes here */
      return null;
    }
    public R visit(ConstFalse p, A arg)
    { /* Code for ConstFalse goes here */
      return null;
    }
    public R visit(If p, A arg)
    { /* Code for If goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(ConstZero p, A arg)
    { /* Code for ConstZero goes here */
      return null;
    }
    public R visit(Succ p, A arg)
    { /* Code for Succ goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(Pred p, A arg)
    { /* Code for Pred goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(IsZero p, A arg)
    { /* Code for IsZero goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(FreeVar p, A arg)
    { /* Code for FreeVar goes here */
      //p.ident_;
      return null;
    }
    public R visit(BoundVar p, A arg)
    { /* Code for BoundVar goes here */
      //p.integer_;
      return null;
    }
    public R visit(Abstraction p, A arg)
    { /* Code for Abstraction goes here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
    public R visit(Application p, A arg)
    { /* Code for Application goes here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }
  }
}
