package sample;
import sample.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  sample.Absyn.Program.Visitor<sample.Absyn.Program,A>,
  sample.Absyn.Expr.Visitor<sample.Absyn.Expr,A>,
  sample.Absyn.ComaExprs.Visitor<sample.Absyn.ComaExprs,A>,
  sample.Absyn.FArgs.Visitor<sample.Absyn.FArgs,A>,
  sample.Absyn.Type.Visitor<sample.Absyn.Type,A>,
  sample.Absyn.TypeKW.Visitor<sample.Absyn.TypeKW,A>,
  sample.Absyn.VarKW.Visitor<sample.Absyn.VarKW,A>,
  sample.Absyn.TAnnot.Visitor<sample.Absyn.TAnnot,A>,
  sample.Absyn.TAscript.Visitor<sample.Absyn.TAscript,A>,
  sample.Absyn.Dec.Visitor<sample.Absyn.Dec,A>
{
/* Program */
    public Program visit(sample.Absyn.ProgramExprs p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new sample.Absyn.ProgramExprs(listexpr_);
    }
/* Expr */
    public Expr visit(sample.Absyn.Var p, A arg)
    {
      String ident_ = p.ident_;
      return new sample.Absyn.Var(ident_);
    }    public Expr visit(sample.Absyn.ConstTrue p, A arg)
    {
      return new sample.Absyn.ConstTrue();
    }    public Expr visit(sample.Absyn.ConstFalse p, A arg)
    {
      return new sample.Absyn.ConstFalse();
    }    public Expr visit(sample.Absyn.If p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      Expr expr_3 = p.expr_3.accept(this, arg);
      return new sample.Absyn.If(expr_1, expr_2, expr_3);
    }    public Expr visit(sample.Absyn.FuncCall p, A arg)
    {
      String ident_ = p.ident_;
      ComaExprs comaexprs_ = p.comaexprs_.accept(this, arg);
      return new sample.Absyn.FuncCall(ident_, comaexprs_);
    }    public Expr visit(sample.Absyn.Func p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new sample.Absyn.Func(ident_, fargs_, type_, program_);
    }    public Expr visit(sample.Absyn.Return p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Return(expr_);
    }    public Expr visit(sample.Absyn.Not p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Not(expr_);
    }    public Expr visit(sample.Absyn.And p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new sample.Absyn.And(expr_1, expr_2);
    }    public Expr visit(sample.Absyn.Or p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new sample.Absyn.Or(expr_1, expr_2);
    }    public Expr visit(sample.Absyn.ConstZero p, A arg)
    {
      return new sample.Absyn.ConstZero();
    }    public Expr visit(sample.Absyn.Succ p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Succ(expr_);
    }    public Expr visit(sample.Absyn.Pred p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Pred(expr_);
    }    public Expr visit(sample.Absyn.IsZero p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.IsZero(expr_);
    }    public Expr visit(sample.Absyn.TypeAliasing p, A arg)
    {
      String ident_ = p.ident_;
      TypeKW typekw_ = p.typekw_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.TypeAliasing(ident_, typekw_, type_);
    }    public Expr visit(sample.Absyn.VarTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.VarTypeAnnotation(ident_, tannot_, expr_);
    }    public Expr visit(sample.Absyn.FuncTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new sample.Absyn.FuncTypeAnnotation(ident_, fargs_, tannot_, program_);
    }    public Expr visit(sample.Absyn.VarTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.VarTypeAscription(ident_, tascript_, expr_);
    }    public Expr visit(sample.Absyn.FuncTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new sample.Absyn.FuncTypeAscription(ident_, fargs_, tascript_, program_);
    }    public Expr visit(sample.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new sample.Absyn.EInt(integer_);
    }    public Expr visit(sample.Absyn.EDouble p, A arg)
    {
      Double double_ = p.double_;
      return new sample.Absyn.EDouble(double_);
    }    public Expr visit(sample.Absyn.EStr p, A arg)
    {
      String string_ = p.string_;
      return new sample.Absyn.EStr(string_);
    }    public Expr visit(sample.Absyn.OnlyDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      return new sample.Absyn.OnlyDecl(dec_);
    }    public Expr visit(sample.Absyn.InitDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.InitDecl(dec_, expr_);
    }    public Expr visit(sample.Absyn.InitTableDecl p, A arg)
    {
      Dec dec_1 = p.dec_1.accept(this, arg);
      Dec dec_2 = p.dec_2.accept(this, arg);
      Dec dec_3 = p.dec_3.accept(this, arg);
      return new sample.Absyn.InitTableDecl(dec_1, dec_2, dec_3);
    }
/* ComaExprs */
    public ComaExprs visit(sample.Absyn.Vars p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new sample.Absyn.Vars(listexpr_);
    }
/* FArgs */
    public FArgs visit(sample.Absyn.FuncArgs p, A arg)
    {
      ListDec listdec_ = new ListDec();
      for (Dec x : p.listdec_)
      {
        listdec_.add(x.accept(this,arg));
      }
      return new sample.Absyn.FuncArgs(listdec_);
    }
/* Type */
    public Type visit(sample.Absyn.StringType p, A arg)
    {
      return new sample.Absyn.StringType();
    }    public Type visit(sample.Absyn.BoolType p, A arg)
    {
      return new sample.Absyn.BoolType();
    }    public Type visit(sample.Absyn.IntType p, A arg)
    {
      return new sample.Absyn.IntType();
    }    public Type visit(sample.Absyn.DoubleType p, A arg)
    {
      return new sample.Absyn.DoubleType();
    }    public Type visit(sample.Absyn.TableType p, A arg)
    {
      return new sample.Absyn.TableType();
    }    public Type visit(sample.Absyn.NilType p, A arg)
    {
      return new sample.Absyn.NilType();
    }    public Type visit(sample.Absyn.VoidType p, A arg)
    {
      return new sample.Absyn.VoidType();
    }
/* TypeKW */
    public TypeKW visit(sample.Absyn.TypeKeyword p, A arg)
    {
      return new sample.Absyn.TypeKeyword();
    }
/* VarKW */
    public VarKW visit(sample.Absyn.VarKeyword p, A arg)
    {
      return new sample.Absyn.VarKeyword();
    }
/* TAnnot */
    public TAnnot visit(sample.Absyn.TypeAnnotation p, A arg)
    {
      VarKW varkw_ = p.varkw_.accept(this, arg);
      return new sample.Absyn.TypeAnnotation(varkw_);
    }
/* TAscript */
    public TAscript visit(sample.Absyn.TypeAscription p, A arg)
    {
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.TypeAscription(tannot_, type_);
    }
/* Dec */
    public Dec visit(sample.Absyn.Declaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.Declaration(ident_, type_);
    }
}