package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Archer extends Character{

    public Archer() {
        super("Archer", 470, 450, 80, 75, 77, 200, 200);
        super.setPic(new ImageIcon(getClass().getResource("img/Archer/archer2.gif")).getImage());
    }
    
    public void skill1() {
        
    }
    public void skill2() {
        
    }
    public void skill3() {
        
    }
    
}
