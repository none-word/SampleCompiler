// File generated by the BNF Converter (bnfc 2.9.4).

package sample.Absyn;

public class Not  extends Expr {
  public final Expr expr_;
  public Not(Expr p1) { expr_ = p1; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.Not) {
      sample.Absyn.Not x = (sample.Absyn.Not)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
