// File generated by the BNF Converter (bnfc 2.9.4).

package sample.Absyn;

public class UnitType  extends Type {
  public UnitType() { }

  public <R,A> R accept(sample.Absyn.Type.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.UnitType) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
