package sample;
import sample.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Program */
    public R visit(sample.Absyn.ProgramExprs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Expr */
    public R visit(sample.Absyn.Import p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Var p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.ConstTrue p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.ConstFalse p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.If p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.FuncCall p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Func p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TypeAlFunc p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.AnonymFunc p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TypeAlAnonymFunc p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Return p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.NilKeyword p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TypeAliasing p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Not p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.And p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Or p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.LetBinding p, A arg) { return visitDefault(p, arg); }


    public R visit(sample.Absyn.VarTypeAnnotation p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.GlVarTypeAnnotation p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.FuncTypeAnnotation p, A arg) { return visitDefault(p, arg); }

    public R visit(sample.Absyn.VarTypeAscription p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.GlVarTypeAscription p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.FuncTypeAscription p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.EDouble p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.EStr p, A arg) { return visitDefault(p, arg); }

    public R visit(sample.Absyn.OnlyDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.OnlyGlDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.InitDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.InitGlDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TableDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.GlTableDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.InitTableDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.InitGlTableDecl p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TableElementCall p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TableElementAssignment p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.Assignment p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(sample.Absyn.Expr p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* ComaExprs */
    public R visit(sample.Absyn.Vars p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.ComaExprs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* FArgs */
    public R visit(sample.Absyn.FuncArgs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.FArgs p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Type */
    public R visit(sample.Absyn.StringType p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.BoolType p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.IntType p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.DoubleType p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TableType p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.VoidType p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.Type p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TypeAl */
    public R visit(sample.Absyn.TypeAlIdent p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.TypeAl p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* VarKW */
    public R visit(sample.Absyn.VarKeyword p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.VarKW p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TAnnot */
    public R visit(sample.Absyn.TypeAnnotation p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.TAnnot p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* TAscript */
    public R visit(sample.Absyn.TypeAscription p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.TAscript p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Dec */
    public R visit(sample.Absyn.Declaration p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TypeAlDecl p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.Dec p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* GlDec */
    public R visit(sample.Absyn.GlDeclaration p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.TypeAlGlDec p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.GlDec p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Field */
    public R visit(sample.Absyn.TypeAnField p, A arg) { return visitDefault(p, arg); }
    public R visit(sample.Absyn.LBField p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.Field p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Fields */
    public R visit(sample.Absyn.LBFields p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(sample.Absyn.Fields p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
