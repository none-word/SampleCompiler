package Sample.Absyn; // Java Package generated by the BNF Converter.

public abstract class Program implements java.io.Serializable {
  public abstract <R,A> R accept(Program.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(Sample.Absyn.ProgramExprs p, A arg);

  }

}
