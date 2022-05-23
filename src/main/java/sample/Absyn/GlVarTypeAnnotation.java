package sample.Absyn; // Java Package generated by the BNF Converter.

public class GlVarTypeAnnotation extends Expr {
  public final String ident_;
  public final TAnnot tannot_;
  public final Expr expr_;
  public GlVarTypeAnnotation(String p1, TAnnot p2, Expr p3) { ident_ = p1; tannot_ = p2; expr_ = p3; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.GlVarTypeAnnotation) {
      sample.Absyn.GlVarTypeAnnotation x = (sample.Absyn.GlVarTypeAnnotation)o;
      return this.ident_.equals(x.ident_) && this.tannot_.equals(x.tannot_) && this.expr_.equals(x.expr_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.ident_.hashCode())+this.tannot_.hashCode())+this.expr_.hashCode();
  }


}
