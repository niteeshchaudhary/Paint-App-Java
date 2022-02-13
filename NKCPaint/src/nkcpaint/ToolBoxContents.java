/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkcpaint;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Dell
 */
public class ToolBoxContents extends JPanel
{
    File f1;
    static int opp1;
    int mX,mY,m2X,m2Y,lx,ly,l2x,l2y;
    public static BufferedImage oopi,blk,oldImag,oldImag1, oldImag2,oldImag3, oldImag4,oldImag5, tempImage, storedImage, newImage,LineImage , blankImage,Image1,currentImage;
    BufferedImage un5,un2,un3,un4;
    BufferedImage rn1,rn2,rn3,rn4;
    Graphics permI,un1i,un2i,un3i,un4i;
    int un=0,iam,im2;
    private int fillX;
    private int fillY;
    private Point addPoint;
    private boolean checkUp;
    private boolean checkDown;
    private Cursor fillPointer;
    Vector fillPoints =new Vector(); 
    Vector flp =new Vector(); 
    ToolBoxContents ()
    {
        setBounds(0,0,300,300);
            blankImage = new BufferedImage(1000 ,1000 ,BufferedImage.TYPE_INT_ARGB);
blk=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		// The program does most of the painting in the BufferedImage currentImage 

		currentImage = new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
                Image1 = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);

		oldImag = new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		oldImag1 = new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		oldImag2 = new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		oldImag3 =new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
                oldImag4 = new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		oldImag5 =new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		// oldImage is used for storing the previous image( and is used in undo) 
		un5= new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
                 un2=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
                  un3=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
                   un4=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
		LineImage = new BufferedImage(800 ,800 ,BufferedImage.TYPE_INT_ARGB);

		//storedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

              //  permI= currentImage.createGraphics();
                
 addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) 
            {
                 lx = e.getX();
           	 ly = e.getY();
                // store2();
                if(NKCPaint.drawpn==true)
                {
            	drawPn();
                }
                if(NKCPaint.era==true)
                {
            	eraseCl();
                }
                 if(NKCPaint.bru==true)
                {
            	 brush();
                }
                  if(NKCPaint.spr==true)
                {
            	 spray();
                }
              
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
     
                if(NKCPaint.colorpick==true)
                {
                  NKCPaint.clpl.setBackground(colorpick(e.getX(), e.getY()));
                   NKCPaint.tabs.setSelectedComponent(NKCPaint.colorpicker);
                }
                else if(NKCPaint.drawrec==true)
                {
                   NKCPaint.tabs.setSelectedComponent(NKCPaint.rect);
                }  
            }
            
        }
        );
        addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent evt) {  
             alp=0;  
             redd=NKCPaint.cc1.getRed();
             gree=NKCPaint.cc1.getGreen();
             blu=NKCPaint.cc1.getBlue();
             if(NKCPaint.flc==true)
                {
                    DrawArea1 dr=new DrawArea1(NKCPaint.cc1);
            	//store2();
                //fillPoints.add(new Point(evt.getX(),evt.getY()));
                   try	{
				{
                                    
					dr.fillPoints.add(new Point(evt.getX(), evt.getY()));
				try	
				{
					dr.floodFill(evt.getX(), evt.getY());
                                        
				}
			
				catch(Exception exp)
				{       
                                        System.out.println(exp);
				}                                
                           }
                         repaint();
				
                                      //  Fillb(evt.getX(), evt.getY());
				}
			
				catch(Exception exp)
				{
					dr.floodFill(evt.getX(), evt.getY());
				}
		}
                 if(NKCPaint.colorpick==true)
                {
                  NKCPaint.clpl.setBackground(colorpick(evt.getX(), evt.getY()));
                  NKCPaint.c1.setBackground(colorpick(evt.getX(), evt.getY()));
                  NKCPaint.cc1=colorpick(evt.getX(), evt.getY());
                  
                }  
             if(NKCPaint.drawpn==true)
                {
            	store2();
                }
                if(NKCPaint.era==true)
                {
            	store2();
                }
                 if(NKCPaint.bru==true)
                {
            	 store2();
                }
                  if(NKCPaint.spr==true)
                {
            	 store2();
                }            
// store2();
       /* tempImage = storedImage;
		storedImage = oldImage;
		oldImage3.setData(oldImage2.getData());
		oldImage2.setData(oldImage1.getData());
		oldImage1.setData(storedImage.getData());
                oldImage = tempImage;
		oldImage.setData(currentImage.getData());
                
 */            mX = evt.getX();
           		mY = evt.getY();
                        l2x = evt.getX();
           	 l2y = evt.getY();
                 
                 
                
                }                                            

          public void mouseReleased(MouseEvent evt) {                                              
        	m2X = evt.getX();
            	m2Y = evt.getY();
               //store2();
               // storeR();
              if(NKCPaint.drawt==true)
                {
                    //store2();
            	drawT();
                }
              if(NKCPaint.drawcir==true)
                {
                    //store2();
            	drawCircle();
                }
              if(NKCPaint.drawrec==true)
                {
                    //store2();
            	drawRect();
                }
              if(NKCPaint.drawln==true)
                {
                 //   store2();
            	drawLn();
                }
              if(NKCPaint.era==true)
                {
                   // store2();
                    lx = evt.getX();
           	 ly = evt.getY();
            	eraseCl();
                }
              if(NKCPaint.bru==true)
                {
                    //store2();
                    lx = evt.getX();
           	 ly = evt.getY();
            	
            	brush();
                }
              if(NKCPaint.drawpn==true)
                {
                    
                //store2();
                }
              if(NKCPaint.spr==true)
                {
                  //  store2();
                    lx = evt.getX();
           	 ly = evt.getY();
            	
            	spray();
                }
        }
        });
    }
    public void drawT()
            {
              
            	int x[],y[];
            	x=new int[3];
            	y=new int[3];
            	Graphics2D g= (Graphics2D)permI ;
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
            	store2();
            	if(m2X>mX)
            	{
            		x[0]=(m2X+mX)/2;
            		x[1]=mX;
            		x[2]=m2X;
            	}
            	if(m2X<mX)
            	{
            		x[0]=(mX+m2X)/2;
            		x[1]=m2X;
            	        x[2]=mX;
            	}
            	if(m2Y>mY)
            	{
            		y[0]=mY;
            		y[1]=m2Y;
            		y[2]=m2Y;
            	}
            	if(m2Y<mY)
            	{
            		y[0]=m2Y;
            		y[1]=mY;
            		y[2]=mY;
            	}
                if(NKCPaint.sfill==true)
                {
                     
            	g.setColor(NKCPaint.cc1);
                g.fillPolygon(x,y,3);
                }
                 if(NKCPaint.sln==true)
                {
            	g.setColor(NKCPaint.cc2);
            	g.drawPolygon(x,y,3);
                }
                 
                repaint();
               /* g.setColor(NKCPaint.cc1);
                g.fillPolygon(x,y,3);
            	g.setColor(NKCPaint.cc2);
            	g.drawPolygon(x,y,3);*/
            	}
    	public void drawCircle()
	{
            store2();
            if(m2X<mX)
            	{
                    m2X+=mX;
                    mX=m2X-mX;
                    m2X=m2X-mX;
                }
            if(m2Y<mY)
            	{
                    m2Y+=mY;
                    mY=m2Y-mY;
                    m2Y=m2Y-mY;
                }
			{
				Graphics2D g= (Graphics2D)permI ;
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		if(NKCPaint.sfill==true)
                {		
                g.setColor(NKCPaint.cc1);
				g.fillOval(mX,mY,m2X-mX,m2Y-mY);
                }
                 if(NKCPaint.sln==true)
                {
			        g.setColor(NKCPaint.cc2);
				g.drawOval(mX,mY,m2X-mX,m2Y-mY);
                }
                 
                                  repaint();
			}				
			
        }
        public void drawRect()
        {
            if(m2X<mX)
            	{
                    m2X+=mX;
                    mX=m2X-mX;
                    m2X=m2X-mX;
                }
            if(m2Y<mY)
            	{
                    m2Y+=mY;
                    mY=m2Y-mY;
                    m2Y=m2Y-mY;
                }
			{
			store2();	
                            Graphics2D g= (Graphics2D)permI ;
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
                if(NKCPaint.sfill==true)
                {
				g.setColor(NKCPaint.cc1);
				g.fillRoundRect(mX,mY,m2X-mX,m2Y-mY,(int)NKCPaint.thk, (int)NKCPaint.thk);
                }
                 if(NKCPaint.sln==true)
                {
			        g.setColor(NKCPaint.cc2);
				g.drawRoundRect(mX,mY,m2X-mX,m2Y-mY,(int)NKCPaint.thk, (int)NKCPaint.thk);
                                     }
                 
                                  repaint();
			}
        }
        public void drawLn()
        {
            
			{
				
		Graphics2D g= (Graphics2D)permI ;
                store2();
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			        g.setColor(NKCPaint.cc2);
				g.drawLine(mX,mY,m2X,m2Y);
                        
                                repaint();
			}
        }
        public void drawPn()
	{
            
		Graphics gr=getGraphics();
		Graphics2D g= (Graphics2D)permI ;
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.JOIN_BEVEL,BasicStroke.JOIN_ROUND));
        	g.setColor(NKCPaint.cc2);
                g.drawLine(lx, ly, l2x, l2y);
                l2x = lx; l2y = ly;
                 
                repaint();
                //repaint();
	}
          public void eraseCl()
	{
            Graphics gr=getGraphics();
           
		Graphics2D g= (Graphics2D)permI ;
        	g.setColor(Color.WHITE);//.cc2);
                g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
                Shape line = new Line2D.Double((double)lx,(double)ly,(double)l2x,(double)l2y);
                l2x = lx; l2y = ly;
		g.draw(line);
                
                  repaint();
                /*
                //g.fillRect(mX,mY,m2X-mX,m2Y-mY);
                g.fillRect(lx, ly, NKCPaint.sew, NKCPaint.seh);
               // g.fillRect(lx+(NKCPaint.sew-9), ly+(NKCPaint.seh-9), NKCPaint.sew, NKCPaint.seh);
                g.fillRect(l2x, l2y, NKCPaint.sew, NKCPaint.seh);
                l2x = lx; l2y = ly;*/
                //repaint();
	}
          int alp=0;
          int redd=0,gree=0,blu=0;
        public void brush()
	{
                Graphics gr=getGraphics();
		Graphics2D g= (Graphics2D)permI ;
        	g.setColor(NKCPaint.cc1);
                
                if(NKCPaint.sim==true){
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
                }
                if(NKCPaint.bround==true){
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
                }
                if(NKCPaint.bmiter==true){
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
                    g.setColor(new Color(NKCPaint.cc1.getRed(),NKCPaint.cc1.getGreen(),NKCPaint.cc1.getBlue(),60));
                }
                
               /* if(NKCPaint.bbevel==true){
                alp++;
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));
                
                 
                    redd+=NKCPaint.cc1.getRed()+NKCPaint.rmin.getValue(); 
                    gree+=NKCPaint.cc1.getGreen()+ NKCPaint.gmin.getValue();
                    blu+=NKCPaint.cc1.getBlue()+NKCPaint.bmin.getValue(); 
                 
                 if(blu<0)
                 {
                     blu=0;
                 }
                if(redd<0)
                 {
                     redd=0;
                 }
                if(gree<0)
                 {
                     gree=0;
                 }
                if(blu>255)
                 {
                     blu=255;
                 }
                if(redd>255)
                 {
                     redd=255;
                 }
                if(gree>255)
                 {
                     gree=255;
                 }
                    g.setColor(new Color(redd,gree,blu,100-alp));
                }*/
               /* if(NKCPaint.bbevel==true){
                alp++;
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.JOIN_BEVEL,BasicStroke.JOIN_BEVEL));
                g.setColor(new Color(NKCPaint.cc1.getRed(),NKCPaint.cc1.getGreen(),NKCPaint.cc1.getBlue(),100-alp));
                }*/
                if(NKCPaint.bbevel==true){
                alp++;
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.JOIN_MITER,BasicStroke.JOIN_BEVEL));
                g.setColor(new Color(NKCPaint.cc1.getRed(),NKCPaint.cc1.getGreen(),NKCPaint.cc1.getBlue(),100-alp));
                }
                /*if(NKCPaint.bbevel==true){
                alp++;
                    g.setStroke(new BasicStroke((float)NKCPaint.thick,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL));
                g.setColor(new Color(NKCPaint.cc1.getRed(),NKCPaint.cc1.getGreen(),NKCPaint.cc1.getBlue(),100-alp));
                }*/
                Shape line = new Line2D.Double((double)lx,(double)ly,(double)l2x,(double)l2y);
                l2x = lx; l2y = ly;
		g.draw(line);
                
                  repaint();
                /*
                //g.fillRect(mX,mY,m2X-mX,m2Y-mY);
                g.fillRect(lx, ly, NKCPaint.sew, NKCPaint.seh);
               // g.fillRect(lx+(NKCPaint.sew-9), ly+(NKCPaint.seh-9), NKCPaint.sew, NKCPaint.seh);
                g.fillRect(l2x, l2y, NKCPaint.sew, NKCPaint.seh);
                l2x = lx; l2y = ly;*/
                //repaint();
	}
           public void spray()
	{
          
                  Graphics gr=getGraphics();
		Graphics2D g= (Graphics2D)permI ;
        	g.setColor(NKCPaint.cc1);
               for (int i=0; i<50; i++)
		{
			// For Inner Spray
			 g.setStroke(new BasicStroke((float)0,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			l2x = (lx + (int) Math.round(2*NKCPaint.thick*(Math.random() -0.5))); 
			l2y = (ly + (int) ( ((Math.random()-0.5)*2) * Math.sqrt( (NKCPaint.thick * NKCPaint.thick) - ((lx - l2x) * (lx - l2x)))));
			g.drawLine(l2x, l2y, l2x, l2y); // draws dots of the selected color
		}
               
                  repaint();
                /*
                //g.fillRect(mX,mY,m2X-mX,m2Y-mY);
                g.fillRect(lx, ly, NKCPaint.sew, NKCPaint.seh);
               // g.fillRect(lx+(NKCPaint.sew-9), ly+(NKCPaint.seh-9), NKCPaint.sew, NKCPaint.seh);
                g.fillRect(l2x, l2y, NKCPaint.sew, NKCPaint.seh);
                l2x = lx; l2y = ly;*/
                //repaint();
	}
           
          
 /******************************************************************************************************/
 /******************************************************************************************************/
           
       public void paint(Graphics gm)
    {
       Graphics2D g2 = (Graphics2D) gm;
       gm.setColor(NKCPaint.mpc);
      // storedImage.setData(currentImage.getData());
       gm.fillRect(0, 0, this.getWidth(), this.getHeight());
       Image img=(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/bk.png"))).getImage();
       gm.drawImage(img,0, 0, NeewW.width, NeewW.height,null);
       if(opp1==2)
       {
          Image imj=(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/bk.png"))).getImage();
          gm.drawImage(imj,0, 0,oopi.getWidth(),oopi.getHeight(),null);
       }
        gm.drawImage(currentImage,0,0,this);
        //gm.drawImage(unim[9],0,0,null);
    }

  /******************************************************************************************************/
 /******************************************************************************************************/      
           public void newW()
    {
        opp1=0;
        Graphics gm=getGraphics();
        currentImage = new BufferedImage(NeewW.width ,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        un5=new BufferedImage(NeewW.width ,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        un2=new BufferedImage(NeewW.width ,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        un3=new BufferedImage(NeewW.width ,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        un4=new BufferedImage(NeewW.width ,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        rn1= new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        rn2=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        rn3=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        rn4=new BufferedImage(NeewW.width,NeewW.height ,BufferedImage.TYPE_INT_ARGB);
        gm.setColor(NKCPaint.mpc);
         gm.fillRect(0, 0, this.getWidth(), this.getHeight());

         if(NeewW.bk==1)
              {
                    Image img=(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/bk.png"))).getImage();
                gm.drawImage(img,0, 0, NeewW.width, NeewW.height,null);
              }
                permI= currentImage.createGraphics();
                un1i= un5.createGraphics();
                un2i= un2.createGraphics();
                un3i= un3.createGraphics();
                un4i= un4.createGraphics();
              if(NeewW.bk==0)
              {
				permI.setColor(Color.WHITE);
                                un1i.setColor(Color.WHITE);
                                un2i.setColor(Color.WHITE);
                                un3i.setColor(Color.WHITE);
                                un4i.setColor(Color.WHITE);
				permI.fillRect(0, 0, NeewW.width, NeewW.height);
                                un1i.fillRect(0, 0, NeewW.width, NeewW.height);
                                un2i.fillRect(0, 0, NeewW.width, NeewW.height);
                                un3i.fillRect(0, 0, NeewW.width, NeewW.height);
                                un4i.fillRect(0, 0, NeewW.width, NeewW.height);
              }
              //NKCPaint.jMenuItem11.setEnabled(false);
             //
              
                                  repaint();
    }
        
        /*Graphics2D g2 = (Graphics2D) gm;
        currentImage = new BufferedImage(800,800 ,BufferedImage.TYPE_INT_ARGB);
        Graphics g = currentImage.createGraphics();
	g.fillRect(0,0,WIDTH,HEIGHT);
        super.paintComponents(g2);*/
        
       // storedImage.setData(currentImage.getData());
       // g2.drawImage(, 0, 0, this);
        // storedImage.setData(currentImage.getData());
        /* g2.drawImage(currentImage, 0, 0, this);*/
   //}
           public int save(File f ,int n) throws IOException 
	{	
		
				File file1 = f;
				//String s = getName(file1) +".jpg";
             		if(n == 0)
				{
					f1 = new File(file1.toString() +"." + "PNG"); 
   		          	
					//FileOutputStream out = new FileOutputStream(file); 
			  	}	
				else
				{
					String s = file1.toString();
					try
					{
						s = s.substring(0,s.length()-3);
					}
					catch(Exception e)
					{
					} 
					f1 = new File(s + "." + "PNG");
				}
				//File f1 = new File("test.PNG");
           			ImageIO.write(currentImage, "PNG", f1);
           			return 1; 
           			
        		   }
        	
                 int bgColor;
                 
         
           
          
          public void op(BufferedImage ime1)
          {
              oopi=ime1;
              opp1=2;
              NeewW.bk=1;
                        for(int i1=0;i1<10;i1++)
 {
               if(opp1==2)
     {
         
     }	
 }
               
              Graphics gm=getGraphics();
                    Image img=(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/bk.png"))).getImage();
                gm.drawImage(img,0, 0,ime1.getWidth(),ime1.getHeight(),null);
              
        currentImage = new BufferedImage(ime1.getWidth(),ime1.getHeight(),BufferedImage.TYPE_INT_ARGB);
          permI= currentImage.createGraphics();  
        
            permI.drawImage(ime1, 0, 0, this);
            //
                                  repaint();
          }
           int curr=2;
        
           public void undoo1()
    {
        //un=1;
     if(iam<5)
        {
        rn4.setData(rn3.getData());
        rn3.setData(rn2.getData());
        rn2.setData(rn1.getData());
        rn1.setData(currentImage.getData());
    }
        currentImage.setData(un5.getData());
        un5.setData(un2.getData());
        un2.setData(un3.getData());
        un3.setData(un4.getData());
               iam++;
          repaint();             
    }
    public void redo()
           {
                currentImage.setData(rn1.getData());
               // store2();
               /*if (iam==1)
               {
                currentImage.setData(rn4.getData());    
               }
                if (iam==2)
               {
                currentImage.setData(rn3.getData());    
               }
                 if (iam==3)
               {
                currentImage.setData(rn2.getData());    
               }
                  if (iam==4)
               {
                currentImage.setData(rn1.getData());    
               }*/
                  
               
                 /*if(currentImage.getData()==un4.getData())
                 {
                   currentImage.setData(rn4.getData());
                 }
                 if(currentImage==rn4)
                 {
                   rn4.setData(rn3.getData());
                 }
                 if(currentImage.getData()==rn3.getData())
                 {
                  rn3.setData(rn2.getData());
                 }
                 if(currentImage.getData()==rn2.getData())
                 {
                  rn2.setData(rn1.getData());
                 }
        
       */
               repaint();
           }
           
             
           /*      public void storeR()
           {
                rn4.setData(rn3.getData());
               rn3.setData(rn2.getData());
               rn2.setData(rn1.getData());
               rn1.setData(currentImage.getData());
           }*/
                          
                   public void store2()
           {
               un4.setData(un3.getData());
               un3.setData(un2.getData());
               un2.setData(un5.getData());
               un5.setData(currentImage.getData());
            iam=0;
              im2=1; 
               }
                   
                   
                   
              public Color colorpick(int p1, int p2)
              {
                   
                   System.out.println(currentImage.getRGB(p1, p2)+"hi");
                   return new Color(currentImage.getRGB(p1, p2));
              }
              
              
              
public void rightC(int p1,int p2,int cc,int i,int j)
{
              for(;p1>=0&& p2>=0 && currentImage.getRGB(i,j) == bgColor;i++)
            {
                currentImage.setRGB(i, j, cc);
                 repaint();
            }
              i--;
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        j++;
                        downC(p1,p2,cc,i,j+1);
                      
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        j--;
                        upC(p1,p2,cc,i,j-1);
                       
                    }
}
public void downC(int p1,int p2,int cc,int i,int j)
{            
            for(;p1>=0&& p2>=0 && currentImage.getRGB(i,j) == bgColor;j++)
            {
                currentImage.setRGB(i, j, cc);
                 repaint();
            }
            j--;
           
            if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                         i++;
                        rightC(p1,p2,cc,i+1,j);
                        
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                         i--;
                        leftC(p1,p2,cc,i-1,j);
                        
                    }
                 
}
public void leftC(int p1,int p2,int cc,int i,int j)
{
            for(;p1>=0&& p2>=0 && currentImage.getRGB(i,j) == bgColor;i--)
            {
                currentImage.setRGB(i, j, cc);
                 repaint();
            }
            i++;
                   
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        j++;
                        downC(p1,p2,cc,i,j+1);
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        j--;
                        upC(p1,p2,cc,i,j-1);
                    }
}
public void upC(int p1,int p2,int cc,int i,int j)
{
             for(;p1>=0&& p2>=0 && currentImage.getRGB(i,j) == bgColor;j--)
            {
                currentImage.setRGB(i, j, cc);
                repaint();
            }
             j++;
             
             if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        i++;
                        rightC(p1,p2,cc,i+1,j);
                       
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2))
                    {
                        i--;
                        leftC(p1,p2,cc,i-1,j);
                    }
                   
}
              public void fgo(int p1,int p2)
              {
                  bgColor = currentImage.getRGB(p1,p2);
                  int i=p1,j=p2,c=0;
                  System.out.print("nkcccccccccccccccccccccccccccccccccccccccc");
                  int cc=NKCPaint.cc1.getRGB();
                  currentImage.setRGB(p1, p2, cc);
            try
            {
                while(c==0)
                {
                    c=1;
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1+1,p2))
                    {
                        rightC(p1,p2,cc,i+1,j);
                        c=0;
                    }
                    
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2+1))
                    {
                        downC(p1,p2,cc,i,j+1);
                       c=0;
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1-1,p2))
                    {
                        leftC(p1,p2,cc,i-1,j);
                        c=0;
                    }
                    if(p1>=0&& p2>=0 && bgColor == currentImage.getRGB(p1,p2-1))
                    {
                        upC(p1,p2,cc,i,j-1);
                        c=0;
                    }
                    
              
                }
   
            }
                  catch(Exception ex)
                        {
                        System.out.println("ExceptiiiiiionNNNNNNNNNNnnnn "+"\n");
                        }
              }
              
        public void bucketfill(int p1, int p2)
        {
            int [][]pixel;
            int i=p2,j=p1,k=p1-1,det=1,block=0,er=0;
            repaint();
             int bgColor = currentImage.getRGB(p1,p2);
             int cc=NKCPaint.cc1.getRGB();
             //Color cl=new Color(bgColor);
             System.out.println("aagaya aagaya");
             System.out.println(bgColor+"naooo");
             setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
             try
             {
            for(;p1>=0&& p2>=0 &&currentImage.getRGB(p1,i) == bgColor && det==1&&i<=currentImage.getHeight();i++)
            {
                det=0;
                for(;currentImage.getRGB(j,i) == bgColor && j>0&& i>0&&j<currentImage.getWidth()-1&&i<=currentImage.getHeight();j++)
                {
                    det=1;
                   // System.out.println(""+det);
                    block=3;
                    for(int n=p2;currentImage.getRGB(j,n) == bgColor && j>0&& n>0&&j<currentImage.getWidth()-1&&n<currentImage.getHeight()-1;n++)
                    {
                        block=1;
                        er=n;
                        currentImage.setRGB(j, n, cc);
                    }
                    for(int n=p2-1;currentImage.getRGB(j,n) == bgColor && j>0&& n>0&&j<currentImage.getWidth()-1&&n<currentImage.getHeight()-1;n--)
                    {
                        block=2;
                        er=n;
                        currentImage.setRGB(j, n, cc);
                    }
          
                currentImage.setRGB(j, i, cc);
                }
                for(;currentImage.getRGB(k,i) == bgColor && k>0&& i>0&&k<currentImage.getWidth()-1&&i<currentImage.getHeight()-1;k--)
                {
                    det=1;
                    block=5;
                    try
                    {
                    for(int n=p2-1;currentImage.getRGB(k,n) == bgColor && k>0&& n>0&&k<currentImage.getWidth()-1&&n<currentImage.getHeight()-1;n--)
                    {
                        block=6;
                        currentImage.setRGB(k, n, cc);
                    }
                    }
                    catch(Exception ex)
                            {
                            
                            }
                    try{
                    for(int n=p2+1;currentImage.getRGB(k,n) == bgColor && k>0&& n>0&&k<currentImage.getWidth()-1&&n<currentImage.getHeight()-1;n++)
                    {
                       block=7;
                        currentImage.setRGB(k, n,cc);
                    }
                    }
                    catch(Exception ex)
                            {
                            
                            }
                currentImage.setRGB(k, i, cc);
                }      
               System.out.println(bgColor+"");
             repaint();  
             setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
           }
             catch(Exception excep)
             {
                 System.out.println("ExceptiiiiiionNNNNNNNNNNnnnn "+"\n"+excep.getMessage()+" "+j+" "+i+" "+k+" "+er+
                         "\n\t"+currentImage.getWidth()+" "+currentImage.getHeight()+" "+block);
                 
             }
             
             repaint();  
        }
         /*   bgColor = currentImage.getRGB(p1,p2);
             System.out.println("aagaya aagaya");
              Graphics gr=getGraphics();
		Graphics2D g= (Graphics2D)permI ;
        	g.setColor(NKCPaint.cc1);
                g.setStroke(new BasicStroke((float)0,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			//l2x = (p1 + (int) Math.round(2*NKCPaint.thick*(Math.random() -0.5))); 
			//l2y = (p2 + (int) ( ((Math.random()-0.5)*2) * Math.sqrt( (NKCPaint.thick * NKCPaint.thick) - ((lx - l2x) * (lx - l2x)))));
			
                      g.drawLine(p1, p2,p1, p2);
                        
                                         for(int i=1;p1>0&&p2>0 ;i++)
                                {
		    		
                                    for(int j=1;currentImage.getRGB(p1-j,p2-i) != bgColor;j++)
                                    {
                                    
		    			if(currentImage.getRGB(p1-j,p2-i) != bgColor)
                                        {
                                           currentImage.setRGB(p1-j, p2-i, NKCPaint.cc1.getRGB());
                                           // currentImage.setRGB(p1-j,p2-i,(NKCPaint.cc1).getRGB()); 
                                           System.out.println("yahan bhi");
                                           repaint();
                                        }
		   			else {
                                            repaint();
                                            break;
                                            }
                                    }
                                    
                                    for(int j=1;currentImage.getRGB(p1-j,p2-i) != bgColor;j++)
                                    {
                                    
		    			if(currentImage.getRGB(p1-j,p2-i) != bgColor)
                                        {
                                           currentImage.setRGB(p1-j, p2-i, NKCPaint.cc1.getRGB());
                                           // currentImage.setRGB(p1-j,p2-i,(NKCPaint.cc1).getRGB()); 
                                           System.out.println("yahan bhi");
                                           repaint();
                                        }
		   			else {
                                            repaint();
                                            break;
                                            }
                                    }
                                    for(int k=1;currentImage.getRGB(p1-k,p2-i) != bgColor;k++)
                                    {
                                    
		    			if(currentImage.getRGB(p1-k,p2-i) != bgColor)
                                        {
                                            currentImage.setRGB(p1-k, p2-i, NKCPaint.cc1.getRGB());
                                           // g.drawLine(p1-k, p2-i,p1-k, p2-i);
                                           // currentImage.setRGB(p1-j,p2-i,(NKCPaint.cc1).getRGB()); 
                                           System.out.println("yahan bhi");
                                           repaint();
                                        }
		   			else {
                                            repaint();
                                            break;
                                            }}
                                        for(int kk=1;currentImage.getRGB(p1+kk,p2+i) != bgColor;kk++)
                                    {
                                    
		    			if(currentImage.getRGB(p1+kk,p2+i) != bgColor)
                                        {
                                            currentImage.setRGB(p1+kk, p2+i, NKCPaint.cc1.getRGB());
                                           // g.drawLine(p1-k, p2-i,p1-k, p2-i);
                                           // currentImage.setRGB(p1-j,p2-i,(NKCPaint.cc1).getRGB()); 
                                           System.out.println("yahan bhi");
                                           repaint();
                                        }
		   			else {
                                            repaint();
                                            break;
                                            }
                                    }
                                }
		    		}*/
             
          /*  if (bgColor != (NKCPaint.cc1).getRGB()) 
            {
               // setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                while (true)
			{
                            Point fill = (Point) fillPoints.elementAt(0);  // pop the point
		    		fillPoints.remove(0);
		    	
		    		//get points to fill
		    		fillX = (int) fill.getX();  // coords
		    		fillY = (int) fill.getY();
		    	
		    		//check above and below part 
                                for(int i=1; ;i++)
                                {
		    		if(fillY>0)
				{
                                    for(int j=0;currentImage.getRGB(fillX-j,fillY-i) != bgColor;j++)
                                    {
                                    if(fillX>0)
                                    {
		    			if(currentImage.getRGB(fillX-j,fillY-i) != bgColor)
                                        {
                                            g.drawLine(p1, p2,p1-j, p2-i);
                                            currentImage.setRGB(p1-j,p2-i,(NKCPaint.cc1).getRGB()); 
                                           System.out.println("yahan bhi");
                                        }
		   			else {
                         break;
                                        }}}
		    		}}
                        }
            }
            flp.clear();*/
           
        
}
       
               /*if(currentImage.getData()==un4.getData())
               {
               currentImage.setData(rn4.getData());
               rn4.setData(rn3.getData());
               rn3.setData(rn2.getData());
               rn2.setData(rn1.getData());
               }
                if(currentImage.getData()==un3.getData())
               {
               currentImage.setData(rn3.getData());
               rn4.setData(rn3.getData());
               rn3.setData(rn2.getData());
               rn2.setData(rn1.getData());
               }
                  if(currentImage.getData()==un2.getData())
               {
               currentImage.setData(rn2.getData());
               rn4.setData(rn3.getData());
               rn3.setData(rn2.getData());
               rn2.setData(rn1.getData());
               }
                     if(currentImage.getData()==un5.getData())
               {
               currentImage.setData(rn1.getData());
               rn4.setData(rn3.getData());
               rn3.setData(rn2.getData());
               rn2.setData(rn1.getData());
               }*/                    
        /*       tempImage = storedImage;
		storedImage = oldImag;
		oldImag3.setData(oldImag2.getData());
		oldImag2.setData(oldImag1.getData());
		oldImag1.setData(storedImage.getData());
                //oldImag = tempImage;
		oldImag.setData(currentImage.getData());
           }*/   
        // permI.drawImage(un4,0,0,this);       
      //   un1i.drawImage(un2,0,0,this);
       // un2i.drawImage(un3,0,0,this);
        // un3i.drawImage(un4,0,0,this);
               
       // currentImage=un1;
      /* currentImage=un1;
       un1.setData(un2.getData());
       un2.setData(un3.getData());
       un3.setData(un4.getData());
       
*/        
        
        /*currentImage.setData(oldImag3.getData());
        currentImage=oldImag3.getSubimage(0, 0,NeewW.width, NeewW.height);
        oldImag5.setData(oldImag4.getData());      
        oldImag4.setData(oldImag3.getData());
        
        oldImag3.setData(oldImag2.getData()); 
        oldImag2.setData(oldImag1.getData());  
        oldImag1.setData(oldImag.getData());    
        
        oldImag.setData(blk.getData());
        */
             
              //  repaint();
               //Graphics2D g2=(Graphics2D) un1i;
              /* un4i.drawImage(un3,0,0,this);
               un3i.drawImage(un2,0,0,this);
               un2i.drawImage(un1,0,0,this);
               un1i.drawImage(currentImage,0,0,this);*/
               
        /*              un4.setData(un3.getData());
        un3.setData(un2.getData());
        un2.setData(un1.getData());
        un1.setData(currentImage.getData());*/
        /* oldImag.setData(oldImag1.getData());
        oldImag1.setData(oldImag2.getData());
        oldImag2.setData(oldImag3.getData());
        oldImag3.setData(oldImag4.getData());
        oldImag4.setData(oldImag5.getData());
        oldImag5.setData(currentImage.getData());*/
           
              /*    public void undo()
	{
		//if(oldImage== null)
		//clear();
		//System.out.println("Undo");
	//	undo = true;
		tempImage = oldImag;
		oldImag.setData(oldImag1.getData());
		oldImag.setData(oldImag2.getData());
		//oldImage2.setData(oldImage3.getData()); 
		oldImag2 = oldImag; 
		currentImage = tempImage;
		repaint();
		storedImage.setData(currentImage.getData());
   		//mainp.undoItem.setEnabled(false); 
	}*/
 
	/*public void loadImages(int x , int y )
  	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("Images") );
		//chooser.setAccessory(new MyAccessory(chooser)); 
		chooser.setFileSystemView(chooser.getFileSystemView());
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
         		currentImage = ImageIO.read(chooser.getSelectedFile());
     		}
     		catch (IOException exception)
     		{
     			JOptionPane.showMessageDialog(this, exception);
     		}

     		//addImage( 0,0,currentImage); 
		repaint();
   	}*/	

    
