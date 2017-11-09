package Dibujos;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class drawIf implements Figura{
	String text;
	Point input;
	Point outputV;
	Point outputF;
	Rectangle focus;
	int[] shape;
	int line;
	
	public drawIf(String text, Point input) {
		
		Shell shell = new Shell();
		GC gc = new GC(shell);
		
		this.input = input;
		this.outputV = new Point (input.x - 30 - gc.stringExtent(text).x / 2, input.y + gc.stringExtent(text).y / 2 + 20);
		this.outputF = new Point(input.x + 30 + gc.stringExtent(text).x / 2, input.y + gc.stringExtent(text).y / 2 + 20);
		this.text = text;
		
	}
	
	public drawIf(String text, int x, int y, int line) {
		this(text, new Point(x,y));
	}
	
	public Point getInput() {
		return input;
	}
	
	public Point getOutputV() {
		return outputV;
	}
	
	public Point getOutputF() {
		return outputF;
	}
	
	public int getAncho() {
		return outputF.x - outputV.x;
	}

	@Override
	public void draw(GC gc) {
		shape = new int[] {input.x, input.y, outputF.x, outputF.y, input.x, input.y + gc.stringExtent(text).y + 40, outputV.x, outputV.y};
		Display display = Display.getCurrent();
		Color color;
		int border;
		if (line == this.line) {
			color = display.getSystemColor(SWT.COLOR_RED);
			border = 3;
		} else {
			color = display.getSystemColor(SWT.COLOR_BLACK);
			border = 1;
		}
		gc.setForeground(color);
		gc.setLineWidth(border);
		gc.drawPolygon(shape);
		gc.drawText(text, input.x - gc.stringExtent(text).x / 2, input.y + 20);
		
	}

	@Override
	public void fix(int x) {
		input = new Point(input.x + x, input.y);
		outputV = new Point(outputV.x + x, outputV.y);
		outputF = new Point(outputF.x + x, outputF.y);
		
	}

}
