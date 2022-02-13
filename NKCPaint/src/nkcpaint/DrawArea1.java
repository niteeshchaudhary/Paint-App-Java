package nkcpaint;

import java.lang.Math.*; // for Spray
import java.awt.*;  
import javax.swing.*;
import java.awt.image.*; // for images
import java.awt.event.*; // for events
import java.net.*;
import java.awt.geom.*; 
import java.util.*; 
import javax.swing.event.*;
import java.util.Vector;	
import java.awt.Image.*;
import java.awt.image.BufferedImage.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.util.List;
import java.io.*;
import java.awt.print.PrinterJob;
import java.awt.print.*;
import java.awt.image.BufferedImage; 
import java.awt.image.DataBuffer; 
 import  javax.swing.undo.UndoManager ;




	
public class DrawArea1 extends JPanel implements ActionListener , ChangeListener,MouseMotionListener , MouseListener,Runnable , Printable
{
	public DrawArea1(Color ctb)
	{	
		addMouseListener(this);

		addMouseMotionListener(this);

		mSize = new Dimension(NeewW.width , NeewW.height);
			
		mElements = new Vector();
		setLayout(null);
		fillPoints = new Vector();
                HEIGHT = NeewW.height;
                WIDTH = NeewW.width;
		//Vector lines = new Vector();
		
		

		// oldImage is used for storing the previous image( and is used in undo) 
		
		LineImage = new BufferedImage(1900 ,1900 ,BufferedImage.TYPE_INT_ARGB);

		storedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		// storedImage contains the storedImage

		Graphics g = ToolBoxContents.currentImage.createGraphics();
		
		
		stroke = new BasicStroke(1.0f);
	/*	
		Toolkit tk = Toolkit.getDefaultToolkit(); 
			Image img1 = tk.getImage("rubbermouse.gif");
			Cursor eraserCursor = tk.createCustomCursor(img1,new Point(0,31),
								"Eraser");
			
			Image img = tk.getImage("stroke.gif");
			Cursor strokeCursor = tk.createCustomCursor(tk.getImage("stroke.gif"), 				new Point(0,31),"Stroke");
		

		setCursor(strokeCursor);*/
	}		

	public Dimension getMinimumSize()
	{
		return mSize;
	}

	public Dimension getPreferredSize()
	{
		return mSize;
	}
	
	public Dimension getMaximumSize()
	{
		return mSize;
	}	






	
	/*public void start()
	{
      	if (runner == null)
            {
       	     runner = new Thread (this);
                 runner.start();
                 stop = false;
            }
       }*/
	
	
	/*public void paint(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		g2.drawImage(currentImage, 0, 0, this);
	}
	*/
	//for use with thread
  	public void run()
    	{
            while(!stop)
            {
            	spray(tX,tY);
                    //Thread sleeps for 15 milliseconds here
                    //try {runner.sleep(15);}
                    //catch (Exception e) { }
                    try {
            				Thread.sleep(100);
        				} 
        			catch (InterruptedException e){}
            }
    	}
      
    	
	public void stop() {
      	runner = null;
    	}
        

	


	public void printing()
	{
		PrinterJob printJob = PrinterJob.getPrinterJob();
        	printJob.setPrintable(this);
       	if (printJob.printDialog()) 
		{
            	try 
			{
                		printJob.print();  
            	} 
			catch (Exception ex) 
			{
                	ex.printStackTrace();
            	}
		}
	}
	
	public int print(Graphics g, PageFormat pf, int pi) throws PrinterException 
	{
      	if (pi >= 1) 
		{
            	return Printable.NO_SUCH_PAGE;
		}
		//drawShapes((Graphics2D) g);
      	return Printable.PAGE_EXISTS;
    	}
  

	public void page()
	{
		PrinterJob pjob = PrinterJob.getPrinterJob();
		PageFormat pf = pjob.defaultPage();
		pf.setOrientation(PageFormat.LANDSCAPE);
		pf = pjob.pageDialog(pf);
	}

	
			
	
	
	public void blank()
	{
			if(z1==1)
				izoom();
			z1 = 0;
			mPaintToolBar.zoomtrue();
			oldImage.setData(ToolBoxContents.currentImage.getData());
        		Graphics g = ToolBoxContents.currentImage.createGraphics(); // repaint image white
        		g.fillRect(0,0,WIDTH,HEIGHT);
        		repaint();
        		storedImage.setData(ToolBoxContents.currentImage.getData());
			mHaschanged = false;
	}
	
