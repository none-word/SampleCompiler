package sample.Absyn; // Java Package generated by the BNF Converter.

public abstract class Idts implements java.io.Serializable {
  public abstract <R,A> R accept(Idts.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(sample.Absyn.Idents p, A arg);

  }

}
