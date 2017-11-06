package debugger_p2.views;
import org.eclipse.swt.events.SelectionListener;
import javax.inject.Inject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import Logic.Parser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.*;
import org.eclipse.ui.*;
import Listas.Nodo_product_concrete;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class TextView extends ViewPart {
	Nodo_product_concrete nodo_con_metodo;
	Canvas canvas;
	 Nodo_product_concrete actual = Parser.dar_methods().inicio;
	public static Combo Menu_method;

	static Label codigo_label;
	
	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "debugger_p2.views.CodeView";

	@Inject IWorkbench workbench;
	
	public TextView() {
        super();
}
	


	@Override
	public void setFocus() {
		
	}


	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		
		GridLayout layout_inicial = new GridLayout();
		GridData Area_diagram = new GridData();
		Area_diagram.grabExcessVerticalSpace = true;
		Area_diagram.grabExcessHorizontalSpace = true;
		
		GridData Area_menu_methods = new GridData();
		Area_menu_methods.widthHint = 200;
		
		parent.setLayout(layout_inicial);
		
		Menu_method = new Combo(parent, SWT.NONE);
		Menu_method.setLayoutData(Area_menu_methods);

		ScrolledComposite container = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		container.setLayoutData(Area_diagram);
		this.canvas = new Canvas(container, SWT.NONE);
		canvas.setSize(8000, 8000);
		container.setContent(canvas);
		
		
		
		
		
//		KeyListener listener =  new KeyListener() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				addMethods();
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		};
//		
//		
//		Menu_method.setItems();
//		
//		Menu_method.addKeyListener((KeyListener) listener);
//		
		
		Menu_method.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				//ACA ES DONDE USTED TIENE QUE PONER LO QUE VA A HACER CON EL METODO SELECCIONADO
				Nodo_product_concrete actual = Parser.dar_methods().inicio;
				
				while(actual!= null) {
					
					System.out.println(actual.getNombre());
					
					if (actual.getNombre().toString().equals(Menu_method.getText().toString())) {
						System.out.println("el nodo con el metodo es  :" + nodo_con_metodo);
						nodo_con_metodo = actual;
						
						nodo_con_metodo.getDato();
						
						break;
					}
					else {
						actual = actual.getSiguiente();
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				//ESTO NO LE PONGA NADA
			}
		});	
		
		canvas.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				while (Menu_method.toString() == "") {
					
				}
				
				draw(e);
				

				
			}
		});	
	}
	
	
	
	public void draw(PaintEvent e) {
		int x = 100;
		int y = 50;
		
		//System.out.println("llego");
		
		Listas.Lista list = new Listas.Lista();
		
		//System.out.println("llego +1");
		
		Nodo_product_concrete actual = nodo_con_metodo;
		//System.out.println("el actual es: " + actual);
		//System.out.println("llego +2");
		

		
		//System.out.println("llego +3");
		

			while (actual != null) {
				if (actual.tipo == "if") {
					
					//System.out.println("llego2");
		
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(actual.statement.toString(), x +100, y +50);
					
					e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
																	//		.
					
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
					
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
				}
				
				if (actual.tipo == "while") {
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(actual.statement.toString(), x +100, y +50);
					
					e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
																	//		.
					
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
					
					e.gc.drawLine(x   , x +200, x -50, x +200);		//		.__
					e.gc.drawLine(x-50, x +200, x -50, x +50 );		//		.
					e.gc.drawLine(x-50, x +50 , x    , x +50 );		//		.__
					
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
				}
				
				if (actual.tipo == "for") {
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(actual.statement.toString(), x +100, y +50);
					
					e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
																	//		.
					
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	//  		__.
					
					e.gc.drawLine(x   , x +200, x -50, x +200);		//		.__
					e.gc.drawLine(x-50, x +200, x -50, x +50 );		//		.
					e.gc.drawLine(x-50, x +50 , x    , x +50 );		//		.__
					
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
		
				}
				
				actual.getDato().imprimirAnidados();
				
				while (actual != null) {
					
					//System.out.println("llego3");
					
					e.gc.drawRectangle(x +200, y +100, 200, 100);					//		.__________.
					e.gc.drawString(actual.statement.toString(), x +200, y +100);		//		.		   .
																					//		.__________.
					
					x+= 400;
					actual = actual.getSiguiente();
				}
				x+= 400;
			}
		}
		
	

	
	
	
	public static Combo getMethodSelector() {
		return Menu_method;
	}
	
	public void addMethods() {
		Nodo_product_concrete actual = Parser.dar_methods().inicio;
		while (actual!= null) {
			Menu_method.add(actual.getNombre().toString());
		}
	}

	
}