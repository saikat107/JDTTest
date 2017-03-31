package SimpleAST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;


public class FileASTParser implements Parser{
	private String fileName;
	public FileASTParser(String fileName){
		this.fileName = fileName;
	}
	
	public void parse(ASTVisitor vistor){
		File file = new File(fileName);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			String fileString = scanner.nextLine();
			   while (scanner.hasNextLine()) {
				   fileString = fileString + "\n" + scanner.nextLine();
			   }
			   char[] charArray = fileString.toCharArray();
			   
			   ASTParser parser = ASTParser.newParser(AST.JLS8);
			   parser.setKind(ASTParser.K_COMPILATION_UNIT);
			   parser.setResolveBindings(true);
			   parser.setBindingsRecovery(true);
			   
			   String[] sources = {"/Users/saikat/Documents/workspace/JDTTest/src"};
			   String[] classpath = {"/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/lib/rt.jar"};
			   parser.setEnvironment(classpath, sources, new String[]{"UTF-8"}, true);
			   parser.setSource(charArray);
			   //parser.createAST(null);
			   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
