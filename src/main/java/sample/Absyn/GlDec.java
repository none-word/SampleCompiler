package sample.Absyn; // Java Package generated by the BNF Converter.

public abstract class GlDec implements java.io.Serializable {
  public abstract <R,A> R accept(GlDec.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(sample.Absyn.GlDeclaration p, A arg);

  }

}
