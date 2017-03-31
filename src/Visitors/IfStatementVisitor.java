package Visitors;


import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;


public class IfStatementVisitor extends ASTVisitor{
	
	private NodeVisitor nodeVisitor;
	public IfStatementVisitor(NodeVisitor nodeVisitor){
		this.nodeVisitor = nodeVisitor;
	}
	
	public boolean visit(IfStatement node){
		System.out.println(node.getNodeType());
		nodeVisitor.visit(node, NodeVisitor.VISIT_SUBTREE_BFS);
		return true;
	}
	
	
	
}
