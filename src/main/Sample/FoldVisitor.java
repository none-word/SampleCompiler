package Sample;

import Sample.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Expr */
    public R visit(Sample.Absyn.Vary p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.ConstTrue p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.ConstFalse p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.If p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      r = combine(p.expr_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.Not p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.And p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.Or p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.ConstZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.Succ p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.Pred p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.IsZero p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(Sample.Absyn.Var p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.Application p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }

/* Type */
    public R visit(Sample.Absyn.StringType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.BoolType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.UnitType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.IntType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(Sample.Absyn.DoubleType p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* FieldTypeExpr */
    public R visit(Sample.Absyn.FieldType p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }


}
