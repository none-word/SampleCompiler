package Sample;

import Sample.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  Sample.Absyn.Program.Visitor<R,A>,
  Sample.Absyn.Expr.Visitor<R,A>,
  Sample.Absyn.ComaExprs.Visitor<R,A>,
  Sample.Absyn.FArgs.Visitor<R,A>,
  Sample.Absyn.Type.Visitor<R,A>,
  Sample.Absyn.TypeKW.Visitor<R,A>,
  Sample.Absyn.VarKW.Visitor<R,A>,
  Sample.Absyn.TAnnot.Visitor<R,A>,
  Sample.Absyn.TAscript.Visitor<R,A>,
  Sample.Absyn.Dec.Visitor<R,A>
{}
