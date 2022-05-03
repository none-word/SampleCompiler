package Sample;
import Sample.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  Sample.Absyn.Program.Visitor<Sample.Absyn.Program,A>,
  Sample.Absyn.Expr.Visitor<Sample.Absyn.Expr,A>,
  Sample.Absyn.ComaExprs.Visitor<Sample.Absyn.ComaExprs,A>,
  Sample.Absyn.FArgs.Visitor<Sample.Absyn.FArgs,A>,
  Sample.Absyn.Type.Visitor<Sample.Absyn.Type,A>,
  Sample.Absyn.TypeKW.Visitor<Sample.Absyn.TypeKW,A>,
  Sample.Absyn.VarKW.Visitor<Sample.Absyn.VarKW,A>,
  Sample.Absyn.TAnnot.Visitor<Sample.Absyn.TAnnot,A>,
  Sample.Absyn.TAscript.Visitor<Sample.Absyn.TAscript,A>,
  Sample.Absyn.Dec.Visitor<Sample.Absyn.Dec,A>
{
/* Program */
    public Program visit(Sample.Absyn.ProgramExprs p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new Sample.Absyn.ProgramExprs(listexpr_);
    }
/* Expr */
    public Expr visit(Sample.Absyn.Var p, A arg)
    {
      String ident_ = p.ident_;
      return new Sample.Absyn.Var(ident_);
    }    public Expr visit(Sample.Absyn.ConstTrue p, A arg)
    {
      return new Sample.Absyn.ConstTrue();
    }    public Expr visit(Sample.Absyn.ConstFalse p, A arg)
    {
      return new Sample.Absyn.ConstFalse();
    }    public Expr visit(Sample.Absyn.If p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      Program program_1 = p.program_1.accept(this, arg);
      Program program_2 = p.program_2.accept(this, arg);
      return new Sample.Absyn.If(expr_, program_1, program_2);
    }    public Expr visit(Sample.Absyn.FuncCall p, A arg)
    {
      String ident_ = p.ident_;
      ComaExprs comaexprs_ = p.comaexprs_.accept(this, arg);
      return new Sample.Absyn.FuncCall(ident_, comaexprs_);
    }    public Expr visit(Sample.Absyn.Func p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new Sample.Absyn.Func(ident_, fargs_, type_, program_);
    }    public Expr visit(Sample.Absyn.Return p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Return(expr_);
    }    public Expr visit(Sample.Absyn.Not p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Not(expr_);
    }    public Expr visit(Sample.Absyn.And p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new Sample.Absyn.And(expr_1, expr_2);
    }    public Expr visit(Sample.Absyn.Or p, A arg)
    {
      Expr expr_1 = p.expr_1.accept(this, arg);
      Expr expr_2 = p.expr_2.accept(this, arg);
      return new Sample.Absyn.Or(expr_1, expr_2);
    }    public Expr visit(Sample.Absyn.ConstZero p, A arg)
    {
      return new Sample.Absyn.ConstZero();
    }    public Expr visit(Sample.Absyn.Succ p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Succ(expr_);
    }    public Expr visit(Sample.Absyn.Pred p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.Pred(expr_);
    }    public Expr visit(Sample.Absyn.IsZero p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.IsZero(expr_);
    }    public Expr visit(Sample.Absyn.TypeAliasing p, A arg)
    {
      String ident_ = p.ident_;
      TypeKW typekw_ = p.typekw_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.TypeAliasing(ident_, typekw_, type_);
    }    public Expr visit(Sample.Absyn.LcTypeAliasing p, A arg)
    {
      String ident_ = p.ident_;
      TypeKW typekw_ = p.typekw_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.LcTypeAliasing(ident_, typekw_, type_);
    }    public Expr visit(Sample.Absyn.VarTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.VarTypeAnnotation(ident_, tannot_, expr_);
    }    public Expr visit(Sample.Absyn.LcVarTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.LcVarTypeAnnotation(ident_, tannot_, expr_);
    }    public Expr visit(Sample.Absyn.FuncTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new Sample.Absyn.FuncTypeAnnotation(ident_, fargs_, tannot_, program_);
    }    public Expr visit(Sample.Absyn.VarTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.VarTypeAscription(ident_, tascript_, expr_);
    }    public Expr visit(Sample.Absyn.LcVarTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.LcVarTypeAscription(ident_, tascript_, expr_);
    }    public Expr visit(Sample.Absyn.FuncTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      return new Sample.Absyn.FuncTypeAscription(ident_, fargs_, tascript_, program_);
    }    public Expr visit(Sample.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new Sample.Absyn.EInt(integer_);
    }    public Expr visit(Sample.Absyn.EDouble p, A arg)
    {
      Double double_ = p.double_;
      return new Sample.Absyn.EDouble(double_);
    }    public Expr visit(Sample.Absyn.EStr p, A arg)
    {
      String string_ = p.string_;
      return new Sample.Absyn.EStr(string_);
    }    public Expr visit(Sample.Absyn.OnlyDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      return new Sample.Absyn.OnlyDecl(dec_);
    }    public Expr visit(Sample.Absyn.InitDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new Sample.Absyn.InitDecl(dec_, expr_);
    }    public Expr visit(Sample.Absyn.InitTableDecl p, A arg)
    {
      Dec dec_1 = p.dec_1.accept(this, arg);
      Dec dec_2 = p.dec_2.accept(this, arg);
      Dec dec_3 = p.dec_3.accept(this, arg);
      return new Sample.Absyn.InitTableDecl(dec_1, dec_2, dec_3);
    }
/* ComaExprs */
    public ComaExprs visit(Sample.Absyn.Vars p, A arg)
    {
      ListExpr listexpr_ = new ListExpr();
      for (Expr x : p.listexpr_)
      {
        listexpr_.add(x.accept(this,arg));
      }
      return new Sample.Absyn.Vars(listexpr_);
    }
/* FArgs */
    public FArgs visit(Sample.Absyn.FuncArgs p, A arg)
    {
      ListDec listdec_ = new ListDec();
      for (Dec x : p.listdec_)
      {
        listdec_.add(x.accept(this,arg));
      }
      return new Sample.Absyn.FuncArgs(listdec_);
    }
/* Type */
    public Type visit(Sample.Absyn.StringType p, A arg)
    {
      return new Sample.Absyn.StringType();
    }    public Type visit(Sample.Absyn.BoolType p, A arg)
    {
      return new Sample.Absyn.BoolType();
    }    public Type visit(Sample.Absyn.UnitType p, A arg)
    {
      return new Sample.Absyn.UnitType();
    }    public Type visit(Sample.Absyn.IntType p, A arg)
    {
      return new Sample.Absyn.IntType();
    }    public Type visit(Sample.Absyn.DoubleType p, A arg)
    {
      return new Sample.Absyn.DoubleType();
    }    public Type visit(Sample.Absyn.TableType p, A arg)
    {
      return new Sample.Absyn.TableType();
    }    public Type visit(Sample.Absyn.NilType p, A arg)
    {
      return new Sample.Absyn.NilType();
    }    public Type visit(Sample.Absyn.VoidType p, A arg)
    {
      return new Sample.Absyn.VoidType();
    }
/* TypeKW */
    public TypeKW visit(Sample.Absyn.TypeKeyword p, A arg)
    {
      return new Sample.Absyn.TypeKeyword();
    }
/* VarKW */
    public VarKW visit(Sample.Absyn.VarKeyword p, A arg)
    {
      return new Sample.Absyn.VarKeyword();
    }
/* TAnnot */
    public TAnnot visit(Sample.Absyn.TypeAnnotation p, A arg)
    {
      VarKW varkw_ = p.varkw_.accept(this, arg);
      return new Sample.Absyn.TypeAnnotation(varkw_);
    }
/* TAscript */
    public TAscript visit(Sample.Absyn.TypeAscription p, A arg)
    {
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.TypeAscription(tannot_, type_);
    }
/* Dec */
    public Dec visit(Sample.Absyn.Declaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.Declaration(ident_, type_);
    }    public Dec visit(Sample.Absyn.LcVarDeclaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new Sample.Absyn.LcVarDeclaration(ident_, type_);
    }
}