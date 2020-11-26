package Model;

import javax.swing.*;

public class Archer extends Character implements PlayerSkill{

    public Archer() {
        super("Archer", 10, 450, 80, 75, 10, 200, 200, "Player");
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
