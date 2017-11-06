package FactoryOfFaith;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;

public class vFor extends Placer
{
	public void Draw (Graphics2D g)
	{
		java.awt.geom.Rectangle2D.Double f1 = new Rectangle2D.Double(getPosx(),getPosy(),300,100);
	    
	    Double f2 = new Line2D.Double(getPosx()+150, getPosy()+100, getPosx()+150, getPosy()+150);
	    
	    Double f3 = new Line2D.Double(getPosx(), getPosy()+200, getPosx()+150, getPosy()+150);
	    Double f4 = new Line2D.Double(getPosx()+150, getPosy()+150, getPosx()+300, getPosy()+200);
	    Double f5 = new Line2D.Double(getPosx()+300, getPosy()+200, getPosx()+150, getPosy()+250);
	    Double f6 = new Line2D.Double(getPosx()+150, getPosy()+250, getPosx(), getPosy()+200);
	    
	    Double f7 = new Line2D.Double(getPosx()+150, getPosy()+250, getPosx()+150, getPosy()+350);
	    
	    Double f8 = new Line2D.Double(getPosx()+50, getPosy()+350, getPosx()+300, getPosy()+350);
	    Double f9 = new Line2D.Double(getPosx()+300, getPosy()+350, getPosx()+250, getPosy()+450);
	    Double f10 = new Line2D.Double(getPosx()+250, getPosy()+450, getPosx(), getPosy()+450);
	    Double f11 = new Line2D.Double(getPosx(), getPosy()+450, getPosx()+50, getPosy()+350);
	    
	    Double f12 = new Line2D.Double(getPosx()+275, getPosy()+400, getPosx()+425, getPosy()+400);
	    Double f13 = new Line2D.Double(getPosx()+425, getPosy()+400, getPosx()+425, getPosy()+325);
	    
	    java.awt.geom.Rectangle2D.Double f14 = new Rectangle2D.Double(getPosx()+300,getPosy()+225,300,100);
	    
	    Double f15 = new Line2D.Double(getPosx()+450, getPosy()+225, getPosx()+450, getPosy()+200);
	    Double f16 = new Line2D.Double(getPosx()+450, getPosy()+200, getPosx()+300, getPosy()+200);
	    
	    Double f17 = new Line2D.Double(getPosx(), getPosy()+200, getPosx()-50, getPosy()+200);
	    Double f18 = new Line2D.Double(getPosx()-50, getPosy()+200, getPosx()-50, getPosy()+500);
	    Double f19 = new Line2D.Double(getPosx()-50, getPosy()+500, getPosx()+150, getPosy()+500);
	    Double f20 = new Line2D.Double(getPosx()+150, getPosy()+500, getPosx()+150, getPosy()+550);
	    
	}
	
    
}
