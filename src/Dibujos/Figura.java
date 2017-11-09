package Dibujos;

import org.eclipse.swt.graphics.GC;

public interface Figura {
	
	public void draw(GC gc);
	public void fix(int x);
}
