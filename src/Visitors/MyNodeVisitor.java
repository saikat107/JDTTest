package Visitors;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;

public class MyNodeVisitor implements NodeVisitor {

	@Override
	public void visit(ASTNode rootNode, int visiting_mode) {
		if(visiting_mode == NodeVisitor.VISIT_NODE_ONLY){
			if(rootNode instanceof SimpleName){
				SimpleName sl = ((SimpleName) rootNode);
				System.out.println(sl.getClass() + " ---- " + sl.getIdentifier())	;
			}
			System.out.println(rootNode.properties() + " " + rootNode.toString());
		}
		else if(visiting_mode == NodeVisitor.VISIT_SUBTREE_BFS){
			visitInBFS(rootNode);
		}
		else if(visiting_mode == NodeVisitor.VISIT_SUBTREE_DFS){
			visitInDFS(rootNode);
		}

	}

	private void visitInDFS(ASTNode rootNode) {
		// TODO Auto-generated method stub
		
	}

	private void visitInBFS(ASTNode node) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new Node(node, 0));
		while(!queue.isEmpty()){
			Node root = queue.poll();
			ASTNode rootNode = root.getNode();
			int l = root.getLevel();
			visit(rootNode, NodeVisitor.VISIT_NODE_ONLY);
			List<ASTNode> children = getChildren(rootNode);
			for(ASTNode child:children){
				queue.add(new Node(child, l+1));
			}
		}
		
	}
	
	public  List<ASTNode> getChildren(ASTNode node) {
	    List<ASTNode> children = new ArrayList<ASTNode>();
	    List list = node.structuralPropertiesForType();
	    for (int i = 0; i < list.size(); i++) {
	        Object child = node.getStructuralProperty((StructuralPropertyDescriptor)list.get(i));
	        if(child instanceof ASTNode){
	        	children.add((ASTNode) child);
	        }
	        else if (child instanceof List){
	        	List clist = (List)child;
	        	for(Object obj:clist){
	        		children.add((ASTNode)obj);
	        	}
	        }
	        else if(child != null){
	        	//System.out.println(child.getClass());
	        }
	    }
	    return children;
	}

}
