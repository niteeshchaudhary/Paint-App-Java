/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkcpaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import static nkcpaint.NKCPaint.c1;
import static nkcpaint.NKCPaint.cc1;

/**
 *
 * @author Dell
 */
public class NKCPaint extends javax.swing.JFrame {

    /**
     * Creates new form NKCPaint
     */
    
    BufferedImage image ,img,im;
    public Graphics ggf=getGraphics();
    int clbt=1,tlbt=1;
    Image myico;
    static JToggleButton c1,c2;
    static int sew=20,seh=20,thick,il,ib,thk=0;//,ref=0;
    static boolean sfill=true,sln=true,drawt,drawcir,drawrec,drawln,drawpn,era,bru,spr,flc,colorpick,nstyl;
    ToolBoxContents mainp;
    static public Color cc1,cc2,cc,mpc,mpc1=Color.black;
    public BufferedImage ime1;
    
    public NKCPaint() throws MalformedURLException {
        initComponents();
      //  myico= (new ImageIcon((getClass().getResource("/nkcpaint/pics/pico.png")))).getImage();
        //setIconImage(myico);
       screen.setBounds(0, 0, 6000, 6000);
        il=screen.getHeight();
        ib=screen.getWidth();
        mainp=new ToolBoxContents();
        ColorBar cb=new ColorBar();
        jInternalFrame2.setLayout(new GridLayout(1,8));
        cb.setLayout(new GridLayout(2,6));
        Panel pan1,pan2,pan3,pan4,pan5,pan6,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
        
        pan1=new Panel();
        pan2=new Panel();
        pan3=new Panel();
        pan4=new Panel();
        pan5=new Panel();
        pan6=new Panel();
        c1=new JToggleButton();
        c2=new JToggleButton();
        c3=new Panel();
        c4=new Panel();
        c5=new Panel();
        c6=new Panel();
        c7=new Panel();
        c8=new Panel();
        c9=new Panel();
        c10=new Panel();
        c11=new Panel();
        c12=new Panel();
        c13=new Panel();
        c14=new Panel();
        c15=new Panel();
        pan1.setLayout(new GridLayout(3,5));
        ButtonGroup bbg=new ButtonGroup();
        bbg.add(c1);
        bbg.add(c2);
        c1.setSelected(false);
        c2.setSelected(false);

//c1.setBorderPainted(true);
        c1.addActionListener(new Color1());
        c2.addActionListener(new Color2());
  //c1.setDebugGraphicsOptions(1);
        /*
        c1.setBackground(cb.getColor());
        c2.setBackground(Color.BLUE);
        cc1=cb.getColor();
        */
        c1.setBackground(Color.white);
        c2.setBackground(Color.black);
        cc1=c1.getBackground();
        cc2=c2.getBackground();
        
        pan1.add(c7);
        pan1.add(c8);
        pan1.add(c9);
        pan1.add(c10);
        pan1.add(c11);
        pan1.add(c4);
        pan1.add(c1);
        pan1.add(c3);
        pan1.add(c2);
         pan1.add(c5);
         pan1.add(c6);
         pan1.add(c11);
         pan1.add(c12);
         pan1.add(c13);
         pan1.add(c14);
         pan1.add(c15);
        jInternalFrame2.add(pan1);
        jInternalFrame2.add(cb);
        jInternalFrame2.add(pan2);
        jInternalFrame2.add(pan3);
        jInternalFrame2.add(pan4);
        jInternalFrame2.add(pan5);
        jInternalFrame2.add(pan6);
        ButtonGroup tgroup  = new ButtonGroup();
       
        tgroup.add(freeselect);
        tgroup.add(rectselect);
        tgroup.add(triangle);
        tgroup.add(line);
        tgroup.add(circle);
        tgroup.add(rectshape);
        tgroup.add(erase);
        tgroup.add(pencil);
        tgroup.add(brushes);
        tgroup.add(spre);
        tgroup.add(bucketfill);
        tgroup.add(zm);
        URL u1;
        try
        {
        //u1=new URL("");//Toolkit.getDefaultToolkit().getDocumentBase();//Toolkit.getDefaultToolkit().getCodeBase();
        }
        catch(Exception e)
        {
       // u1= URL("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\");    
        }
//u1=new url("D:");
      //  jToggleButton3.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\tri.ico"));
        //jToggleButton4.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\line.ico"));
        //jToggleButton5.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\cir.ico"));
        //jToggleButton6.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\rec.ico"));
        //jToggleButton7.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\eraser.ico"));
        //jToggleButton8.setIcon(new ImageIcon("d:\\javaprog\\NKCPaint\\src\\nkcpaint\\pencl.ico"));
       mainp.setBackground(mpc1);
       mpc=mainp.getBackground();
        mainp.setBounds(0, 0,screen.getWidth(),screen.getHeight());
        mainp.setIgnoreRepaint(true);
        
       // jPanel1.setLayout(new BorderLayout());
       /* JScrollPane sp=new JScrollPane(mainp);
           sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBackground(Color.red);
        sp.setAutoscrolls(true);
        sp.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        sp.setViewportView(mainp);*/
       
        
        
        
       /* Graphics g=getGraphics();
int formats = 0;
                    if (image != null)
			{
				if(formats == 0)
					g.drawImage(image, 0, 0, null);
            		else if(formats ==1)
				{
					float fw = image.getWidth() -1;
					float fh = image.getHeight()-1;
					float fx = 0;
					float fy = 0;
					Shape shape = new java.awt.geom.Ellipse2D.Float(fx , fy , fw ,fh);
					g.setClip(shape);
					g.drawImage(image , 0 ,0, null);
				}
				else if(formats == 2)
				{
					float fw = image.getWidth() -1;
					float fh = image.getHeight()-1;
					float r = 0;
					float fx = 0;
					float fy = 0;
					if(fw>fh)
						r  = fw;
					else 
						r = fh;  
					Shape shape = new java.awt.geom.Ellipse2D.Float(fx , fy , fw,fw);
					g.setClip(shape);
					g.drawImage(image,0,0,null);
				}         
                                im=image;
                                ImageIO.write(im , "PNG" , f);
                        }*/
		// storedImage contains the storedImage
    }
    public void reset()
    {
        drawt=false;
        drawcir=false;
        drawrec=false;
        drawln=false;
        drawpn=false;
        era=false;
        bru=false;
        spr=false;
        colorpick=false;
        flc=false;
    }
    public void mynw()
    {
                if(NeewW.suc==1)
       {
           
           //mainp.setBounds(0,0,NeewW.width,NeewW.height);
                  // jPanel1.setBounds(0,0,NeewW.width,NeewW.height);
                   mainp.setSize(NeewW.width, NeewW.height);
                   screen.setSize(NeewW.width, NeewW.height);
                   screen.add(mainp);
                   scroll.setViewportView(screen);
                   mainp.newW();
            
       }
    }
     
