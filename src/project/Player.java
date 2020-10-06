/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class Player extends JPanel{
    
    Image player;
    int x = 300;
    
    public Player(){
        player = new ImageIcon(getClass().getResource("img/human_idle.gif")).getImage();
    }
    
    public void draw(Graphics g) {
        g.drawImage(player, x, 325,140 ,180, this);
    }

}
