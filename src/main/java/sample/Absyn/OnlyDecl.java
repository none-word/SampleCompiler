// File generated by the BNF Converter (bnfc 2.9.4).

package sample.Absyn;

public class OnlyDecl  extends Expr {
  public final Dec dec_;
  public OnlyDecl(Dec p1) { dec_ = p1; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.OnlyDecl) {
      sample.Absyn.OnlyDecl x = (sample.Absyn.OnlyDecl)o;
      return this.dec_.equals(x.dec_);
    }
    return false;
  }

  public int hashCode() {
    return this.dec_.hashCode();
  }


}
