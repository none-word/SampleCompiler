// File generated by the BNF Converter (bnfc 2.9.4).

package sample.Absyn;

public class NilType  extends Type {
  public NilType() { }

  public <R,A> R accept(sample.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.NilType) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
