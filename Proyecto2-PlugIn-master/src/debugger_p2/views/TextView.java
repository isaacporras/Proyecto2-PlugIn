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
	int x = 100;
	int y = 50;
	
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
		
		Menu_method.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				//ACA ES DONDE USTED TIENE QUE PONER LO QUE VA A HACER CON EL METODO SELECCIONADO
				Nodo_product_concrete actual = Parser.dar_methods().inicio;
				
				while( actual!= null) {
					
					System.out.println(actual.getNombre());
					
					if (actual.getNombre().toString().equals(Menu_method.getText().toString())) {
						
						nodo_con_metodo = actual;
						System.out.println("-------EL NODO CON METODO ES:" + nodo_con_metodo.getNombre() );
						System.out.println(nodo_con_metodo.getDato());
						manage(nodo_con_metodo);
						
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
	}
	public void manage(Nodo_product_concrete nodo_con_metodo) {
		canvas.addPaintListener(new PaintListener() {
			
			Nodo_product_concrete nodo = nodo_con_metodo.getDato().inicio;
			@Override
			public void paintControl(PaintEvent e) {
				
				
				if (nodo.tipo == "if") {
					
					canvas.redraw();
					
					System.out.println("SE DIBUJO IF");
				
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(nodo.statement.toString(), x +50, y +50);
							
					e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
																	//		.
							
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
							
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
					
					
					
				}
						
				if (nodo.tipo == "while") {
					
					canvas.redraw();
					
					System.out.println("SE DIBUJO WHILE");
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(nodo.statement.toString(), x +50, y +50);
							
					e.gc.drawLine(x +100, y +100, x +100, y +150);			//		.
																			//		.
							
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
					
					e.gc.drawLine(x , y +50 , x -50  , y +50 );			//		.__
					e.gc.drawLine(x -50 , y +200, x -50, y +50 );		//		.
					e.gc.drawLine(x -5 , y +200, x, y +200);			//		.__
					
							
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
					
					
					
				}
						
				if (nodo.tipo == "for") {
					
					canvas.redraw();
					
					System.out.println("SE DIBUJO FOR");
					e.gc.drawOval(x, y, 200, 100);
					e.gc.drawString(nodo.statement.toString(), x +50, y +50);
							
					e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
																			//		.
							
					e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
					e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
					e.gc.drawLine(x +250, y +300, x +100, y +300);	//  	__.
							
					e.gc.drawLine(x , y +50 , x -50  , y +50 );			//		.__
					e.gc.drawLine(x -50 , y +200, x -50, y +50 );		//		.
					e.gc.drawLine(x -5 , y +200, x, y +200);			//		.__
					
					
					e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
																	//		.
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

				
//				e.gc.drawRectangle(x , y +150, 200, 100);
//				e.gc.drawString(node.tipo.toString(), x+50, y+200);
//			//	e.gc.drawString(nodo_con_metodo.getNombre().toString(), x +50, y +200);	
//				
//				while (node != null) {
//					draw(e, node);
//					node = node.getSiguiente();
//					//break;
//				}
				
				
				

				
				
			}
		});	
	}
	
	
	
	
//	public void draw(PaintEvent e,Nodo_product_concrete nodo ) {
//		
//		
//		if (nodo.tipo == "if") {
//					
//			System.out.println("SE DIBUJO IF");
//		
//			e.gc.drawOval(x, y, 200, 100);
//			//e.gc.drawString((nodo_con_metodo.getNombre().toString()), x+50, y+50);
//			e.gc.drawString(nodo.statement.toString(), x +50, y +50);
//					
//			e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
//																	//		.
//					
//			e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
//			e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
//			e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
//					
//			e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
//															//		.
//			
//			
//			
//		}
//				
//		if (nodo.tipo == "while") {
//			System.out.println("SE DIBUJO WHILE");
//			e.gc.drawOval(x, y, 200, 100);
//			e.gc.drawString(nodo.statement.toString(), x +50, y +50);
//					
//			e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
//																	//		.
//					
//			e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
//			e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
//			e.gc.drawLine(x +250, y +300, x +100, y +300);	// 	 	__.
//			
//			e.gc.drawLine(x , y +50 , x -50  , y +50 );			//		.__
//			e.gc.drawLine(x -50 , y +200, x -50, y +50 );		//		.
//			e.gc.drawLine(x -5 , y +200, x, y +200);			//		.__
//			
//					
//			e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
//															//		.
//			
//			
//			
//		}
//				
//		if (nodo.tipo == "for") {
//			
//			System.out.println("SE DIBUJO FOR");
//			e.gc.drawOval(x, y, 200, 100);
//			e.gc.drawString(nodo.statement.toString(), x +50, y +50);
//					
//			e.gc.drawLine(x +100, y +100, x +100, y +150);	//		.
//																	//		.
//					
//			e.gc.drawLine(x +200, y +50 , x +250, y +50 );	//		__.
//			e.gc.drawLine(x +250, y +50 , x +250, y +300);	//		  .
//			e.gc.drawLine(x +250, y +300, x +100, y +300);	//  	__.
//					
//			e.gc.drawLine(x , y +50 , x -50  , y +50 );			//		.__
//			e.gc.drawLine(x -50 , y +200, x -50, y +50 );		//		.
//			e.gc.drawLine(x -5 , y +200, x, y +200);			//		.__
//			
//			
//			e.gc.drawLine(x +100, y +250, x +100, y +350);	//		.
//															//		.
//		}
//				
//
//	}
	
	
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