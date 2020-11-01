package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Archer extends Character{

    public Archer() {
        super("Archer", 470, 450, 80, 75, 10, 200, 200, "Player");
        super.setX(100); 
        super.setY(300);
        super.setPic(new ImageIcon(getClass().getResource("img/Archer/archer2.gif")).getImage());
    }
    
    public void skill1() {
        
    }
    public void skill2() {
        
    }
    public void skill3() {
        
    }
    
}
