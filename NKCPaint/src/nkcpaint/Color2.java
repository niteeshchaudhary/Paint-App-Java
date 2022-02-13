/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkcpaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import static nkcpaint.NKCPaint.cc1;
import static nkcpaint.NKCPaint.cc2;

/**
 *
 * @author Dell
 */
public class Color2 implements ActionListener{
public static int selt1=0,selt2=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton tb=(JToggleButton) e.getSource();
        selt1=0;
        selt2=1;
        cc2=tb.getBackground();
    }
    
}
