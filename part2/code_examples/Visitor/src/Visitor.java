

public abstract class Visitor {
	public abstract void visit(Number exp);
	public abstract void visit(Variable exp);
	public abstract void visit(Sum exp);
	public abstract void visit(Minus exp);
	public abstract void visit(AbstractExpression exp);
	
}
