package nkcpaint;

import java.awt.*;

public interface DrawingElement
{
	public void draw(Graphics g,boolean isActive);
	
	public void addPoint(Point p);
	
	public void setColor(Color c);

	public int getClosestPoint(int x ,int y);

}