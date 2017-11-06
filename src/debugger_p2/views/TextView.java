package debugger_p2.views;
import org.eclipse.swt.events.SelectionListener;
import java.util.LinkedList;
import javax.inject.Inject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import Logic.Parser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.part.*;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import javax.inject.Inject;
import Listas.Lista;
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
		canvas.setSize(1000, 1000);
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
				Nodo_product_concrete nodo_con_metodo;
				while(actual!= null) {
					
					System.out.println(actual.getNombre());
					
					if (actual.getNombre().toString().equals(Menu_method.getText().toString())) {
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
				e.gc.drawRectangle(10, 150, 150, 10);
				e.gc.drawOval(50,80, 80, 80);
			}
		});	
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

