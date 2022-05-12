package sample.Absyn; // Java Package generated by the BNF Converter.

public class InitTableDecl extends Expr {
  public final Dec dec_1, dec_2, dec_3;
  public InitTableDecl(Dec p1, Dec p2, Dec p3) { dec_1 = p1; dec_2 = p2; dec_3 = p3; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.InitTableDecl) {
      sample.Absyn.InitTableDecl x = (sample.Absyn.InitTableDecl)o;
      return this.dec_1.equals(x.dec_1) && this.dec_2.equals(x.dec_2) && this.dec_3.equals(x.dec_3);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.dec_1.hashCode())+this.dec_2.hashCode())+this.dec_3.hashCode();
  }


}
