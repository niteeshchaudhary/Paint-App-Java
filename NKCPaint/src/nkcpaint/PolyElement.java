package nkcpaint;

import java.awt.*;
import java.util.*;

public abstract class PolyElement implements DrawingElement
{
	public void setColor(Color c)
	{
		mColor = c;
	}
	
	public void draw(Graphics g, boolean isActive)
	{
	}
	
	public void addPoint(Point p )
	{
		mPoints.addElement(p);
	}

	private int getDistance(int x1, int y1 ,int x2 ,int y2 )
	{
		double a = Math.pow( (double)(x2 - x1) ,2 );
		double b = Math.pow( (double)(y2 - y1) ,2) ;
		double c = Math.sqrt(a+b);
	
		return (int)Math.rint( c ) ;
	}

	public int getClosestPoint(int x ,int y)
	{
		int loX = 100000;
		int loY = 100000;
		int hiX = -100000;
		int hiY = -100000;
		int thisDist;
		int lowDist = 100000 ;
		
		for(Enumeration e = mPoints.elements() ; e.hasMoreElements() ; )
		{
			Point p = (Point)e.nextElement();

			loX = Math.min(loX,p.x);
			loY = Math.min(loY,p.y);
			hiX = Math.max(hiX , p.x);
			hiY = Math.max(hiY , p.y);

			thisDist = getDistance(p.x ,p.y , x ,y);
			lowDist = Math.min( thisDist , lowDist);
		}
		if(x < loX  || x > hiX || y < loY || y> hiY )
			return -1;
		
		return lowDist;
	}
	
	protected static Vector mPoints;
	protected Color mColor;

} 