     /* This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        brushbgrp = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        scroll = new javax.swing.JScrollPane();
        screen = new javax.swing.JPanel();
        toolbox = new javax.swing.JInternalFrame();
        freeselect = new javax.swing.JToggleButton();
        rectselect = new javax.swing.JToggleButton();
        triangle = new javax.swing.JToggleButton();
        line = new javax.swing.JToggleButton();
        circle = new javax.swing.JToggleButton();
        rectshape = new javax.swing.JToggleButton();
        erase = new javax.swing.JToggleButton();
        pencil = new javax.swing.JToggleButton();
        brushes = new javax.swing.JToggleButton();
        spre = new javax.swing.JToggleButton();
        bucketfill = new javax.swing.JToggleButton();
        zm = new javax.swing.JToggleButton();
        opnpoly = new javax.swing.JToggleButton();
        imag = new javax.swing.JToggleButton();
        fillpoly = new javax.swing.JToggleButton();
        colpick = new javax.swing.JToggleButton();
        dsn = new javax.swing.JToggleButton();
        curve = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        tabs = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        brush = new javax.swing.JToolBar();
        simp = new javax.swing.JCheckBox();
        rs = new javax.swing.JCheckBox();
        rm = new javax.swing.JCheckBox();
        rb = new javax.swing.JCheckBox();
        wthspr = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        rmin = new javax.swing.JSlider();
        gmin = new javax.swing.JSlider();
        bmin = new javax.swing.JSlider();
        sray = new javax.swing.JToolBar();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        design = new javax.swing.JToolBar();
        imgtool = new javax.swing.JToolBar();
        eraser = new javax.swing.JToolBar();
        fill = new javax.swing.JToolBar();
        zoom = new javax.swing.JToolBar();
        rect = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        rds = new javax.swing.JSlider();
        rdv = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        tri = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        colorpicker = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        clpl = new javax.swing.JLabel();
        tc1 = new javax.swing.JButton();
        tc2 = new javax.swing.JButton();
        tc3 = new javax.swing.JButton();
        tc4 = new javax.swing.JButton();
        tc5 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NKCPaint");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(2);
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/pico.png")).getImage());
        setIconImages(null);
        setLocationByPlatform(true);
        setState(2);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jInternalFrame2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 204, 0)));
        jInternalFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jInternalFrame2.setTitle("ColorBox");
        jInternalFrame2.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/cbb.png"))); // NOI18N
        jInternalFrame2.setVisible(true);

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setToolTipText("");
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setDoubleBuffered(true);
        scroll.setMaximumSize(new java.awt.Dimension(60000, 60000));

        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        screen.setEnabled(false);

        javax.swing.GroupLayout screenLayout = new javax.swing.GroupLayout(screen);
        screen.setLayout(screenLayout);
        screenLayout.setHorizontalGroup(
            screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        screenLayout.setVerticalGroup(
            screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        scroll.setViewportView(screen);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        toolbox.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        toolbox.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        toolbox.setTitle("ToolBox");
        toolbox.setAlignmentX(1.0F);
        toolbox.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/tool.png"))); // NOI18N
        toolbox.setMaximumSize(new java.awt.Dimension(102, 2147483647));
        toolbox.setPreferredSize(new java.awt.Dimension(102, 620));
        try {
            toolbox.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        toolbox.setVisible(true);
        toolbox.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                toolboxInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        freeselect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/FreeSelect.png"))); // NOI18N
        freeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeselectActionPerformed(evt);
            }
        });

        rectselect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/RectSelect.png"))); // NOI18N
        rectselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectselectActionPerformed(evt);
            }
        });

        triangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/tri.png"))); // NOI18N
        triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleActionPerformed(evt);
            }
        });

        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/line.png"))); // NOI18N
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineActionPerformed(evt);
            }
        });

        circle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/cir.png"))); // NOI18N
        circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleActionPerformed(evt);
            }
        });

        rectshape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/rec.png"))); // NOI18N
        rectshape.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        rectshape.setFocusPainted(false);
        rectshape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectshapeActionPerformed(evt);
            }
        });

        erase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/eraser.png"))); // NOI18N
        erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseActionPerformed(evt);
            }
        });

        pencil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/pencl.png"))); // NOI18N
        pencil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencilActionPerformed(evt);
            }
        });

        brushes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/brush.png"))); // NOI18N
        brushes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brushesActionPerformed(evt);
            }
        });

        spre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/spray.png"))); // NOI18N
        spre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spreActionPerformed(evt);
            }
        });

        bucketfill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/fill.png"))); // NOI18N
        bucketfill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucketfillActionPerformed(evt);
            }
        });

        zm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/zoom.png"))); // NOI18N

        opnpoly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/pine.png"))); // NOI18N
        opnpoly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opnpolyActionPerformed(evt);
            }
        });

        imag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/im50.png"))); // NOI18N
        imag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagActionPerformed(evt);
            }
        });

        fillpoly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/polygon.png"))); // NOI18N
        fillpoly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillpolyActionPerformed(evt);
            }
        });

        colpick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/cpic.png"))); // NOI18N
        colpick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colpickActionPerformed(evt);
            }
        });

        dsn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/ds.PNG"))); // NOI18N
        dsn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsnActionPerformed(evt);
            }
        });

        curve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/curv.png"))); // NOI18N
        curve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curveActionPerformed(evt);
            }
        });

        jLabel2.setText("Thickness");

        jSlider2.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider2.setValue(0);
        jSlider2.setMaximumSize(new java.awt.Dimension(10, 40));
        jSlider2.setMinimumSize(new java.awt.Dimension(10, 40));
        jSlider2.setPreferredSize(new java.awt.Dimension(10, 45));
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jTextField1.setColumns(3);
        jTextField1.setText("010");
        jTextField1.setMaximumSize(new java.awt.Dimension(30, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("OutLn");
        jCheckBox2.setFocusable(false);
        jCheckBox2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/outp.png"))); // NOI18N
        jCheckBox2.setPreferredSize(new java.awt.Dimension(55, 35));
        jCheckBox2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("  Filled");
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/fillp.png"))); // NOI18N
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolboxLayout = new javax.swing.GroupLayout(toolbox.getContentPane());
        toolbox.getContentPane().setLayout(toolboxLayout);
        toolboxLayout.setHorizontalGroup(
            toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolboxLayout.createSequentialGroup()
                .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(freeselect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(triangle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brushes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opnpoly, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imag, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bucketfill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pencil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectshape, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillpoly, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectselect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colpick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(toolboxLayout.createSequentialGroup()
                .addComponent(dsn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(curve, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(toolboxLayout.createSequentialGroup()
                .addComponent(jCheckBox1)
                .addGap(1, 1, 1)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(toolboxLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2))
            .addGroup(toolboxLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(toolboxLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        toolboxLayout.setVerticalGroup(
            toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolboxLayout.createSequentialGroup()
                .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toolboxLayout.createSequentialGroup()
                        .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freeselect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(triangle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(circle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brushes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(opnpoly, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(imag))
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(bucketfill, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(toolboxLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(erase, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolboxLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(pencil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(rectshape, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(toolboxLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(fillpoly, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(rectselect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toolboxLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(colpick, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(toolboxLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(spre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dsn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curve))
                .addGap(17, 17, 17)
                .addGroup(toolboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.setName(""); // NOI18N
        tabs.setOpaque(true);

        home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        home.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar3.setRollover(true);
        jToolBar3.setName("Shape Settings"); // NOI18N
        jToolBar3.add(jLabel1);

        home.add(jToolBar3);

        tabs.addTab("Home", home);

        brush.setRollover(true);

        brushbgrp.add(simp);
        simp.setSelected(true);
        simp.setText("Simple Brush");
        simp.setFocusable(false);
        simp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        simp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        simp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpActionPerformed(evt);
            }
        });
        brush.add(simp);

        brushbgrp.add(rs);
        rs.setText("Round");
        rs.setFocusable(false);
        rs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsActionPerformed(evt);
            }
        });
        brush.add(rs);

        brushbgrp.add(rm);
        rm.setText("with alpha");
        rm.setFocusable(false);
        rm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmActionPerformed(evt);
            }
        });
        brush.add(rm);

        brushbgrp.add(rb);
        rb.setText("reduce alpha");
        rb.setFocusable(false);
        rb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt);
            }
        });
        brush.add(rb);

        wthspr.setText("With Spray");
        wthspr.setFocusable(false);
        wthspr.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        wthspr.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        wthspr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wthsprActionPerformed(evt);
            }
        });
        brush.add(wthspr);

        jCheckBox3.setText("jCheckBox3");
        jCheckBox3.setFocusable(false);
        jCheckBox3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        brush.add(jCheckBox3);

        rmin.setMaximum(50);
        rmin.setMinimum(-50);
        rmin.setToolTipText("red");
        rmin.setValue(0);
        rmin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rminStateChanged(evt);
            }
        });
        brush.add(rmin);

        gmin.setMaximum(50);
        gmin.setMinimum(-50);
        gmin.setToolTipText("green");
        gmin.setValue(0);
        brush.add(gmin);

        bmin.setMaximum(50);
        bmin.setMinimum(-50);
        bmin.setToolTipText("blue");
        bmin.setValue(0);
        brush.add(bmin);

        tabs.addTab("Brush", brush);

        sray.setRollover(true);

        jCheckBox5.setText("jCheckBox5");
        jCheckBox5.setFocusable(false);
        jCheckBox5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sray.add(jCheckBox5);

        jCheckBox6.setText("jCheckBox6");
        jCheckBox6.setFocusable(false);
        jCheckBox6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sray.add(jCheckBox6);

        tabs.addTab("Spray", sray);

        design.setRollover(true);
        tabs.addTab("Design", design);

        imgtool.setRollover(true);
        tabs.addTab("Image", imgtool);

        eraser.setRollover(true);
        tabs.addTab("Eraser", eraser);

        fill.setRollover(true);
        tabs.addTab("Fill", fill);

        zoom.setRollover(true);
        tabs.addTab("Zoom", zoom);

        rect.setRollover(true);

        jLabel4.setText("Rounded Edge      ");
        rect.add(jLabel4);

        rds.setValue(0);
        rds.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdsStateChanged(evt);
            }
        });
        rect.add(rds);

        rdv.setText("00");
        rdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdvActionPerformed(evt);
            }
        });
        rect.add(rdv);

        jTextField3.setEditable(false);
        rect.add(jTextField3);

        tabs.addTab("Rectangle", rect);

        tri.setRollover(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        tri.add(jPanel4);

        tabs.addTab("Triangle", tri);

        colorpicker.setRollover(true);

        jLabel3.setText("Color  ~  ");
        colorpicker.add(jLabel3);

        clpl.setText("          ");
        clpl.setOpaque(true);
        clpl.setPreferredSize(new java.awt.Dimension(30, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(clpl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tc1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tc2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tc3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tc4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tc5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clpl, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(tc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tc4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tc5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        colorpicker.add(jPanel2);

        tabs.addTab("Color Picker", colorpicker);

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/nnn.png"))); // NOI18N
        jMenuItem2.setText("New");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(529, 40));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/op.png"))); // NOI18N
        jMenuItem3.setText("Open");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(529, 46));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/save.png"))); // NOI18N
        jMenuItem4.setText("Save");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(529, 68));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/saveas.png"))); // NOI18N
        jMenuItem5.setText("Save As");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(529, 77));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/exit.png"))); // NOI18N
        jMenuItem6.setText("Exit");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(529, 59));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar2.add(jMenu1);

        jMenu4.setText("Edit");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/undo.png"))); // NOI18N
        jMenuItem10.setText("Undo");
        jMenuItem10.setEnabled(false);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/redo.png"))); // NOI18N
        jMenuItem11.setText("Redo");
        jMenuItem11.setEnabled(false);
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/cut.png"))); // NOI18N
        jMenuItem7.setText("Cut");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/copy.png"))); // NOI18N
        jMenuItem8.setText("Copy");
        jMenu4.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/paste.png"))); // NOI18N
        jMenuItem9.setText("Paste");
        jMenu4.add(jMenuItem9);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("View");

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("ToolBox");
        jCheckBoxMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/tool.png"))); // NOI18N
        jCheckBoxMenuItem1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMenuItem1ItemStateChanged(evt);
            }
        });
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("ColorBox");
        jCheckBoxMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/cb.png"))); // NOI18N
        jCheckBoxMenuItem2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMenuItem2ItemStateChanged(evt);
            }
        });
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem2);

        jMenuBar2.add(jMenu5);

        jMenu6.setText("Insert");
        jMenuBar2.add(jMenu6);

        jMenu8.setText("Help?");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenuBar2.add(jMenu8);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(toolbox, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        tabs.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
  ABT m1=new ABT();
  Thread t=new Thread(m1);
  t.start();       
    }//GEN-LAST:event_jMenuItem1ActionPerformed
Boolean enab=false;
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          // NeewW.main("nn","nm");
        if(!enab)
        {
            screen.enable(true);
        }
        NeewW m1=new NeewW();
        Thread t=new Thread(m1);
        t.start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ItemStateChanged
  
    }//GEN-LAST:event_jCheckBoxMenuItem1ItemStateChanged

    private void jCheckBoxMenuItem2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ItemStateChanged

    }//GEN-LAST:event_jCheckBoxMenuItem2ItemStateChanged

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
if (clbt==1)
{
    jInternalFrame2.setVisible(false);
    clbt=0;
}  
else if(clbt==0)
{
    jInternalFrame2.setVisible(true);
    clbt=1;
}
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
               if (tlbt==1)
            {
            toolbox.setVisible(false);
            tlbt=0;
             }  
            else if (tlbt==0)
            {
            toolbox.setVisible(true);
             tlbt=1;
            }       
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
   this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //((JFrame)evt.getSource()).dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

    JFileChooser chooser = new JFileChooser();
	chooser.setCurrentDirectory(new File("Images") ); 
	chooser.setDialogTitle(" Save Image ");
	chooser.setFileFilter(new javax.swing.filechooser.FileFilter( )
	{
		public boolean accept(File f)
            {  
            	String name = f.getName().toLowerCase();
               	return name.endsWith(".gif")
             	|| name.endsWith(".jpg")
                  || name.endsWith(".jpeg")
			|| name.endsWith(".png")
                  || f.isDirectory();
            }
           	public String getDescription()
            {  
            	return "PNG Image";
            }
     });

     int r = chooser.showSaveDialog(this);
     if(r != JFileChooser.APPROVE_OPTION) return;
     File f = chooser.getSelectedFile();
     System.out.println("" + f);
        try {
            int k = mainp.save(f,0);
        } catch (IOException ex) {
            Logger.getLogger(NKCPaint.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
NeewW.bk=1;
        JFileChooser chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));
       chooser.setAccessory(new MyAccessory(chooser));
      
       chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
     		{  
            public boolean accept(File f)
            {  
               String name = f.getName().toLowerCase();
               return name.endsWith(".gif")
                  || name.endsWith(".jpg")
                  || name.endsWith(".jpeg")
			|| name.endsWith(".png")
			|| name.endsWith(".PNG")
                  || f.isDirectory();
            }    

            @Override
            public String getDescription() {
                  return "Image files";
            }
            });
        int r = chooser.showOpenDialog(this);
      if(r != JFileChooser.APPROVE_OPTION) return;

      try
      {
            File file = chooser.getSelectedFile();
         ime1 = ImageIO.read(chooser.getSelectedFile());
      }
      catch (IOException exception)
      {
         JOptionPane.showMessageDialog(this, exception);
      }
      screen.add(mainp);
           //mainp.setBounds(0,0,NeewW.width,NeewW.height);
                  // jPanel1.setBounds(0,0,NeewW.width,NeewW.height);
                   mainp.setSize(ime1.getWidth(), ime1.getHeight());
                   screen.setSize(ime1.getWidth(), ime1.getHeight());
                   mainp.newW();
      mainp.op(ime1);         
     
	
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void toolboxInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_toolboxInternalFrameIconified

    }//GEN-LAST:event_toolboxInternalFrameIconified

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        JCheckBox n;
        n = (JCheckBox)(evt.getSource());
        if(n.isSelected()==true)
        {
              jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/fillp.png")));
            sfill=true;
        }
        if(n.isSelected()==false)
        {
            sfill=false;
             jCheckBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/fillnp.png")));
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        JCheckBox n;
        n = (JCheckBox)(evt.getSource());
        if(n.isSelected()==true)
        {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/outp.png")));
            sln=true;
        }
        if(n.isSelected()==false)
        {
            jCheckBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nkcpaint/pics/outnp.png")));
            sln=false;
        }

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        thick=Integer.parseInt(((JTextField)evt.getSource()).getText());
        if(thick>100)
        {
            thick=100;
            jTextField1.setText(100+"");
        }
        if(thick<0)
        {
            thick=0;
            jTextField1.setText(0+"");
        }
        jSlider2.setValue(thick);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        thick=((JSlider)evt.getSource()).getValue();
        jTextField1.setText(thick+"");
    }//GEN-LAST:event_jSlider2StateChanged

    private void curveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curveActionPerformed

    private void bucketfillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucketfillActionPerformed
        reset();
        flc=true;      
    }//GEN-LAST:event_bucketfillActionPerformed

    private void spreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spreActionPerformed
        reset();
        spr=true;
    }//GEN-LAST:event_spreActionPerformed
static boolean sim=true,bbevel=false,bround=false,bmiter=false;
    private void brushesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brushesActionPerformed
        reset();
        bbevel=false;
        bmiter=false;
        bround=false;
        if(rs.isSelected())
        {
            bround=true;
         
        }
        else if(simp.isSelected())
        {
            sim=true;
           
        }
        else if(rm.isSelected())
        {
            bmiter=true;
          
        }
        else if(rb.isSelected())
        {
            bbevel=true;
         
        }
        bru=true;
    }//GEN-LAST:event_brushesActionPerformed

    private void pencilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencilActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        drawpn=true;
    }//GEN-LAST:event_pencilActionPerformed

    private void eraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseActionPerformed
        reset();
        era=true;
    }//GEN-LAST:event_eraseActionPerformed

    private void rectshapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectshapeActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tabs.setSelectedComponent(rect);
        drawrec=true;
    }//GEN-LAST:event_rectshapeActionPerformed

    private void circleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        drawcir=true;
    }//GEN-LAST:event_circleActionPerformed

    private void lineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        drawln=true;

    }//GEN-LAST:event_lineActionPerformed

    private void triangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        drawt=true;
    }//GEN-LAST:event_triangleActionPerformed

    private void dsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsnActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        nstyl=true;
    }//GEN-LAST:event_dsnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(NeewW.ok==1)
        {
            mynw();
            NeewW.ok=0;
        }
    }//GEN-LAST:event_formWindowActivated

    private void rectselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectselectActionPerformed
        
    }//GEN-LAST:event_rectselectActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JFileChooser chooser = new JFileChooser();
	chooser.setCurrentDirectory(new File("Images") ); 
	chooser.setDialogTitle(" Save Image ");
	chooser.setFileFilter(new javax.swing.filechooser.FileFilter( )
        {
                	public boolean accept(File f)
                        {  
                            String name = f.getName().toLowerCase();
                            return name.endsWith(".gif")
                                || name.endsWith(".jpg")
                                || name.endsWith(".jpeg")
                                || name.endsWith(".png")
                                || f.isDirectory();
                        }
                        public String getDescription()
                        {  
                            return "PNG Image";
                        }
        });
     int r = chooser.showSaveDialog(this);
     if(r != JFileChooser.APPROVE_OPTION) return;
     File f = chooser.getSelectedFile();
     System.out.println("" + f);
     
        try {
            int k = mainp.save(f,0);
        } catch (IOException ex) {
            Logger.getLogger(NKCPaint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void imagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagActionPerformed
   
    }//GEN-LAST:event_imagActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        mainp.undoo1();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if(mainp.iam>0)
        {
            jMenuItem11.enableInputMethods(true);
        mainp.redo();
        }
        else
        {
         jMenuItem11.enableInputMethods(false);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if(mainp.im2==1)
        {
            jMenuItem10.setEnabled(true);
        }
        if(mainp.iam>0)
        {
            jMenuItem11.setEnabled(true);
        }       
    }//GEN-LAST:event_formMouseMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private void freeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeselectActionPerformed
       
    }//GEN-LAST:event_freeselectActionPerformed

    private void colpickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colpickActionPerformed
        reset();
        screen.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));     
        tabs.setSelectedComponent(colorpicker);
        colorpick=true;
    }//GEN-LAST:event_colpickActionPerformed

    private void opnpolyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opnpolyActionPerformed
        
    }//GEN-LAST:event_opnpolyActionPerformed

    private void fillpolyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillpolyActionPerformed
      
    }//GEN-LAST:event_fillpolyActionPerformed

    private void rdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdvActionPerformed
        thk=Integer.parseInt(((JTextField)evt.getSource()).getText());
        if(thk>100)
        {
            thk=100;
            rdv.setText(100+"");
        }
        if(thk<0)
        {
            thk=0;
            rdv.setText(0+"");
        }
        rds.setValue(thk);     
    }//GEN-LAST:event_rdvActionPerformed

    private void rdsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdsStateChanged
        thk=((JSlider)evt.getSource()).getValue();
        rdv.setText(thk+"");
    }//GEN-LAST:event_rdsStateChanged

    private void simpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpActionPerformed
        typBrush();
    }//GEN-LAST:event_simpActionPerformed

    private void rsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsActionPerformed
        typBrush();
    }//GEN-LAST:event_rsActionPerformed

    private void rmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmActionPerformed
        typBrush();
    }//GEN-LAST:event_rmActionPerformed

    private void rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActionPerformed
        typBrush();
    }//GEN-LAST:event_rbActionPerformed

    private void rminStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rminStateChanged
   // evt.getSource()
    }//GEN-LAST:event_rminStateChanged
    static boolean brs_wth_spry=false;
    private void wthsprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wthsprActionPerformed

    }//GEN-LAST:event_wthsprActionPerformed

   void typBrush()
   {
        sim=false;
        bround=false;
        bmiter=false;
        bbevel=false;
        
        if(wthspr.isSelected()==true)
        {
            //brs_wth_spry=true;
            spr=true;
        }
        else{
            //brs_wth_spry=false;
            spr=false;
        }
      
        if(rs.isSelected())
        {
            bround=true;
         
        }
        else if(simp.isSelected())
        {
            sim=true;
           
        }
        else if(rm.isSelected())
        {
            bmiter=true;
          
        }
        else if(rb.isSelected())
        {
            bbevel=true;
        }
       
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
         /* 
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        */
        // /* 
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
          // */
        try
      {
                    new NKCPaint().setVisible(true);
                    }
                    catch(Exception ex)
                    {
                    }
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JSlider bmin;
    private javax.swing.JToolBar brush;
    private javax.swing.ButtonGroup brushbgrp;
    private javax.swing.JToggleButton brushes;
    private javax.swing.JToggleButton bucketfill;
    private javax.swing.JToggleButton circle;
    public static javax.swing.JLabel clpl;
    public static javax.swing.JToolBar colorpicker;
    private javax.swing.JToggleButton colpick;
    private javax.swing.JToggleButton curve;
    private javax.swing.JToolBar design;
    private javax.swing.JToggleButton dsn;
    private javax.swing.JToggleButton erase;
    private javax.swing.JToolBar eraser;
    private javax.swing.JToolBar fill;
    private javax.swing.JToggleButton fillpoly;
    private javax.swing.JToggleButton freeselect;
    public static javax.swing.JSlider gmin;
    private javax.swing.JPanel home;
    private javax.swing.JToggleButton imag;
    private javax.swing.JToolBar imgtool;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToggleButton line;
    private javax.swing.JToggleButton opnpoly;
    private javax.swing.JToggleButton pencil;
    private javax.swing.JCheckBox rb;
    private javax.swing.JSlider rds;
    private javax.swing.JTextField rdv;
    public static javax.swing.JToolBar rect;
    private javax.swing.JToggleButton rectselect;
    private javax.swing.JToggleButton rectshape;
    private javax.swing.JCheckBox rm;
    public static javax.swing.JSlider rmin;
    private javax.swing.JCheckBox rs;
    private javax.swing.JPanel screen;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JCheckBox simp;
    private javax.swing.JToggleButton spre;
    private javax.swing.JToolBar sray;
    public static javax.swing.JTabbedPane tabs;
    private javax.swing.JButton tc1;
    private javax.swing.JButton tc2;
    private javax.swing.JButton tc3;
    private javax.swing.JButton tc4;
    private javax.swing.JButton tc5;
    private javax.swing.JInternalFrame toolbox;
    private javax.swing.JToolBar tri;
    private javax.swing.JToggleButton triangle;
    private javax.swing.JCheckBox wthspr;
    private javax.swing.JToggleButton zm;
    private javax.swing.JToolBar zoom;
    // End of variables declaration//GEN-END:variables
}






