package FactoryOfFaith;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;


public class vDeclare extends Placer
{
	public void Draw (Graphics2D g)
	{
	    java.awt.geom.Rectangle2D.Double d1 = new Rectangle2D.Double(getPosx(),getPosy(),300,100);
	    Double d2 = new Line2D.Double(getPosx()+150,getPosy()+100,getPosx()+150,getPosy()+150);
	    
	}

}