	public void repaint2()
	{
		Graphics2D g = ToolBoxContents.currentImage.createGraphics();
		//g.setStroke(stroke);
		for(Enumeration e = mElements.elements(); e.hasMoreElements(); )
		{
			DrawingElement element = (DrawingElement)e.nextElement();
			
			if(element == mCurrentElement)
				element.draw(g,true);
			else
				{
					element.draw(g,false);
					mElements.removeAllElements();
					PolygonElement.mPoints.removeAllElements();

					mCurrentElement = null;
				}
		}
		//repaint();
		//mElements.removeAllElements();
	}	

	
	public void paint(Graphics g)
	{	
		
		storedImage.setData(ToolBoxContents.currentImage.getData());
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);	
                //super.pa
		g2.drawImage(ToolBoxContents.currentImage, 0, 0, this);
		
		g2.setStroke(stroke);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER ,alpha));
	
		
		paintChildren( g );
		
		Graphics2D g3 = ToolBoxContents.currentImage.createGraphics(); 
		g3.setPaint(NKCPaint.cc1);
		g2.setColor(NKCPaint.cc1); 		
	}

	private DrawingElement findElementAt(int x , int y)
	{
		DrawingElement closest = null;
		int lowDistance = 1000000;
		int thisDist;
		
		for  ( Enumeration e = mElements.elements(); e.hasMoreElements() ; )
		{
			DrawingElement elem =  (DrawingElement)e.nextElement();
			thisDist = elem.getClosestPoint(x,y);

			if(thisDist > 0)
			{
				if(lowDistance > thisDist )
				{
					lowDistance = Math.min(lowDistance, thisDist);
					closest = elem;
				}
			}
		}
		return closest;
	}

	public void actionPerformed(ActionEvent e)
	{
		
		mCurrentElement = null;
		
		repaint();
		
			
	}



	public void stateChanged( ChangeEvent e)
	{
		if(mCurrentElement != null )
		
		{
			mCurrentElement.setColor(NKCPaint.cc1);
			repaint();	
		}	
	}

	public void mousePressed( MouseEvent e)
	{	
		isSelected = false;
		mHaschanged = true;
		tempImage = storedImage;
		storedImage = oldImage;
		oldImage3.setData(oldImage2.getData());
		oldImage2.setData(oldImage1.getData());
		oldImage1.setData(storedImage.getData());
		
		undo = false;
		
		oldImage = tempImage;
		oldImage.setData(ToolBoxContents.currentImage.getData());
		lastX = e.getX(); 
		lastY = e.getY();	

	}


	public void mouseReleased(MouseEvent e)
	{	
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		g2.setStroke(stroke);
		g2.setPaint(NKCPaint.cc1 );	
		storedImage.setData(ToolBoxContents.currentImage.getData()); 	
		repaint();
	}


	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{	
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		
		Image img1 = tk.getImage("C:\\Program Files (x86)\\NPAINT\\pic\\rubbermouse.gif");
		Cursor eraserCursor = tk.createCustomCursor(img1,new Point(15,15),"Eraser");
			
		Image img = tk.getImage("C:\\Program Files (x86)\\NPAINT\\pic\\stroke.gif");
		Cursor strokeCursor = tk.createCustomCursor(tk.getImage("stroke.gif"),new Point(0,31),"Stroke");
		Image img2 = tk.getImage("C:\\Program Files (x86)\\NPAINT\\pic\\pencil.gif");
		Cursor scribbleCursor = tk.createCustomCursor(img2,new Point(0,31),"Pencil");
		Cursor fillCursor = tk.createCustomCursor(tk.getImage("C:\\Program Files (x86)\\NPAINT\\pic\\fill2.gif"),new Point(6,28),"Fill");	
		Cursor sprayCursor = tk.createCustomCursor(tk.getImage("C:\\Program Files (x86)\\NPAINT\\pic\\spraypaint.gif"),new Point(0,8),"Spray");
		
// ***************//if (mPaintToolBar.getTool() == PaintToolBar.FILLCOLOR) setCursor(fillCursor);

	}

	public void mouseExited(MouseEvent e)
	{
		setCursor(Cursor.getDefaultCursor());
	}

	public void mouseDragged(MouseEvent e)
	{
		if(e.getX() <=1900 && e.getY() <=2000 && e.getX() >0 && e.getY() >0)
		{
			stb.setText("Coordinates" + e.getX() + "," + e.getY());
		}
		else
		{
			stb.setText(" ");
		}
 
		/*
		if(mPaintToolBar.getTool() == PaintToolBar.LINE)
		{	
			e.consume();	
			x2 = e.getX();
			y2 = e.getY();
			repaint();	
	
		}*/

		/*if (mPaintToolBar.getTool() == PaintToolBar.SPRAY) 	
	  	{
			tX = e.getX(); tY = e.getY();
  			spray(e.getX() ,e.getY() ); 
		}*/
	
	     /* if (mPaintToolBar.getTool() == PaintToolBar.ERASER) delete(e.getX(), e.getY());
		
	      if (mPaintToolBar.getTool() == PaintToolBar.BRUSH)
	 	{
	   		drawStroke(e.getX(), e.getY());
    	 	}*/		
	
	}
	
	public void mouseMoved(MouseEvent e)
	{
		if(e.getX() <=1900 && e.getY() <=2000 && e.getX() > 0 && e.getY() > 0)
		{
			stb.setText("Coordinates"+ e.getX() + "," + e.getY()); 
		}
		else
		{
			stb.setText(" ");
		}
	}

	
	public void filter(BufferedImageOp op)
	{
      	BufferedImage filteredImage = new BufferedImage(ToolBoxContents.currentImage.getWidth(), ToolBoxContents.currentImage.getHeight(), ToolBoxContents.currentImage.getType());
      	op.filter(ToolBoxContents.currentImage, filteredImage);
      	//currentImage = filteredImage;
      	Graphics g = ToolBoxContents.currentImage.createGraphics();
		g.fillRect(0,0,1900,2000);
		g.drawImage(filteredImage , 0 , 0 , null);	
		//repaint();
   	}



	public void spray(int x, int y)
	// Uses Math.random method to get a random set of pixels for spraying
	{
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		
		g2.setPaint(NKCPaint.cc1 );
		
		for (i=0; i<50; i++)
		{
			// For Inner Spray
			
			tempx = (x + (int) Math.round(2*SMALL_OFFSET*(Math.random() -0.5))); 
			tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt( (SMALL_OFFSET * SMALL_OFFSET) - ((x - tempx) * (x - tempx)))));
			g2.drawLine(tempx, tempy, tempx, tempy); // draws dots of the selected color
		}
		
	/*	for (i=0; i<12; i++){
		//	For Outer Spray		
			
			tempx = (x + (int) Math.round(2*BIG_OFFSET*(Math.random() -0.5)));
			tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt( (BIG_OFFSET * BIG_OFFSET) - ((x - tempx) * (x - tempx)))));
			g2.drawLine(tempx, tempy, tempx, tempy);
		}
		*/
		repaint();
	}

	public void scribble(int x, int y)
	{
		//oldImage = currentImage;
    		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
        	g2.setPaint(NKCPaint.cc1);
        	g2.setStroke(stroke);	
            g2.drawLine(lastX, lastY, x, y);
            lastX = x; lastY = y;
            repaint();
	}

	public void undo()
	{
		undo = true;
		tempImage = oldImage;
		oldImage.setData(oldImage1.getData());
		oldImage1.setData(oldImage2.getData());
		//oldImage2.setData(oldImage3.getData()); 
		oldImage2 = oldImage3; 
		ToolBoxContents.currentImage = tempImage;
		repaint();
		storedImage.setData(ToolBoxContents.currentImage.getData());
   		//MyFrame1.undoItem.setEnabled(false); 
	}

	public void drawStroke(int x, int y) 
	{
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		g2.setPaint(NKCPaint.cc1 );
		g2.setStroke(new BasicStroke((float) 5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.drawLine(lastX, lastY, x, y);
		lastX = x; lastY = y;
		repaint();
	}
	 
	public void floodFill(int p1, int p2) //throws Exception 
	{
      	//this works iteratively by filling horizontal lines
		//System.out.println("quqeuq");
	  	
		//bgColor = Color.white.getRGB();
		bgColor = ToolBoxContents.currentImage.getRGB(p1,p2);  // get background Color 
	  	if (bgColor != (NKCPaint.cc1).getRGB()) 
	  	{	//System.out.println("qqwqqqq");
	 
	    		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	    			    
	    		while (!fillPoints.isEmpty())
			{  
				// this is continued until the vector is empty
		  	
				Point fill = (Point) fillPoints.elementAt(0);  // pop the point
		    		fillPoints.remove(0);
		    	
		    		//get points to fill
		    		fillX = (int) fill.getX();  // coords
		    		fillY = (int) fill.getY();
		    	
		    		//check above and below part 
		    		if(fillY>1)
				{
		    			if(ToolBoxContents.currentImage.getRGB(fillX,fillY-1) != bgColor) checkUp = true;  // the pixel directly up isnt capable of direct filling
		   			else {
		    				checkUp = false;
		    				addPoint = new Point(fillX,(fillY-1));  
						
						// check to see if the point is already in
		    				if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(fillX,(fillY-1)));
		    				}
		    		}
		    	
		    		if(fillY<HEIGHT-1)
				// It is present inside the range 
				{
		    			if(ToolBoxContents.currentImage.getRGB(fillX,fillY+1) != bgColor) checkDown = true;  // pixel 1 below  is not fillable
		    			else 
					{
		    				checkDown = false;
		    				addPoint = new Point(fillX,(fillY+1));  
						// check to see if the point is already in
		    				
						if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(fillX,fillY+1));
		    			
		    			}
		 		}
		    	
		    		ToolBoxContents.currentImage.setRGB(fillX,fillY,(NKCPaint.cc1).getRGB());  // paint this spot
		    		if (fillX>0) fillLeft(checkUp,checkDown, fillX-1, fillY); // fill left if we can
		    		if (fillX<WIDTH-1) fillRight(checkUp,checkDown, fillX+1, fillY); // fill right if we can
		    	
			}
		    
		    	fillPoints.clear();
		    	repaint();		// done - repaint
		    	setCursor(fillPointer);
		}
	
	}
	public void fillLeft(boolean x, boolean y, int drawX, int drawY)
	{
		if(ToolBoxContents.currentImage.getRGB(drawX,drawY) == bgColor)
		{
	  		ToolBoxContents.currentImage.setRGB(drawX,drawY,(NKCPaint.cc1).getRGB());  
			
			// can we paint here ? if yes...
	  	
			if ((drawY>0) && (drawY<(HEIGHT-1))) 
			{
	  			if(ToolBoxContents.currentImage.getRGB(drawX,drawY-1) != bgColor) {x = true;}  
	  			else if (x) 
				{
					addPoint = new Point(drawX,drawY-1);
	  				if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(drawX,drawY-1));
	  				x = false;
	  			}
	  			
				if(ToolBoxContents.currentImage.getRGB(drawX,drawY+1) != bgColor) {y = true;}
	  			else if (y) 
				{
	  				addPoint = new Point(drawX,drawY+1);
	  				if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(drawX,drawY+1));
	  				y = false;
	  			}
	  		}
	  		
	  		if (drawX>0) fillLeft(x,y,drawX-1,drawY);  // keep going left
	  	}
	}	 
	
	public void fillRight(boolean x, boolean y, int drawX, int drawY)
	{
            if(drawY<ToolBoxContents.currentImage.getWidth())
            {
		if(ToolBoxContents.currentImage.getRGB(drawX,drawY) == bgColor && drawX<ToolBoxContents.currentImage.getWidth()-1)
		{  
	  		
			ToolBoxContents.currentImage.setRGB(drawX,drawY,(NKCPaint.cc1).getRGB());
	  		
	  		if ((drawY>0) && (drawY<(HEIGHT-1))) 
			{
	  			if(ToolBoxContents.currentImage.getRGB(drawX,drawY-1) != bgColor) {x = true;}  // check one up
	  			else if (x) 
				{
	  				addPoint = new Point(drawX,drawY-1);
	  				if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(drawX,drawY-1));
	  				x = false;
	  			}
	  		
	  			if(ToolBoxContents.currentImage.getRGB(drawX,drawY+1) != bgColor) {y = true;}  // check one down
	  			else if (y) 
				{
	  				addPoint = new Point(drawX,drawY+1);
	  				if(!fillPoints.contains(addPoint)) fillPoints.add(new Point(drawX,drawY+1));
	  				y = false;
	  			}
	  		}
	  		
	  		if (drawX<WIDTH-1) fillRight(x,y,drawX+1,drawY);  // go right
	  	}
            }
	}
	
	public void delete(int x, int y) {
		Graphics2D g = ToolBoxContents.currentImage.createGraphics();
		g.setPaint(Color.white); //delete is white
		g.setStroke(new BasicStroke((float)30,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND)); //stroke settings
		Shape line = new Line2D.Double((double)lastX,(double)lastY,(double)x,(double)y);
		g.draw(line);
		repaint();
		//System.out.println("qweeqw");
		lastX = x;
		lastY = y;
	}

	public void setting(BasicStroke stroke1)
	{	
		stroke = stroke1;
	}

	public void clear()
	{
    		int selection = JOptionPane.showConfirmDialog(null,"Do you really want to start again?",   "Start Over?", 
            JOptionPane.YES_NO_OPTION);
        	if (selection == JOptionPane.YES_OPTION) {
        		//clearImage();
        		for(int i=0;i<z1;i++)
        		{
        			izoom();
        		}
        		z1=0;	
			mPaintToolBar.zoomtrue();
        		oldImage.setData(ToolBoxContents.currentImage.getData());
        		Graphics g = ToolBoxContents.currentImage.createGraphics(); // repaint image white
        		g.fillRect(0,0,WIDTH,HEIGHT);
        		repaint();
        		storedImage.setData(ToolBoxContents.currentImage.getData());
			
    		}
    	}
    	
    	public int getzoom()
    	{
    		return z1;
    	}
    	
    	public void subzoom()
    	{
    		z1=0;
    	}

		public void zoom()
		{
		try
		{	
		frameInsets = getInsets();
	
		Graphics2D g = (Graphics2D)ToolBoxContents.currentImage.getGraphics();		
		AffineTransform at = new AffineTransform();
		at.scale(1.5,1.5);
		
		AffineTransform translationTransform;
		translationTransform = findTranslation(at, ToolBoxContents.currentImage);
		at.preConcatenate(translationTransform);
		
		BufferedImageOp bio;
		bio = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		ToolBoxContents.currentImage = bio.filter(ToolBoxContents.currentImage, null);
		//currentImage = newImage;
		//repaint(); 

		int frameInsetsHorizontal = frameInsets.right + frameInsets.left; 
		int frameInsetsVertical = frameInsets.top + frameInsets.bottom;
		setSize(ToolBoxContents.currentImage.getWidth() + frameInsetsHorizontal,ToolBoxContents.currentImage.getHeight() + frameInsetsVertical);
		//show();
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this,e1.toString());
		} 
	}	


	private AffineTransform findTranslation(AffineTransform at,BufferedImage bi) 
	{
		Point2D p2din, p2dout;

		p2din = new Point2D.Double(0.0,0.0);
		p2dout = at.transform(p2din, null);
		double ytrans = p2dout.getY();

		p2din = new Point2D.Double(0, bi.getHeight());
		p2dout = at.transform(p2din, null);
		double xtrans = p2dout.getX();
	    
		AffineTransform tat = new AffineTransform();
		tat.translate(-xtrans, -ytrans);
		return tat;
  	}

	public void izoom()
	{
		try
		{	
		frameInsets = getInsets();
	
		Graphics2D g = (Graphics2D)ToolBoxContents.currentImage.getGraphics();		
		AffineTransform at = new AffineTransform();
		at.scale(1/1.5,1/1.5);
		
		AffineTransform translationTransform;
		translationTransform = findTranslation(at, ToolBoxContents.currentImage);
		at.preConcatenate(translationTransform);
		
		BufferedImageOp bio;
		bio = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		ToolBoxContents.currentImage = bio.filter(ToolBoxContents.currentImage, null);
		//currentImage = newImage;
		//repaint(); 

		int frameInsetsHorizontal = frameInsets.right + frameInsets.left; 
		int frameInsetsVertical = frameInsets.top + frameInsets.bottom;
		setSize(ToolBoxContents.currentImage.getWidth() + frameInsetsHorizontal,ToolBoxContents.currentImage.getHeight() + frameInsetsVertical);
		//show();
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(this,e1.toString());
		} 
	}	

	
	public void line(int x,int y)
	{
		if(c == 0)
		{
			xx = x;
			yy = y;
			c=1;
		}
		
		Graphics2D g1 = ToolBoxContents.currentImage.createGraphics();
		g1.setPaint(NKCPaint.cc1);
		g1.drawLine(xx,yy,x,y);
		xx = x;
		yy = y;
		repaint();
	}

	public void cutIcon()
	{
		if(isClip)
		{	
			Toolkit tk = Toolkit.getDefaultToolkit(); 
			Cursor newCursor = tk.createCustomCursor(clipboard,new Point(15,15),"Control");
			setCursor(newCursor);
		}
	}  
		
	public int save(File f ,int n)
	{	
		return n;	
	}

	public void drawImage(int x, int y, Image stampImage)
	{
		//clear();
		blank();
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		Image image = new ImageIcon(stampImage).getImage();
		g2.drawImage(image, (x-(image.getWidth(this)/2)), (y-(image.getHeight(this)/2)), this);
		repaint();
	}

	public void cut()
	{
		if(isSelected)
		{
			isClip = true;
			
			clip = ToolBoxContents.currentImage.getSubimage(sx,sy,sw, sh);
			clipboard = new BufferedImage(sw, sh , BufferedImage.TYPE_INT_ARGB);
			clipboard.setData(clip.getData());
			Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
			
			g2.setColor(Color.white);	
			g2.fillRect(sx,sy,sw,sh);
		}
	}
	
	public void copy()
	{
		if(isSelected)
		{
			isClip = true; 
	
			//System.out.println( sw + "\n" + sh + "\n" + sx + " " + sy );
			clipboard  = ToolBoxContents.currentImage.getSubimage(sx,sy,sw,sh);
		}
	}
	
	public void paste(int x , int y)
	{
		if(isClip)
		{	
			addImage(x , y , clipboard);	
		}
		//addImage(x , y , clipboard);
	}
	
	public void loadImages(int x , int y )
  	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("Images") );
		chooser.setAccessory(new MyAccessory(chooser)); 
		//chooser.setFileSystemView(chooser.getFileSystemView());
		chooser.setDialogTitle(" Add Images ");
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter( )
		{
			public boolean accept(File f)
            	{  
            		String name = f.getName().toLowerCase();
               		return name.endsWith(".gif")
             		|| name.endsWith(".jpg")
                  	|| name.endsWith(".jpeg")
                  	|| f.isDirectory();
            	}
           		public String getDescription()
            	{  
            		return "Image files";
           		}
     		});

     		int r = chooser.showOpenDialog(this);
     		if(r != JFileChooser.APPROVE_OPTION) return;

     		try
     		{
         		image1 = ImageIO.read(chooser.getSelectedFile());
     		}
     		catch (IOException exception)
     		{
     			JOptionPane.showMessageDialog(this, exception);
     		}

     		addImage( x,y,image1); 
		repaint();
   	}	


	
	public void addImage(int x , int y , Image stampImage)
	{
		Graphics2D g2 = ToolBoxContents.currentImage.createGraphics();
		Image image1 = new ImageIcon(stampImage).getImage();
		g2.drawImage(image1 , (x - (image1.getWidth(this)/2)) , ( y - (image1.getHeight(this)/2 )) ,this ); 
	
		//repaint();
	}

	private Dimension mSize;
	private PaintToolBar mPaintToolBar;
	private ColorBar mColorBar;
	private Vector mElements;
	private DrawingElement mCurrentElement;
	private JTextField mField;

	private JLabel stb;


	public static BufferedImage Image1; 
	public BufferedImage oldImage,oldImage1, oldImage2,oldImage3, tempImage, storedImage, newImage,LineImage , blankImage;
	public BufferedImage clipboard , clip;
	private static int HEIGHT = NeewW.height, WIDTH = NeewW.width;
	private static Image mImage;
	private BufferedImage image1;
	private Cursor scribblePointer, sprayPointer, rubberPointer, strokePointer, fillPointer;
	public boolean oldIsOld = true;
	public boolean undo = true;
	private DrawingElement elem;

	private Point addPoint;
	public Vector fillPoints; 
	private BasicStroke stroke;  
	private Vector lines = new Vector();
	private Vector ellipses = new Vector();
	private Vector rect = new Vector();
	private Vector rrect = new Vector();
	private int c;
	public float alpha  = 1.0f;
	private int z1 = 0;
	private int fillX;
  	private int fillY;
	private int a = 0 , b = 0;
	public int Hassave = 0;
	private File f1;
	private int ex1 , ey1 , ex2 , ey2 ,rx1 , rx2 , ry1 ,ry2 ,rrx , rry ,rr1 ,rr2 ;
	private int x1, y1 ,x2 ,y2;
	private int t1 , t2;
	private int sx1,sx2,sy1,sy2 ,sx,sy,sw,sh;
	public boolean mHaschanged = false;
	public boolean isSelected = false;
	private boolean isClip = false;
	private int lastX,lastY;
	private int tX ,tY;
	private int xi ,yi;
	private int xx ,yy;
	private int tempx ,tempy;
	private static final int SMALL_OFFSET = 7, BIG_OFFSET = 15;
	private int i ,j;
	private boolean checkUp = false;
	private boolean checkDown = false;
	private int bgColor;
	private Thread runner;
	private boolean stop = true;
	private URL URL_STRING;
	public Image img;
	private Cursor strokeCursor,eraserCursor,scribbleCursor,fillCursor;
	private Image img1,img2;
	private Insets frameInsets;
}