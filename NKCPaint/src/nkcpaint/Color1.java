/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkcpaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static nkcpaint.NKCPaint.cc1;
import static nkcpaint.NKCPaint.cc2;

/**
 *
 * @author Dell
 */
public class Color1 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
     JToggleButton tb=(JToggleButton)e.getSource();
     Color2.selt1=1;
     Color2.selt2=0;
     cc1=tb.getBackground();
    }
}
