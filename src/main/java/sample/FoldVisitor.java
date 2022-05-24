package sample;

import sample.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(sample.Absyn.ProgramExprs p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Expr */
    public R visit(sample.Absyn.Import p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.Var p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.ConstTrue p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.ConstFalse p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.If p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      r = combine(p.program_1.accept(this, arg), r, arg);
      r = combine(p.program_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.FuncCall p, A arg) {
      R r = leaf(arg);
      r = combine(p.comaexprs_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.Func p, A arg) {
      R r = leaf(arg);
      r = combine(p.fargs_.accept(this, arg), r, arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      r = combine(p.program_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.TypeAlFunc p, A arg) {
      R r = leaf(arg);
      r = combine(p.fargs_.accept(this, arg), r, arg);
      r = combine(p.program_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.Return p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.NilKeyword p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.TypeAliasing p, A arg) {
      R r = leaf(arg);
      r = combine(p.typeal_.accept(this, arg), r, arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.Not p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.And p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.Or p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_1.accept(this, arg), r, arg);
      r = combine(p.expr_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.VarTypeAnnotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.tannot_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.GlVarTypeAnnotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.tannot_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.FuncTypeAnnotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.fargs_.accept(this, arg), r, arg);
      r = combine(p.tannot_.accept(this, arg), r, arg);
      r = combine(p.program_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.VarTypeAscription p, A arg) {
      R r = leaf(arg);
      r = combine(p.tascript_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.GlVarTypeAscription p, A arg) {
      R r = leaf(arg);
      r = combine(p.tascript_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.FuncTypeAscription p, A arg) {
      R r = leaf(arg);
      r = combine(p.fargs_.accept(this, arg), r, arg);
      r = combine(p.tascript_.accept(this, arg), r, arg);
      r = combine(p.program_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.EInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.EDouble p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.EStr p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.OnlyDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.dec_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.OnlyGlDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.gldec_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.InitDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.dec_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.InitGlDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.gldec_.accept(this, arg), r, arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.TableDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.dec_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.GlTableDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.gldec_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.InitTableDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.dec_1.accept(this, arg), r, arg);
      r = combine(p.dec_2.accept(this, arg), r, arg);
      r = combine(p.dec_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.InitGlTableDecl p, A arg) {
      R r = leaf(arg);
      r = combine(p.gldec_.accept(this, arg), r, arg);
      r = combine(p.dec_1.accept(this, arg), r, arg);
      r = combine(p.dec_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.TableElementCall p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.TableElementAssignment p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.Assignment p, A arg) {
      R r = leaf(arg);
      r = combine(p.expr_.accept(this, arg), r, arg);
      return r;
    }

/* ComaExprs */
    public R visit(sample.Absyn.Vars p, A arg) {
      R r = leaf(arg);
      for (Expr x : p.listexpr_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* FArgs */
    public R visit(sample.Absyn.FuncArgs p, A arg) {
      R r = leaf(arg);
      for (Dec x : p.listdec_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Type */
    public R visit(sample.Absyn.StringType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.BoolType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.IntType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.DoubleType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.TableType p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.VoidType p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* TypeAl */
    public R visit(sample.Absyn.TypeAlIdent p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* VarKW */
    public R visit(sample.Absyn.VarKeyword p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* TAnnot */
    public R visit(sample.Absyn.TypeAnnotation p, A arg) {
      R r = leaf(arg);
      r = combine(p.varkw_.accept(this, arg), r, arg);
      return r;
    }

/* TAscript */
    public R visit(sample.Absyn.TypeAscription p, A arg) {
      R r = leaf(arg);
      r = combine(p.tannot_.accept(this, arg), r, arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }

/* Dec */
    public R visit(sample.Absyn.Declaration p, A arg) {
      R r = leaf(arg);
      r = combine(p.type_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(sample.Absyn.TypeAlDecl p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* GlDec */
    public R visit(sample.Absyn.GlDeclaration p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(sample.Absyn.TypeAlGlDec p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
