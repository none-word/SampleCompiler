package sample.Absyn; // Java Package generated by the BNF Converter.

public class GlVarTypeAscription extends Expr {
  public final String ident_;
  public final TAscript tascript_;
  public final Expr expr_;
  public GlVarTypeAscription(String p1, TAscript p2, Expr p3) { ident_ = p1; tascript_ = p2; expr_ = p3; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.GlVarTypeAscription) {
      sample.Absyn.GlVarTypeAscription x = (sample.Absyn.GlVarTypeAscription)o;
      return this.ident_.equals(x.ident_) && this.tascript_.equals(x.tascript_) && this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_.hashCode())+this.tascript_.hashCode())+this.expr_.hashCode();
  }


}
