/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Background extends JPanel{
    
    Image bg = new ImageIcon(getClass().getResource("img/Background/bg_scale_2.gif")).getImage();
    
    public void draw(Graphics g){
        g.drawImage(bg, 0, 0, this);
    }
    
}
