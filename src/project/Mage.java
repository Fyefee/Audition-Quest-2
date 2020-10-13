package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Mage extends Character{

    public Mage() {
        super("Mage", 450, 700, 62, 65, 62);
        super.setPic(new ImageIcon(getClass().getResource("img/mage.gif")).getImage());
    }
    
    public void skill1() {
        
    }
    public void skill2() {
        
    }
    public void skill3() {
        
    }
    
}
