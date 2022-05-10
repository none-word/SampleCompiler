// File generated by the BNF Converter (bnfc 2.9.4).

package sample.Absyn;

public class FuncCall  extends Expr {
  public final String ident_;
  public final ComaExprs comaexprs_;
  public FuncCall(String p1, ComaExprs p2) { ident_ = p1; comaexprs_ = p2; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.FuncCall) {
      sample.Absyn.FuncCall x = (sample.Absyn.FuncCall)o;
      return this.ident_.equals(x.ident_) && this.comaexprs_.equals(x.comaexprs_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.ident_.hashCode())+this.comaexprs_.hashCode();
  }


}
