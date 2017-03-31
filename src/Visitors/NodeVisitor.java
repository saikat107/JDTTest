package Visitors;

import org.eclipse.jdt.core.dom.ASTNode;

public interface NodeVisitor {
	public static final int VISIT_NODE_ONLY = 0;
	public static final int VISIT_SUBTREE_DFS = 1;
	public static final int VISIT_SUBTREE_BFS = 2;
	public void visit(ASTNode node, int visiting_mode);
}
