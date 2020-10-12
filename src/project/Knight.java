package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Knight extends Character {
    
    
    public Knight() {
        super("Knight", 650, 300, 60, 80, 80, 140, 180);
        super.setPic(new ImageIcon(getClass().getResource("img/human_idle.gif")).getImage());
    }

    public void skill1() {
    }

    public void skill2() {

    }

    public void skill3() {

    }

}
