package sample.Absyn; // Java Package generated by the BNF Converter.

public class TypeAliasing extends Expr {
  public final TypeAl typeal_;
  public final Type type_;
  public TypeAliasing(TypeAl p1, Type p2) { typeal_ = p1; type_ = p2; }

  public <R,A> R accept(sample.Absyn.Expr.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof sample.Absyn.TypeAliasing) {
      sample.Absyn.TypeAliasing x = (sample.Absyn.TypeAliasing)o;
      return this.typeal_.equals(x.typeal_) && this.type_.equals(x.type_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.typeal_.hashCode())+this.type_.hashCode();
  }


}
