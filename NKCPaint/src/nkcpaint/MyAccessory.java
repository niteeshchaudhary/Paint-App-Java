package nkcpaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.*;
import javax.imageio.stream.*;
import javax.swing.border.*;
import java.awt.geom.*;
import javax.print.*;
import java.awt.image.AffineTransformOp.*;
import java.beans.*;	




public class MyAccessory extends JLabel implements PropertyChangeListener
{
	MyAccessory(JFileChooser chooser)
	{
		setPreferredSize(new Dimension(100,100));
		chooser.addPropertyChangeListener(this);
	}
	
	public void propertyChange(PropertyChangeEvent evt)
	{
		if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName()))
		{
			JFileChooser chooser = (JFileChooser)evt.getSource();
			File newFile = (File)evt.getNewValue();
			setBorder(BorderFactory.createEtchedBorder());
			ImageIcon icon = new ImageIcon(newFile.getPath());
			if(icon.getIconWidth()>getWidth())
			icon  = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1  , Image.SCALE_DEFAULT));
			setIcon(icon);	 
		}
	}
} 
