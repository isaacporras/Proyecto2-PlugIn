package debugger_p2.importWizards;



import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MyPageOne extends WizardPage {
	
    protected MyPageOne() {
		super("URL");
		// TODO Auto-generated constructor stub
	}

	private Text text1;
    private Composite container;

    

    @Override
    public void createControl(Composite parent) {
    	
        container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 6;
        Label label1 = new Label(container, SWT.NONE);
        label1.setText("Arrastre el archivo aquí: ");

        text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
        text1.setText("/home/rex/Desktop/Calculadora.java");
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        
        text1.setLayoutData(gd);
        text1.setBounds(700,700, 700, 700);
        setControl(container);
//        setPageComplete(false);

    }

    public String getText1() {
        return text1.getText();
    }
}
