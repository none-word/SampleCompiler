package Sample;

import Sample.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  Sample.Absyn.Expr.Visitor<R,A>,
  Sample.Absyn.Assignment_op.Visitor<R,A>,
  Sample.Absyn.Dec.Visitor<R,A>,
  Sample.Absyn.Type.Visitor<R,A>,
  Sample.Absyn.FieldTypeExpr.Visitor<R,A>
{}
