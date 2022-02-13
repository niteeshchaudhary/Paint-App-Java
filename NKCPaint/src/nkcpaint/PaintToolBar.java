package nkcpaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class PaintToolBar extends JToolBar implements ActionListener
{
	public PaintToolBar()
	{
		group = new ButtonGroup();
		
		mActionListenerList = new EventListenerList();			
		JToggleButton select = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\select.jpg"));
		select.setMargin(new Insets(2,2,2,2));
		select.setActionCommand("select");
		select.addActionListener(this);
		select.setToolTipText("Select");
		select.setName("Select");
		add(select);
		
		JToggleButton text = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\text.gif"));
		text.setMargin(new Insets(2,2,2,2));
		text.setActionCommand("text");
		text.addActionListener(this);
		text.setToolTipText("Text");
		add(text);
		
		JToggleButton eraser = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\eraser.gif"));
		eraser.setMargin(new Insets(2,2,2,2));
		eraser.setActionCommand("eraser");
		eraser.addActionListener(this);
		eraser.setToolTipText("Eraser");
		add(eraser);

		JToggleButton fillcolor = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\fill.gif"));
		fillcolor.setMargin(new Insets(2,2,2,2));
		fillcolor.setActionCommand("fillcolor");
		fillcolor.addActionListener(this);
		fillcolor.setToolTipText("Fill an area with Color");
		add(fillcolor);

		JToggleButton pickcolor = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\pick.gif"));
		pickcolor.setMargin(new Insets(2,2,2,2));
		pickcolor.setActionCommand("pickcolor");
		pickcolor.addActionListener(this);
		pickcolor.setToolTipText("Pick aColor");
		//add(pickcolor);

		zoom = new JToggleButton( new ImageIcon("zoom.jpg"));
		zoom.setMargin(new Insets(2,2,2,2));
		zoom.setActionCommand("zoom");
		zoom.addActionListener(this);
		zoom.setToolTipText("Zoom");
		add(zoom);

		JToggleButton pencil = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\pencil.gif"));
		pencil.setMargin(new Insets(2,2,2,2));
		pencil.setActionCommand("pencil");
		pencil.addActionListener(this);
		pencil.setToolTipText("Free Hand Sketch");
		add(pencil);

		JToggleButton brush = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\brush.gif"));
		brush.setMargin(new Insets(2,2,2,2));
		brush.setActionCommand("brush");
		brush.addActionListener(this);
		brush.setToolTipText("Brush");
		add(brush);

		JToggleButton spray = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\spray.gif"));
		spray.setMargin(new Insets(2,2,2,2));
		spray.setActionCommand("spray");
		spray.addActionListener(this);
		spray.setToolTipText("Spray");
		add(spray);

		JToggleButton line = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\line.gif"));
		line.setMargin(new Insets(2,2,2,2));
		line.setActionCommand("line");
		line.addActionListener(this);
		line.setToolTipText(" Line ");
		add(line);

		JToggleButton curve = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\Curve.gif"));
		curve.setMargin(new Insets(2,2,2,2));
		curve.setActionCommand("curve");
		curve.addActionListener(this);
		curve.setToolTipText(" Curve ");
		//add(curve);
		
		JToggleButton rectangle = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\rectangle.gif"));
		rectangle.setMargin(new Insets(2,2,2,2));
		rectangle.setActionCommand("rectangle");
		rectangle.addActionListener(this);
		rectangle.setToolTipText(" Rectangle");
		add(rectangle);

		JToggleButton polygon = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\polygon.jpg"));
		polygon.setMargin(new Insets(2,2,2,2));
		polygon.setActionCommand("polygon");
		polygon.addActionListener(this);
		polygon.setToolTipText(" Polygon");
		add(polygon);

		JToggleButton ellipse = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\ellipse.gif"));
		ellipse.setMargin(new Insets(2,2,2,2));
		ellipse.setActionCommand("ellipse");
		ellipse.addActionListener(this);
		ellipse.setToolTipText(" Ellipse ");
		add(ellipse);

		JToggleButton roundrect = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\roundrect.jpg"));
		roundrect.setMargin(new Insets(2,2,2,2));
		roundrect.setActionCommand("roundrect");
		roundrect.addActionListener(this);
		roundrect.setToolTipText(" Rounded Rectangle ");
		add(roundrect);

		
		JToggleButton polyline = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\polyline.jpg"));
		polyline.setMargin(new Insets(2,2,2,2));
		polyline.setActionCommand("polyline");
		polyline.addActionListener(this);
		polyline.setToolTipText(" PolyLine ");
		add(polyline);

		JToggleButton addImage = new JToggleButton( new ImageIcon("C:\\Program Files (x86)\\NPAINT\\pic\\image.jpg"));
		addImage.setMargin(new Insets(2,2,2,2));
		addImage.setActionCommand("add Image");
		addImage.addActionListener(this);
		addImage.setToolTipText("Click here to add images in your draw");
		add(addImage); 
		
		group.add(select);
		group.add(eraser);
		group.add(fillcolor);
		group.add(pickcolor);
		group.add(zoom);
		group.add(pencil);
		group.add(brush);
		group.add(spray);
		group.add(line);
		group.add(curve);
		group.add(rectangle);
		group.add(polygon);
		group.add(ellipse);
		group.add(roundrect);
		group.add(polyline);
		group.add(text);
		group.add(addImage);

		pencil.setSelected(true);
	}

	public void zoomfalse()
	{
		zoom.setEnabled(false);
	}
	
	public void zoomtrue()
	{
		zoom.setEnabled(true);
	}
	
	public int getTool( )
	{
		String selected = group.getSelection().getActionCommand();
		
		 if(selected.equals("select" ))
		{
			return SELECT;
		}
		else if(selected.equals("eraser"))
		{
			return ERASER;
		}
		else if(selected.equals("fillcolor"))
		{
			return FILLCOLOR;
		}
		else if(selected.equals("pickcolor"))
		{
		return PICKCOLOR;
		}
		else if(selected.equals("zoom"))
		{
			return ZOOM;
		}
		else if(selected.equals("pencil"))
		{
			return PENCIL;
		}
		else if(selected.equals("brush"))
		{
			return BRUSH;
		}
		else if(selected.equals("spray"))
		{
			return SPRAY;
		}
		else if(selected.equals("line"))
		{
			return LINE;
		}
		else if(selected.equals("curve"))
		{
			return CURVE;
		}
		else if(selected.equals("rectangle"))
		{
			return RECTANGLE;
		}
		else if(selected.equals("polygon"))
		{
			return POLYGON;
		}
		else if(selected.equals("ellipse"))
		{
			return ELLIPSE;
		}
		else if(selected.equals("polyline"))
		{
			return POLYLINE;
		}
		else if(selected.equals("text"))
		{
			return TEXT;
		}
		else if(selected.equals("add Image"))
		{
			//JOptionPane.showMessageDialog(this,"Please Press on the position where you want to add the image");
			return IMAGE;
		}
		else 
		{
			return ROUNDRECT;
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		ActionEvent newEvent = new ActionEvent(this,e.getID(),e.getActionCommand( ));
		fireActionEvent(newEvent);
	}

	public void addActionListener( ActionListener listener)
	{
            mActionListenerList.add(ActionListener.class,listener);
	}
	
	public void removeActionListener(ActionListener listener)
	{
            mActionListenerList.remove(ActionListener.class,listener);
	}

	protected void fireActionEvent(ActionEvent newEvent)
	{
            Object[] listeners = mActionListenerList.getListenerList();

            for(int i = listeners.length-2 ;i>=0;i-=2)
		{
			if(listeners[i]==ActionListener.class)
			{
				((ActionListener)listeners[i+1]).actionPerformed(newEvent);
			}
		}
	}
 
	private EventListenerList mActionListenerList;
		
	private ButtonGroup group;
	private JToggleButton zoom;

	public static final int SELECT = 0;
	public static final int ERASER = 1; 
	public static final int FILLCOLOR = 2;
	public static final int PICKCOLOR = 3;
	public static final int ZOOM = 4;
	public static final int PENCIL = 5;
	public static final int BRUSH = 6;
	public static final int SPRAY = 7;
	public static final int LINE = 8;
	public static final int CURVE = 9;
	public static final int RECTANGLE = 10;
	public static final int POLYGON = 11;
	public static final int ELLIPSE = 12;
	public static final int ROUNDRECT = 13;
	public static final int POLYLINE = 14;
	public static final int TEXT = 15; 
	public static final int IMAGE = 16;	

}	
		




		