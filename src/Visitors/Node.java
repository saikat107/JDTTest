package Visitors;

import org.eclipse.jdt.core.dom.ASTNode;

class Node{
	ASTNode node;
	int level;
	public Node(ASTNode n, int l){
		this.node = n;
		this.level = l;
	}
	public int getLevel(){
		return level;
	}
	public ASTNode getNode(){
		return node;
	}
}
