package sample;
import sample.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(sample.Absyn.ProgramExprs p, A arg)
    { /* Code For ProgramExprs Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }
  }
  public class ExprVisitor<R,A> implements Expr.Visitor<R,A>
  {
    public R visit(sample.Absyn.Var p, A arg)
    { /* Code For Var Goes Here */
      //p.ident_;
      return null;
    }    public R visit(sample.Absyn.ConstTrue p, A arg)
    { /* Code For ConstTrue Goes Here */
      return null;
    }    public R visit(sample.Absyn.ConstFalse p, A arg)
    { /* Code For ConstFalse Goes Here */
      return null;
    }    public R visit(sample.Absyn.If p, A arg)
    { /* Code For If Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      p.expr_3.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.FuncCall p, A arg)
    { /* Code For FuncCall Goes Here */
      //p.ident_;
      p.comaexprs_.accept(new ComaExprsVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.Func p, A arg)
    { /* Code For Func Goes Here */
      //p.ident_;
      p.fargs_.accept(new FArgsVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      p.program_.accept(new ProgramVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.Return p, A arg)
    { /* Code For Return Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.Not p, A arg)
    { /* Code For Not Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.And p, A arg)
    { /* Code For And Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.Or p, A arg)
    { /* Code For Or Goes Here */
      p.expr_1.accept(new ExprVisitor<R,A>(), arg);
      p.expr_2.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.ConstZero p, A arg)
    { /* Code For ConstZero Goes Here */
      return null;
    }    public R visit(sample.Absyn.Succ p, A arg)
    { /* Code For Succ Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.Pred p, A arg)
    { /* Code For Pred Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.IsZero p, A arg)
    { /* Code For IsZero Goes Here */
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }            public R visit(sample.Absyn.TypeAliasing p, A arg)
    { /* Code For TypeAliasing Goes Here */
      //p.ident_;
      p.typekw_.accept(new TypeKWVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.LcTypeAliasing p, A arg)
    { /* Code For LcTypeAliasing Goes Here */
      //p.ident_;
      p.typekw_.accept(new TypeKWVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.VarTypeAnnotation p, A arg)
    { /* Code For VarTypeAnnotation Goes Here */
      //p.ident_;
      p.tannot_.accept(new TAnnotVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.LcVarTypeAnnotation p, A arg)
    { /* Code For LcVarTypeAnnotation Goes Here */
      //p.ident_;
      p.tannot_.accept(new TAnnotVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.FuncTypeAnnotation p, A arg)
    { /* Code For FuncTypeAnnotation Goes Here */
      //p.ident_;
      p.fargs_.accept(new FArgsVisitor<R,A>(), arg);
      p.tannot_.accept(new TAnnotVisitor<R,A>(), arg);
      p.program_.accept(new ProgramVisitor<R,A>(), arg);
      return null;
    }        public R visit(sample.Absyn.VarTypeAscription p, A arg)
    { /* Code For VarTypeAscription Goes Here */
      //p.ident_;
      p.tascript_.accept(new TAscriptVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.LcVarTypeAscription p, A arg)
    { /* Code For LcVarTypeAscription Goes Here */
      //p.ident_;
      p.tascript_.accept(new TAscriptVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.FuncTypeAscription p, A arg)
    { /* Code For FuncTypeAscription Goes Here */
      //p.ident_;
      p.fargs_.accept(new FArgsVisitor<R,A>(), arg);
      p.tascript_.accept(new TAscriptVisitor<R,A>(), arg);
      p.program_.accept(new ProgramVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.EInt p, A arg)
    { /* Code For EInt Goes Here */
      //p.integer_;
      return null;
    }    public R visit(sample.Absyn.EDouble p, A arg)
    { /* Code For EDouble Goes Here */
      //p.double_;
      return null;
    }    public R visit(sample.Absyn.EStr p, A arg)
    { /* Code For EStr Goes Here */
      //p.string_;
      return null;
    }        public R visit(sample.Absyn.OnlyDecl p, A arg)
    { /* Code For OnlyDecl Goes Here */
      p.dec_.accept(new DecVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.InitDecl p, A arg)
    { /* Code For InitDecl Goes Here */
      p.dec_.accept(new DecVisitor<R,A>(), arg);
      p.expr_.accept(new ExprVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.InitTableDecl p, A arg)
    { /* Code For InitTableDecl Goes Here */
      p.dec_1.accept(new DecVisitor<R,A>(), arg);
      p.dec_2.accept(new DecVisitor<R,A>(), arg);
      p.dec_3.accept(new DecVisitor<R,A>(), arg);
      return null;
    }    
  }
  public class ComaExprsVisitor<R,A> implements ComaExprs.Visitor<R,A>
  {
    public R visit(sample.Absyn.Vars p, A arg)
    { /* Code For Vars Goes Here */
      for (Expr x: p.listexpr_)
      { /* ... */ }
      return null;
    }
  }
  public class FArgsVisitor<R,A> implements FArgs.Visitor<R,A>
  {
    public R visit(sample.Absyn.FuncArgs p, A arg)
    { /* Code For FuncArgs Goes Here */
      for (Dec x: p.listdec_)
      { /* ... */ }
      return null;
    }
  }
  public class TypeVisitor<R,A> implements Type.Visitor<R,A>
  {
    public R visit(sample.Absyn.StringType p, A arg)
    { /* Code For StringType Goes Here */
      return null;
    }    public R visit(sample.Absyn.BoolType p, A arg)
    { /* Code For BoolType Goes Here */
      return null;
    }    public R visit(sample.Absyn.UnitType p, A arg)
    { /* Code For UnitType Goes Here */
      return null;
    }    public R visit(sample.Absyn.IntType p, A arg)
    { /* Code For IntType Goes Here */
      return null;
    }    public R visit(sample.Absyn.DoubleType p, A arg)
    { /* Code For DoubleType Goes Here */
      return null;
    }    public R visit(sample.Absyn.TableType p, A arg)
    { /* Code For TableType Goes Here */
      return null;
    }    public R visit(sample.Absyn.NilType p, A arg)
    { /* Code For NilType Goes Here */
      return null;
    }    public R visit(sample.Absyn.VoidType p, A arg)
    { /* Code For VoidType Goes Here */
      return null;
    }
  }
  public class TypeKWVisitor<R,A> implements TypeKW.Visitor<R,A>
  {
    public R visit(sample.Absyn.TypeKeyword p, A arg)
    { /* Code For TypeKeyword Goes Here */
      return null;
    }
  }
  public class VarKWVisitor<R,A> implements VarKW.Visitor<R,A>
  {
    public R visit(sample.Absyn.VarKeyword p, A arg)
    { /* Code For VarKeyword Goes Here */
      return null;
    }
  }
  public class TAnnotVisitor<R,A> implements TAnnot.Visitor<R,A>
  {
    public R visit(sample.Absyn.TypeAnnotation p, A arg)
    { /* Code For TypeAnnotation Goes Here */
      p.varkw_.accept(new VarKWVisitor<R,A>(), arg);
      return null;
    }
  }
  public class TAscriptVisitor<R,A> implements TAscript.Visitor<R,A>
  {
    public R visit(sample.Absyn.TypeAscription p, A arg)
    { /* Code For TypeAscription Goes Here */
      p.tannot_.accept(new TAnnotVisitor<R,A>(), arg);
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
  public class DecVisitor<R,A> implements Dec.Visitor<R,A>
  {
    public R visit(sample.Absyn.Declaration p, A arg)
    { /* Code For Declaration Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }    public R visit(sample.Absyn.LcVarDeclaration p, A arg)
    { /* Code For LcVarDeclaration Goes Here */
      //p.ident_;
      p.type_.accept(new TypeVisitor<R,A>(), arg);
      return null;
    }
  }
}