class ColorButton extends JToggleButton
{
	public ColorButton(Color initialColor)
	{
		super();
		setBackground(SystemColor.control);
		
		mColor = initialColor;
		
		setMargin( new Insets(0,0,0,0 ) ) ;
		
		setToolTipText(mColor+" " );
		
	}
	
	public Color getColor()
	{
		return mColor;
	}

	public Dimension getPreferredSize()
	{
		int width = getInsets().left + WIDTH + getInsets().right;
		int height = getInsets().top + HEIGHT+  getInsets().bottom;
		
		return new Dimension( width,height);
	} 	  

	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	
	public Dimension getMaximumSize()
	{
		return getPreferredSize();
	}

	
	public void paintComponent(Graphics g)
	{
		int x = getInsets().left;
		int y = getInsets().top;
		
		g.setColor(mColor);
		g.fillRect(x,y,WIDTH,HEIGHT);
	}

	protected void processMouseEvent(MouseEvent e)
	{
		if((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0 && e.getID() == MouseEvent.MOUSE_PRESSED)
		{
			Color newColor = JColorChooser.showDialog(null,"Choose a Color", mColor);
			
			if(newColor != null)
			{
				mColor = newColor;
				setToolTipText(mColor + " ");
					
				repaint();
				
				if(isSelected())
				{
					fireStateChanged();
				}
			}
		}	
		else
		{
			super.processMouseEvent( e );
		}
	}
	
	private final int WIDTH = 16;
	private final int HEIGHT = 16;

	private Color mColor;
}

class ColorBar extends JToolBar implements ItemListener, javax.swing.event.ChangeListener
{
    ColorButton redButton;
    ColorButton orangeButton;
    ColorButton greenButton;
    ColorButton blueButton;
    ColorButton yellowButton;
    ColorButton blackButton;
    ColorButton whiteButton;
    ColorButton purpleButton;
    ColorButton darkGray;
    ColorButton lightGray;
    ColorButton Gray;
    ColorButton cyan;
    ColorButton pink;
	
