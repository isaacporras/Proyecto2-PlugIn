package Logic;

import debugger_p2.views.TextView;
import Listas.Lista;
import Listas.Nodo_product_concrete;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.IfStatement;

import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * Clase Parser
 * @author IsaacPorras
 *Descripcion: En esta clase es donde se parsea el codigo
 */
public class Parser {
	static String [] metodos;
	String class_name ="";
	Lista lista_class = new Lista();
	static Lista lista_methods = new Lista();
	Lista lista_statements = new Lista();
	
	String sourceStart = "public class A {";
	//add a fake class A as a shell, to meet the requirement of ASTParser
	String sourceMiddle = "";
	
	
	String sourceEnd = "}";
	/**
	 * Este metodo a partir del codigo agarra el nombre de la clase
	 * @param code el codigo del archivo
	 * @return el nombre de la clase
	 */
	public String getClass(String code) {
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(code.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		final CompilationUnit compilation2 = (CompilationUnit) parser.createAST(null);
		String className = "";
		compilation2.accept(new ASTVisitor() {
 
			Set names = new HashSet();
 
			public boolean visit (TypeDeclaration  node) {
				String packageName ="";
				packageName = node.getName().getFullyQualifiedName();
				String className = node.getName().getFullyQualifiedName();
	            if (packageName!="")
	                System.out.println(packageName + "."+ className);
	            
	            else
	                System.out.println(className);

	            return false;
			}
		
 
		});
		class_name = className;
		return className;
	}
	/*
	 * Este metodo agarra el string que se va a parsear y saca los metodos qyue hay adentro y
	 *  luego agarra los bloques que hay dentro de ese metodo
	 */
	public void parse (String code){
		
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(code.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
//		getClass(code);
		
		lista_class.ingresarDato(getClass(code), lista_methods, "class");
		
		
		final CompilationUnit compilation2 = (CompilationUnit) parser.createAST(null);
			
		compilation2.accept(new ASTVisitor() {
 
			Set names = new HashSet();
 
			public boolean visit (MethodDeclaration node) {
				
				 Lista lista_method = new Lista();
				 
				System.out.println("Nombre del metodo: " + node.getName());
				
				
				lista_methods.ingresarDato(node.getName().toString(), lista_method, "metodo");
				
				
				ArrayList<Integer> al = new ArrayList<Integer>();
				
				al.add(node.getStartPosition());
				
				al.add(node.getLength());
				
				Block b1 = (Block) node.getBody();
				
				sacar_statements(b1.statements(), lista_method, node.getName().toString());
				
				return false;
			}
 
		});
		
		System.out.println("--------------------LA LISTA ES -----------");
		lista_class.imprimirClass();
		lista_methods.imprimirMetodos();
		metodos =  new String[lista_methods.largo];
		dar_ArrayMetodos();
		System.out.println("--------------------SE TERMINA LA LISTA -----------");
	}
	
	/**
	 * Saca los statements del bloque que le va pasando el metodo visit y este los 
	 * redireccinona para que el metodo analizar_statements los pueda analizar uno por uno
	 * @param Statements los statements
	 * @param lista_metodos la lista de metodos
	 * @param nombre_del_metodo el nombre de metodo
	 */
	public void sacar_statements(List<Block> Statements, Lista lista_metodos, String nombre_del_metodo) {
		
		for (Object statement : Statements) {
			
			ASTNode state = (ASTNode) statement;
			analizar_statement(state, lista_metodos, nombre_del_metodo);
		}
	}
	
	/**
	 * Analiza los statements para ver si son for, while, if, etc...
	 * @param state el statement
	 * @param methods los metodos
	 * @param nombre_del_metodo el nombre del metodo
	 */
	public void analizar_statement(ASTNode state, Lista methods, String  nombre_del_metodo) {
		
		String[] array = state.getClass().toString().split("\\.");
		String estatuto = array[array.length - 1];
		
		Lista statements = new Lista();
		
		if (estatuto.equalsIgnoreCase("WhileStatement")) {
			
			WhileStatement statementWhile = (WhileStatement) state;
			
			Block block = (Block) statementWhile.getBody();
			
			methods.ingresarDato(statementWhile.getExpression(), statements, "while");
			
			statements.ingresarDato(block.statements(), null, null);
			
//			sacar_statements(block.statements(), null,"Statement anidado");
			
		}
		else if (estatuto.equalsIgnoreCase("EnhancedForStatement")) {
			
			EnhancedForStatement estatutoEnhancedFor = (EnhancedForStatement) state;
			System.out.println("Enhance For:" + estatutoEnhancedFor.getExpression());
			Block block = (Block) estatutoEnhancedFor.getBody();
			methods.ingresarDato(estatutoEnhancedFor.getExpression(), statements, "EnhancedFor");
			
			statements.ingresarDato(block.statements(), null, null);
			
//			sacar_statements(block.statements(), statements ,"Statement anidado"); 
			
			

		}
		else if (estatuto.equalsIgnoreCase("ForStatement")) {
			
			ForStatement estatutoFor = (ForStatement) state;
			System.out.println("For:" + estatutoFor.getExpression());
			Block block = (Block) estatutoFor.getBody();
			
			methods.ingresarDato(estatutoFor.getExpression(), statements, "for");

			statements.ingresarDato(block.statements(), null, null);
			
//			sacar_statements(block.statements(), statements, "Statement anidado"); 
			
		} 
		else if (estatuto.equalsIgnoreCase("IfStatement")) {
			
			IfStatement estatutoIf = (IfStatement) state;
			System.out.println("If:"+ estatutoIf.getExpression());
			methods.ingresarDato(estatutoIf.getExpression(), statements ,"if");
			
			Block block = (Block) estatutoIf.getThenStatement();
			
			statements.ingresarDato(block.statements(), null, null);
			
//			sacar_statements( b1.statements(), statements, "Statement anidado");
			
		} 
		else if (estatuto.equalsIgnoreCase("VariableDeclarationStatement")) {
			
			VariableDeclarationStatement estatutoVariable = (VariableDeclarationStatement) state;
			
			System.out.println("Variable:" + estatutoVariable);
			methods.ingresarDato(estatutoVariable , null,"variable");
			
		}
		else {
			System.out.println("ERROR : " + estatuto);
		}
	}

	public static Lista dar_methods() {
		return lista_methods;
	}
	public static String[] dar_ArrayMetodos() {
		Nodo_product_concrete actual = Parser.lista_methods.inicio;
		while (actual!= null) {
			TextView.getMethodSelector().add(actual.getNombre().toString());
			actual = actual.getSiguiente();
		}
		
		return metodos;
	}
}
