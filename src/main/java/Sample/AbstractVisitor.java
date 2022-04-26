package Sample;
import Sample.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Expr */
    public R visit(Sample.Absyn.Vary p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.ConstTrue p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.ConstFalse p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.If p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Binding p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Not p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.And p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Or p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.ConstZero p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Succ p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Pred p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.IsZero p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Var p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.Application p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(Sample.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Assignment_op */
    public R visit(Sample.Absyn.Assign p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(Sample.Absyn.Assignment_op p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Dec */
    public R visit(Sample.Absyn.Declarators p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(Sample.Absyn.Dec p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(Sample.Absyn.StringType p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.BoolType p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.UnitType p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.IntType p, A arg) { return visitDefault(p, arg); }
    public R visit(Sample.Absyn.DoubleType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(Sample.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* FieldTypeExpr */
    public R visit(Sample.Absyn.FieldType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(Sample.Absyn.FieldTypeExpr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