    public ColorBar()
    {
		super();

		mChangeListeners = new EventListenerList();
		
	
		ButtonGroup group  = new ButtonGroup();
		
                blackButton = new ColorButton(Color.black);
		blackButton.addItemListener(this);
		blackButton.addChangeListener(this);
		group.add(blackButton);
                
                darkGray = new ColorButton(Color.DARK_GRAY);
		darkGray.addItemListener(this);
		darkGray.addChangeListener(this);
                group.add(darkGray);
                
                blueButton = new ColorButton(Color.blue);
		blueButton.addItemListener(this);
		blueButton.addChangeListener(this);
		group.add(blueButton);
                
		redButton = new ColorButton(Color.red);
		redButton.addItemListener(this);
		redButton.addChangeListener(this);
		group.add(redButton);
		
                
                purpleButton = new ColorButton(Color.magenta);
		purpleButton.addItemListener(this);
		purpleButton.addChangeListener(this);
                group.add(purpleButton);
                
		greenButton = new ColorButton(Color.green);
		greenButton.addItemListener(this);
		greenButton.addChangeListener(this);
		group.add(greenButton);
                
                orangeButton = new ColorButton(Color.orange);
		orangeButton.addItemListener(this);
		orangeButton.addChangeListener(this);
		group.add(orangeButton);
                
                lightGray = new ColorButton(Color.lightGray);
		lightGray.addItemListener(this);
                lightGray.addChangeListener(this);
                group.add(lightGray);

                yellowButton = new ColorButton(Color.yellow);
		yellowButton.addItemListener(this);
		yellowButton.addChangeListener(this);
		group.add(yellowButton);
		
		whiteButton = new ColorButton(Color.white);
		whiteButton.addItemListener(this);
                whiteButton.addChangeListener(this);
		group.add(whiteButton);
                
                
                /*Gray = new ColorButton(Color.gray);
		Gray.addItemListener(this);
		Gray.addChangeListener(this);
                add(Gray);
		group.add(Gray);*/
                
                cyan = new ColorButton(Color.CYAN);
		cyan.addItemListener(this);
		cyan.addChangeListener(this);
                group.add(cyan);
                
                pink = new ColorButton(Color.PINK);
		pink.addItemListener(this);
		pink.addChangeListener(this);
                group.add(pink);
                
		//whiteButton.setSelected(true);
                add(blackButton);
                add(darkGray);
                add(blueButton);
                add(redButton);
                add(purpleButton);
                add(greenButton);
                add(orangeButton);
                add(lightGray);
                add(yellowButton);
                add(whiteButton);
                add(cyan);
                add(pink);
                
                blackButton.setSelected(true);
	}

