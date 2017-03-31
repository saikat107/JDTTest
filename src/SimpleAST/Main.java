package SimpleAST;

import org.eclipse.jdt.core.dom.ASTVisitor;

import Visitors.IfStatementVisitor;
import Visitors.MyNodeVisitor;
import Visitors.NodeVisitor;

public class Main {
	public static void main(String[] args) {
		String fileName = "src/TestFile/TestInput.java";
		Parser parser = new FileASTParser(fileName);
		NodeVisitor nodeVisitor = new MyNodeVisitor();
		ASTVisitor visitor = new IfStatementVisitor(nodeVisitor);
		parser.parse(visitor);
		
	}
}
