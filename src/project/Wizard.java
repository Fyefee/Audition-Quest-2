package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wizard extends Character {

    public Wizard() {
        super("Wizard", 450, 600, 60, 60, 50);
        super.setPic(new ImageIcon(getClass().getResource("img/wizard.gif")).getImage());
    }
    
    public void skill1() {
        
    }

    public void skill2() {
        
    }

    public void skill3() {
        
    }
    
}
