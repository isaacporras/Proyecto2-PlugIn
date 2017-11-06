package FactoryOfFaith;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;



public class vIf extends Placer
{

	
	public void draw(Graphics2D g)
	{
		Double if1 = new Line2D.Double(getPosx(), getPosy()+50, getPosx()+150, getPosy());
		Double if2 = new Line2D.Double(getPosx()+150, getPosy(), getPosx()+300, getPosy()+50);
		Double if3 = new Line2D.Double(getPosx()+300, getPosy()+50, getPosx()+150, getPosy()+100);
		Double if4 = new Line2D.Double(getPosx()+150, getPosy()+100, getPosx(), getPosy()+50);
		    
		Double if5 = new Line2D.Double(getPosx()+150, getPosy()+100, getPosx()+150, getPosy()+150);
	}
}
