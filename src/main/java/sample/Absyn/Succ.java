package sample.Absyn; // Java Package generated by the BNF Converter.

public class Succ extends Expr {
  public final Expr expr_;
  public Succ(Expr p1) { expr_ = p1; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.Succ) {
      sample.Absyn.Succ x = (sample.Absyn.Succ)o;
      return this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return this.expr_.hashCode();
  }


}