	public Color getColor()
	{           
		return mCurrentColor;
	}

	public void setfloatable(boolean ch)
	{
		super.setFloatable(ch);
	}

	public void addChangeListener(javax.swing.event.ChangeListener listener)
	{
		mChangeListeners.add(javax.swing.event.ChangeListener.class,listener);
	}
	
	public void removeChangeListener(javax.swing.event.ChangeListener listener)
	{
		mChangeListeners.remove(javax.swing.event.ChangeListener.class,listener);
	}

	protected void fireChangeEvent(ChangeEvent newEvent)
	{
		Object[] listeners = mChangeListeners.getListenerList();
	
		for(int i = listeners.length-2 ;i>=0;i-=2)
		{
			if(listeners[i]==javax.swing.event.ChangeListener.class)
			{
				((javax.swing.event.ChangeListener)listeners[i+1]).stateChanged(newEvent);
			}
		}
	} 

	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			mCurrentColor = ((ColorButton)e.getSource()).getColor();
			NKCPaint.cc=mCurrentColor;
                        
                        if(Color2.selt1==1)
                        { 
                        NKCPaint.c1.setBackground(mCurrentColor);
                        NKCPaint.cc1=NKCPaint.c1.getBackground();
                        }
                         if(Color2.selt2==1)
                        {
                            NKCPaint.c2.setBackground(mCurrentColor);
                            NKCPaint.cc2=NKCPaint.c2.getBackground();
                        }
			ChangeEvent evt = new ChangeEvent(this);
			fireChangeEvent(evt);
		}
	}

	public void stateChanged(ChangeEvent e)
	{
		mCurrentColor = ((ColorButton)e.getSource()).getColor();
		ChangeEvent evt = new ChangeEvent(this);
		fireChangeEvent(evt);
	}

	private Color mCurrentColor;
	private EventListenerList mChangeListeners;

}
