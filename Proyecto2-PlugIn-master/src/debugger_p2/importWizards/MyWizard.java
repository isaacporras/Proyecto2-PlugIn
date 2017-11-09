package debugger_p2.importWizards;
import debugger_p2.views.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jface.wizard.Wizard;
import Logic.Parser;

import debugger_p2.handlers.*;
import debugger_p2.views.*;
public class MyWizard extends Wizard {

    protected MyPageOne one;
    

    public MyWizard() {
        super();
        setNeedsProgressMonitor(false);
    }

    @Override
    public String getWindowTitle() {
        return "Importando archivo";
    }

    @Override
    public void addPages() {
        one = new MyPageOne();
        
        addPage(one);
        
    }

    @Override
    public boolean performFinish() {
        System.out.println(one.getText1());
        try {
        	
        		leer_archivo(one.getText1());
      	  
		} 
        catch (IOException e1) {
			
			e1.printStackTrace();
			System.out.print("CATCH");
		}

        return true;
    }
    
    public void leer_archivo(String path) throws IOException {	
    	
  
    		
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(path));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
		System.out.println(fileData.toString());
		Code_View.agregar_texto(fileData.toString());
		
        
        System.out.println(fileData.toString());
        System.out.println("Se inicia el parser");
        Parser par = new Parser();
        par.parse(fileData.toString());
        System.out.println(fileData.toString());
    }
}
