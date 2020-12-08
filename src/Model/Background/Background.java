/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Background;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Administrator
 */
public class Background{
    
    public Image bg;

    public Background(){
        bg = new ImageIcon(getClass().getResource("img/Background/bg_scale_2.gif")).getImage();
    }

    public Background(int difficulty){
        if (difficulty == 1){
            bg = new ImageIcon(getClass().getResource("img/easy_bg_scale.gif")).getImage();
        } else if (difficulty == 2){
            bg = new ImageIcon(getClass().getResource("img/medium_bg_scale.gif")).getImage();
        } else if (difficulty == 3){
            bg = new ImageIcon(getClass().getResource("img/hard_bg_scale.gif")).getImage();
        }
    }
    
}
