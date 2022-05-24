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
  sample.Absyn.TypeAl.Visitor<sample.Absyn.TypeAl,A>,
  sample.Absyn.VarKW.Visitor<sample.Absyn.VarKW,A>,
  sample.Absyn.TAnnot.Visitor<sample.Absyn.TAnnot,A>,
  sample.Absyn.TAscript.Visitor<sample.Absyn.TAscript,A>,
  sample.Absyn.Dec.Visitor<sample.Absyn.Dec,A>,
  sample.Absyn.GlDec.Visitor<sample.Absyn.GlDec,A>,
  sample.Absyn.Field.Visitor<sample.Absyn.Field,A>,
  sample.Absyn.Fields.Visitor<sample.Absyn.Fields,A>
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
    public Expr visit(sample.Absyn.Import p, A arg)
    {
      String ident_ = p.ident_;
      return new sample.Absyn.Import(ident_);
    }    public Expr visit(sample.Absyn.Var p, A arg)
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
      Expr expr_ = p.expr_.accept(this, arg);
      Program program_1 = p.program_1.accept(this, arg);
      Program program_2 = p.program_2.accept(this, arg);
      return new sample.Absyn.If(expr_, program_1, program_2);
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
    }    public Expr visit(sample.Absyn.TypeAlFunc p, A arg)
    {
      String ident_1 = p.ident_1;
      FArgs fargs_ = p.fargs_.accept(this, arg);
      String ident_2 = p.ident_2;
      Program program_ = p.program_.accept(this, arg);
      return new sample.Absyn.TypeAlFunc(ident_1, fargs_, ident_2, program_);
    }    public Expr visit(sample.Absyn.AnonymFunc p, A arg)
    {
      FArgs fargs_ = p.fargs_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.AnonymFunc(fargs_, program_, type_);
    }    public Expr visit(sample.Absyn.TypeAlAnonymFunc p, A arg)
    {
      FArgs fargs_ = p.fargs_.accept(this, arg);
      Program program_ = p.program_.accept(this, arg);
      String ident_ = p.ident_;
      return new sample.Absyn.TypeAlAnonymFunc(fargs_, program_, ident_);
    }    public Expr visit(sample.Absyn.Return p, A arg)
    {
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Return(expr_);
    }    public Expr visit(sample.Absyn.NilKeyword p, A arg)
    {
      return new sample.Absyn.NilKeyword();
    }    public Expr visit(sample.Absyn.TypeAliasing p, A arg)
    {
      TypeAl typeal_ = p.typeal_.accept(this, arg);
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.TypeAliasing(typeal_, type_);
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
    }    public Expr visit(sample.Absyn.LetBinding p, A arg)
    {
      Fields fields_ = p.fields_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.LetBinding(fields_, expr_);
    }    public Expr visit(sample.Absyn.VarTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.VarTypeAnnotation(ident_, tannot_, expr_);
    }    public Expr visit(sample.Absyn.GlVarTypeAnnotation p, A arg)
    {
      String ident_ = p.ident_;
      TAnnot tannot_ = p.tannot_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.GlVarTypeAnnotation(ident_, tannot_, expr_);
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
    }    public Expr visit(sample.Absyn.GlVarTypeAscription p, A arg)
    {
      String ident_ = p.ident_;
      TAscript tascript_ = p.tascript_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.GlVarTypeAscription(ident_, tascript_, expr_);
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
    }    public Expr visit(sample.Absyn.OnlyGlDecl p, A arg)
    {
      GlDec gldec_ = p.gldec_.accept(this, arg);
      return new sample.Absyn.OnlyGlDecl(gldec_);
    }    public Expr visit(sample.Absyn.InitDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.InitDecl(dec_, expr_);
    }    public Expr visit(sample.Absyn.InitGlDecl p, A arg)
    {
      GlDec gldec_ = p.gldec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.InitGlDecl(gldec_, expr_);
    }    public Expr visit(sample.Absyn.TableDecl p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new sample.Absyn.TableDecl(dec_, ident_1, ident_2);
    }    public Expr visit(sample.Absyn.GlTableDecl p, A arg)
    {
      GlDec gldec_ = p.gldec_.accept(this, arg);
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new sample.Absyn.GlTableDecl(gldec_, ident_1, ident_2);
    }    public Expr visit(sample.Absyn.InitTableDecl p, A arg)
    {
      Dec dec_1 = p.dec_1.accept(this, arg);
      Dec dec_2 = p.dec_2.accept(this, arg);
      Dec dec_3 = p.dec_3.accept(this, arg);
      return new sample.Absyn.InitTableDecl(dec_1, dec_2, dec_3);
    }    public Expr visit(sample.Absyn.InitGlTableDecl p, A arg)
    {
      GlDec gldec_ = p.gldec_.accept(this, arg);
      Dec dec_1 = p.dec_1.accept(this, arg);
      Dec dec_2 = p.dec_2.accept(this, arg);
      return new sample.Absyn.InitGlTableDecl(gldec_, dec_1, dec_2);
    }    public Expr visit(sample.Absyn.TableElementCall p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new sample.Absyn.TableElementCall(ident_1, ident_2);
    }    public Expr visit(sample.Absyn.TableElementAssignment p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.TableElementAssignment(ident_1, ident_2, expr_);
    }    public Expr visit(sample.Absyn.Assignment p, A arg)
    {
      String ident_ = p.ident_;
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.Assignment(ident_, expr_);
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
    }    public Type visit(sample.Absyn.VoidType p, A arg)
    {
      return new sample.Absyn.VoidType();
    }
/* TypeAl */
    public TypeAl visit(sample.Absyn.TypeAlIdent p, A arg)
    {
      String ident_ = p.ident_;
      return new sample.Absyn.TypeAlIdent(ident_);
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
    }    public Dec visit(sample.Absyn.TypeAlDecl p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new sample.Absyn.TypeAlDecl(ident_1, ident_2);
    }
/* GlDec */
    public GlDec visit(sample.Absyn.GlDeclaration p, A arg)
    {
      String ident_ = p.ident_;
      Type type_ = p.type_.accept(this, arg);
      return new sample.Absyn.GlDeclaration(ident_, type_);
    }    public GlDec visit(sample.Absyn.TypeAlGlDec p, A arg)
    {
      String ident_1 = p.ident_1;
      String ident_2 = p.ident_2;
      return new sample.Absyn.TypeAlGlDec(ident_1, ident_2);
    }
/* Field */
    public Field visit(sample.Absyn.TypeAnField p, A arg)
    {
      String ident_ = p.ident_;
      VarKW varkw_ = p.varkw_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.TypeAnField(ident_, varkw_, expr_);
    }    public Field visit(sample.Absyn.LBField p, A arg)
    {
      Dec dec_ = p.dec_.accept(this, arg);
      Expr expr_ = p.expr_.accept(this, arg);
      return new sample.Absyn.LBField(dec_, expr_);
    }
/* Fields */
    public Fields visit(sample.Absyn.LBFields p, A arg)
    {
      ListField listfield_ = new ListField();
      for (Field x : p.listfield_)
      {
        listfield_.add(x.accept(this,arg));
      }
      return new sample.Absyn.LBFields(listfield_);
    }
}