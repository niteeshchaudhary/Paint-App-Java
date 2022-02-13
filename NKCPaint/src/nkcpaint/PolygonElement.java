package nkcpaint;

import java.awt.*;
import java.util.*;

 class PolygonElement extends PolyElement
{
	public PolygonElement()
	{
		// mPoints come from super class
		mPoints = new Vector() ;
	}

	public void draw(Graphics g , boolean isActive)
	{
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		g2.setColor(mColor);
		//g.setColor(mColor);

		int size = mPoints.size();
		int x[] = new int[size];
		int y[] = new int[size];
		int count = 0;
		// For each element

		for(Enumeration e = mPoints.elements(); e.hasMoreElements() ; )
		{
			Point pt = (Point)e.nextElement() ;	
			// Store the point's x and y coordinates

			x[count] = pt.x;
			y[count] = pt.y;
			count++;
		}
		
		g2.fillPolygon(x,y,size);
		//g.fillPolygon(x,y,size);
		
		if(isActive) 
		{
			for(int i = 0 ;i < size ;i ++ )
			{
				//g.drawRect( x[i]  - 2 , y[i] -2 , 4 ,4 );
				//g.drawRect( x[i]  - 2 , y[i] -2 , 4 ,4 );
			}
		}
		else
		{
			System.out.println("1");
			//mPoints.removeAllElements();
		}
		//mPoints.removeAllElements();

	}
}