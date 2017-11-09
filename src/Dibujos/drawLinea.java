package Dibujos;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

public class drawLinea implements Figura{
	Point start;
	Point finish;
	TipoLinea type;
	String text= "";
	int width;
	
	/**
	 * Constructor para el grafico de una linea
	 * @param start Punto de inicio de la linea
	 * @param finish Punto final de la linea
	 */
	public drawLinea(Point start, Point finish) {
		this.start = start;
		this.finish = finish;
		this.type = TipoLinea.NONE;
	}
	
	public drawLinea(Point start, Point finish, int width) {
		this(start, finish);
		this.width = width;
	}
	
	public drawLinea(Point start, Point finish, int width, TipoLinea type) {
		this(start, finish);
		this.width = width;
		this.type = type;
	}
	
	public drawLinea(Point start, Point finish, TipoLinea type) {
		this(start, finish);
		this.type = type;
	}
	
	public drawLinea(Point start, Point finish, TipoLinea type, String text) {
		this(start, finish, type);
		this.text = text;
	}	
	
	public drawLinea(Point start, Point finish, TipoLinea type, String text, int width) {
		this(start, finish, width);
		this.type = type;
		this.text = text;
	}	
	
	public drawLinea(Point start, Point finish, String text) {
		this(start, finish);
		this.text = text;
	}
	
	/**
	 * Dibuja el elemento en el contexto grafico
	 * @param gc Contexto grafico en el cual se va a dibujar
	 */
	public void draw(GC gc) {
	Display display = Display.getCurrent();
	Color color = display.getSystemColor(SWT.COLOR_BLACK);
	gc.setForeground(color);
	gc.setLineWidth(1);
		switch (this.type) {
		case DORETURN:
			gc.drawLine(this.start.x, this.start.y, this.start.x - this.width / 2 - 20, this.start.y);
			gc.drawLine(this.start.x - this.width / 2 - 20, this.start.y, this.start.x - this.width / 2 - 20, this.finish.y);
			gc.drawLine(this.start.x - this.width / 2 - 20, this.finish.y, this.finish.x, this.finish.y);
			break;
		case RETURN:
			gc.drawLine(this.start.x, this.start.y, this.start.x, this.start.y + 10);
			gc.drawLine(this.start.x, this.start.y + 10, this.start.x - this.width / 2 - 20, this.start.y + 10);
			gc.drawLine(this.start.x - this.width / 2 - 20, this.start.y + 10, this.start.x - this.width / 2 - 20, this.finish.y);
			gc.drawLine(this.start.x - this.width / 2 - 20, this.finish.y, this.finish.x, this.finish.y);
			break;
		case JOIN:
			gc.drawLine(this.start.x, this.start.y, this.start.x, this.finish.y);
			gc.drawLine(this.start.x, this.finish.y, this.finish.x, this.finish.y);
			break;
		case JUMP:
			gc.drawText(text, this.start.x + 10, this.start.y - 15);
			gc.drawLine(this.start.x, this.start.y, this.start.x + this.width / 2 + 20, this.start.y);
			gc.drawLine(this.start.x + this.width / 2 + 20, this.start.y, this.start.x + this.width / 2 + 20, this.finish.y);
			gc.drawLine(this.start.x + this.width / 2 + 20, this.finish.y,	this.finish.x, this.finish.y);
			break;
		case NONE:
			if (this.start.x != this.finish.x) {
				if (this.finish.x < this.start.x) {
					gc.drawText(text, start.x - 30, start.y - 15);
				} else {
					gc.drawText(text, this.start.x + 10, this.start.y - 15);
				}
				gc.drawLine(this.start.x, this.start.y, this.finish.x, this.start.y);
				gc.drawLine(this.finish.x, this.start.y, this.finish.x, this.finish.y);
			} else {
				gc.drawText(text, this.start.x + 5, this.start.y + 5);
				gc.drawLine(this.start.x, this.start.y, this.finish.x, this.finish.y);
			}
			break;
		}
		}

	@Override
	public void fix(int x) {
		start = new Point(start.x + x, start.y);
		finish = new Point(finish.x + x, finish.y);
	}
}
