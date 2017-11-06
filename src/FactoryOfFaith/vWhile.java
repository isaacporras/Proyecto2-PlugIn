package FactoryOfFaith;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;

public class vWhile extends Placer
{
	public void Draw (Graphics2D g)
	{
	    Double w1 = new Line2D.Double(getPosx(),getPosy()+50,getPosx()+150,getPosy());
	    Double w2 = new Line2D.Double(getPosx()+150,getPosy(),getPosx()+300,getPosy()+50);
	    Double w3 = new Line2D.Double(getPosx()+300,getPosy()+50,getPosx()+150,getPosy()+100);
	    Double w4 = new Line2D.Double(getPosx()+150,getPosy()+100,getPosx(),getPosy()+50);
	    
	    Double w5 = new Line2D.Double(getPosx()+150,getPosy()+100,getPosx()+150,getPosy()+150);
	    
	    java.awt.geom.Rectangle2D.Double w6 = new Rectangle2D.Double(getPosx(),getPosy()+150,300,100);
	    
	    Double w7 = new Line2D.Double(getPosx()+150,getPosy()+250,getPosx()+150,getPosy()+300);
	    Double w8 = new Line2D.Double(getPosx()+150, getPosy()+300, getPosx()-50, getPosy()+300);
	    Double w9 = new Line2D.Double(getPosx()-50, getPosy()+300, getPosx()-50, getPosy()+50);
	    Double w10 = new Line2D.Double(getPosx()-50, getPosy()+50, getPosx(), getPosy()+50);
	    Double w11 = new Line2D.Double(getPosx()+300, getPosy()+50, getPosx()+350, getPosy()+50);
	    Double w12 = new Line2D.Double(getPosx()+350, getPosy()+50, getPosx()+350, getPosy()+350);
	    Double w13 = new Line2D.Double(getPosx()+350, getPosy()+350, getPosx()+150, getPosy()+350);
	    Double w14 = new Line2D.Double(getPosx()+150, getPosy()+350, getPosx()+150, getPosy()+400);
	}
}
