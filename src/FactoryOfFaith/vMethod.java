package FactoryOfFaith;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;

public class vMethod extends Placer
{
	public void Draw (Graphics2D g)
	{
		java.awt.geom.Rectangle2D.Double m1 = new Rectangle2D.Double(getPosx(),getPosy(),300,100);
	    Double m2 = new Line2D.Double(getPosx()+25, getPosy(), getPosx()+25, getPosy()+100);
	    Double m3 = new Line2D.Double(getPosx()+275, getPosy(), getPosx()+275, getPosy()+100);
	    
	    Double m4 = new Line2D.Double(getPosx()+150,getPosy()+100,getPosx()+150,getPosy()+150);
	}
    

}
