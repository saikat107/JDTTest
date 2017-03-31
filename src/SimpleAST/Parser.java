package SimpleAST;

import org.eclipse.jdt.core.dom.ASTVisitor;

public interface Parser {
	public void parse(ASTVisitor visitor);
}
