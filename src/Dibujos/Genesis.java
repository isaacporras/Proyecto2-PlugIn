package Dibujos;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

public class Genesis implements Figura {
	Point input;
	Point output;
	int ancho = 80;
	
	public Genesis (Point input) {
		this.input = input;
		this.output = new Point(input.x, input.y + 40);
	}
	
	public Genesis (int x, int y) {
		this (new Point (x,y));
	}
	
	public Point getOutput() {
		return output;
	}
	
	public Point getInput() {
		return input;
	}
	
	public int getAncho() {
		return this.ancho;
	}

	@Override
	public void draw(GC gc) {
		gc.drawOval(input.x - this.ancho / 2, input.y, this.ancho, 40);
		gc.drawText("Start", input.x - gc.stringExtent("Start").x / 2, input.y + (40 - gc.stringExtent("Start").y) / 2);

	}

	@Override
	public void fix(int x) {
		input = new Point(input.x + x, input.y);
		output = new Point(output.x + x, output.y);
	}

}
