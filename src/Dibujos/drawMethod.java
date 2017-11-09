package Dibujos;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class drawMethod implements Figura{
	String text;
	Point input;
	Point output;
	Rectangle focus;
	int line;

	public drawMethod(String text, Point input, int line) {
		this.input = input;
		this.output = new Point(input.x, input.y + 40);
		this.text = text;
		this.line = line;
	}

	public drawMethod(String text, int x, int y, int line) {
		this(text, new Point(x, y), line);
	}
	

	public Point getOutput() {
		return output;
	}

	public Point getInput() {
		return input;
	}
	
	@Override
	public void draw(GC gc) {
		Display display = Display.getCurrent();
		Color color;
		int border;

		Rectangle rectangle = new Rectangle(input.x - 10 - gc.stringExtent(text).x / 2, input.y, gc.stringExtent(text).x + 20, 40);
		gc.drawRectangle(rectangle);
		Rectangle externalRectangle = new Rectangle(input.x - 20 - gc.stringExtent(text).x / 2, input.y, gc.stringExtent(text).x + 40, 40);
		gc.drawRectangle(externalRectangle);
		gc.drawText(text, input.x - gc.stringExtent(text).x / 2, input.y + (40 - gc.stringExtent(text).y) / 2);
	}
	@Override
	public void fix(int x) {
		input = new Point(input.x + x, input.y);
		output = new Point(output.x + x, output.y);
	}
	public int getWidth() {
		Shell shell = new Shell();
		GC gc = new GC(shell);
		return gc.stringExtent(text).x + 40;
	}
	
	public int getLine() {
		return this.line;
	}
}
